package com.pos.system.service;

import com.pos.system.dto.requestDto.BatchDto;
import com.pos.system.dto.requestDto.BatchRequestDto;
import com.pos.system.entity.Batch;
import com.pos.system.entity.Product;
import com.pos.system.exception.ResourceNotFoundException;
import com.pos.system.repo.BatchRepo;
import com.pos.system.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {
    private final BatchRepo batchRepo;
    private final ProductRepo productRepo;

    @Override
    @Transactional
    public void createBatch(BatchRequestDto dto) {
        try{
            Product product = productRepo.findById(dto.getProductId()).orElseThrow(() -> new ResourceNotFoundException(
                    "Product not found: " + dto.getProductId()));
            Batch batch = Batch.builder()
                    .qtyOnHand(dto.getQtyOnHand())
                    .sellingPrice(dto.getSellingPrice())
                    .showPrice(dto.getShowPrice())
                    .expDate(dto.getExpDate())
                    .buyingPrice(dto.getBuyingPrice())
                    .product(product)
                    .build();
            batchRepo.save(batch);
        } catch (Exception e) {  // "error" changed to "Exception e"
            System.out.println(e);
        }
    }

    @Override
    public void updateBatch(BatchRequestDto dto, int customerId) {

    }

    @Override
    public void deleteBatch(String id) {

    }
}
