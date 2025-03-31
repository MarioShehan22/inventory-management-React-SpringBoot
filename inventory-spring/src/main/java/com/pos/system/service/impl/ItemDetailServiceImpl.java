package com.pos.system.service.impl;

import com.pos.system.dto.requestDto.ItemDetailDto;
import com.pos.system.dto.responsedto.ProductQuantityDTO;
import com.pos.system.dto.responsedto.TotalAmountPerProduct;
import com.pos.system.entity.ItemDetail;
import com.pos.system.entity.Product;
import com.pos.system.exception.ResourceNotFoundException;
import com.pos.system.repo.ItemDetailRepo;
import com.pos.system.repo.ProductRepo;
import com.pos.system.service.ItemDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemDetailServiceImpl implements ItemDetailService {
    private final ItemDetailRepo itemDetailRepo;
    private final ProductRepo productRepo;

    @Override
    public void createItemDetail(ItemDetailDto dto) {
        UUID uuid = UUID.randomUUID();
        long itemId = uuid.getMostSignificantBits();

        Product product = productRepo.findByCode(dto.getCode())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product not found: " + dto.getCode()));

        ItemDetail itemDetail = new ItemDetail();
        itemDetail.setItemDetailId(String.valueOf((int) itemId));
        itemDetail.setOrderDetail(dto.getOrderDetail());
        itemDetail.setProduct(product);
        itemDetail.setQty(dto.getQty());
        itemDetail.setUnitPrice(dto.getUnitPrice());
        itemDetailRepo.save(itemDetail);
    }

    @Override
    public void updateItemDetail(ItemDetailDto dto, String customerId) {

    }

    @Override
    public void deleteItemDetail(long id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<ItemDetailDto> findAllOrders() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<TotalAmountPerProduct> findAllTotalAmountPerProducts() throws SQLException, ClassNotFoundException {
        List<TotalAmountPerProduct> dtos=  new ArrayList<>();
        itemDetailRepo.findTotalAmountPerProduct().forEach(e->{
            dtos.add(
                    new TotalAmountPerProduct(
                            (String) e[0],
                            (BigDecimal) e[1]
                    )
            );
        });
        return dtos;
    }

    @Override
    public List<ProductQuantityDTO> findAllTotalQTYPerProducts() throws SQLException, ClassNotFoundException {
        List<ProductQuantityDTO> dtos=  new ArrayList<>();
        itemDetailRepo.findTotalQtyPerProduct().forEach(e->{
            dtos.add(
                    new ProductQuantityDTO(
                            (String) e[0],
                            (Long) e[1]
                    )
            );
        });
        return dtos;
    }
}
