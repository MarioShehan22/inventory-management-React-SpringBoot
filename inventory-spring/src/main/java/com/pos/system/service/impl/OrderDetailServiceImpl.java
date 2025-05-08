package com.pos.system.service.impl;

import com.pos.system.dto.requestDto.OrderDetailDto;
import com.pos.system.dto.responsedto.OrderDetailInterface;
import com.pos.system.dto.responsedto.ResponseOrderDto;
import com.pos.system.dto.responsedto.paginated.PaginatedOrderDTO;
import com.pos.system.entity.*;
import com.pos.system.exception.ResourceNotFoundException;
import com.pos.system.repo.*;
import com.pos.system.service.OrderDetailService;
import com.pos.system.util.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepo orderDetailRepo;
    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;
    private final ItemDetailRepo itemDetailRepo;
    private final ProductRepo productRepo;
    private final JavaMailSender mailSender;
    private final OrderMapper orderMapper;
    private final BatchRepo batchRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Override
    public void createOrder(OrderDetailDto dto) {
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
                .user(user)
                .customer(customer)
                .build();

        if(orderDetailRepo.existsById(String.valueOf(orderId))){
            dto.getOrderItems().forEach(itemDto -> {
                // Find product for each item
//                Batch batch = batchRepo.findById(Long.valueOf(itemDto.getCode())).orElseThrow(() -> new ResourceNotFoundException(
//                        "Product not found: " + itemDto.getCode()));

                // Create ItemDetail
                ItemDetail item= ItemDetail.builder()
                        .itemDetailId(UUID.randomUUID().toString())
                        .qty(itemDto.getQty())
                        .unitPrice(itemDto.getUnitPrice())
//                        .product(product)
                        .orderDetail(orderDetail)
                        .build();

                orderDetail.addItemDetails(item);
                //itemDetailRepo.save(item);
            });
        }
        orderDetailRepo.save(orderDetail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nilankashehan679@gmail.com"); // Replace with your email
        message.setTo(customer.getEmail());
        message.setSubject("Order ID :"+orderId);
        message.setText(String.valueOf(dto));

        mailSender.send(message);
        System.out.println("Email sent successfully!");
    }

    @Override
    public void updateOrder(OrderDetailDto dto, String id) {
        Optional<OrderDetail> selectedOrder = orderDetailRepo.findOrderById(String.valueOf(Long.parseLong(id)));
        if (selectedOrder.isEmpty()) throw new RuntimeException();
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
    public PaginatedOrderDTO findAllOrders(int page, int size) {
        List<OrderDetailInterface> orderDetailInterfaces = orderDetailRepo.getAllOrderDetails(PageRequest.of(page, size));
        List<ResponseOrderDto> dtos = orderMapper.toResponseOrderDto(orderDetailInterfaces);

        return new PaginatedOrderDTO(
                orderDetailRepo.countAllOrders(),
                dtos
        );
    }
}
