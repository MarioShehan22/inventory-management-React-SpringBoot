package com.pos.system.service.impl;

import com.pos.system.dto.ItemDetailDto;
import com.pos.system.dto.OrderDetailDto;
import com.pos.system.entity.*;
import com.pos.system.exception.ResourceNotFoundException;
import com.pos.system.repo.*;
import com.pos.system.service.OrderDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepo orderDetailRepo;
    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;
    private final ItemDetailRepo itemDetailRepo;
    private final ProductRepo productRepo;
    @Override
    public void createOrder(OrderDetailDto dto) {
        //Set<ProductDetail> selectedProducts = dto.getProductDetail();
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Customer customer = customerRepo.findById(dto.getCustomer())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        UUID uuid = UUID.randomUUID();
        long orderId = uuid.getMostSignificantBits();

        OrderDetail orderDetail = OrderDetail.builder()
                .orderId(String.valueOf(orderId))
                .totalCost(dto.getTotalCost())
                .discount(dto.getDiscount())
                .operatorEmail(dto.getOperatorEmail())
                .user(user)
                .customer(customer)
                .build();
        orderDetailRepo.save(orderDetail);

        dto.getOrderItems().forEach(itemDto -> {
                    // Find product for each item
                    Product product = productRepo.findByCode(itemDto.getCode()).orElseThrow(() -> new ResourceNotFoundException(
                                    "Product not found: " + itemDto.getCode()));

                    System.out.println(product.getName());
                    // Create ItemDetail
                    ItemDetail item= ItemDetail.builder()
                            .itemDetailId(UUID.randomUUID().toString())
                            .qty(itemDto.getQty())
                            .unitPrice(itemDto.getUnitPrice())
                            .product(product)
                            .orderDetail(orderDetail)
                            .build();
                    itemDetailRepo.save(item);
                });
    }

    @Override
    public void updateOrder(OrderDetailDto dto, String id) {
        Optional<OrderDetail> selectedOrder = orderDetailRepo.findOrderById(String.valueOf(Long.parseLong(id)));
        if (selectedOrder.isEmpty()) throw new RuntimeException();
        selectedOrder.get().setOperatorEmail(dto.getOperatorEmail());
        selectedOrder.get().setTotalCost(dto.getTotalCost());
    }

    @Override
    public void deleteOrder(String id) {
        Optional<OrderDetail> selectedOrder = orderDetailRepo.findOrderById(id);
        if (selectedOrder.isEmpty()) throw new RuntimeException();
        itemDetailRepo.deleteByOrderDetailOrderId(id);
        orderDetailRepo.delete(selectedOrder.get());
    }

    @Override
    public Set<OrderDetailDto> findAllOrders() {
        return orderDetailRepo.findAll().stream()
                .map(this::toResponseOrderDto)
                .collect(Collectors.toSet());
    }

    private OrderDetailDto toResponseOrderDto(OrderDetail orderDetail) {
        List<ItemDetail> itemDetails = itemDetailRepo.findByOrderDetailOrderId(orderDetail.getOrderId());
//        System.out.println(orderDetail.getOrderId());
//        System.out.println(itemDetails);
        return OrderDetailDto.builder()
                .orderId(orderDetail.getOrderId())
                .totalCost(orderDetail.getTotalCost())
                .discount(orderDetail.getDiscount())
                .operatorEmail(orderDetail.getOperatorEmail())
                .userId(orderDetail.getOrderId())
               // .orderItems(itemDetails)
                .build();
    }
}
