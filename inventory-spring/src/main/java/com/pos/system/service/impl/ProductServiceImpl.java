package com.pos.system.service.impl;

import com.pos.system.dto.requestDto.ProductDto;
import com.pos.system.entity.Product;
import com.pos.system.repo.ProductRepo;
import com.pos.system.service.ProductService;
import com.pos.system.util.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
   private final ProductRepo productRepo;

   private final ProductMapper productMapper;
    @Override
    public void saveProduct(ProductDto dto){
        Product product = new Product();
        UUID uuid = UUID.randomUUID();
        long id = uuid.getMostSignificantBits();

        product.setCode(String.valueOf(id));
        product.setName(dto.getName());
        product.setBuyingPrice(dto.getBuyingPrice());
        product.setSellingPrice(dto.getSellingPrice());
        product.setShowPrice(dto.getShowPrice());
        product.setQtyOnHand(dto.getQtyOnHand());
        product.setDiscountAvailability(dto.isDiscountAvailability());
        product.setDescription(dto.getDescription());
        productRepo.save(product);
    }

    @Override
    public void updateProduct(ProductDto dto, String id) {
        Optional<Product> selectedProduct = productRepo.getLastProductId(String.valueOf(Long.parseLong(id)));
        if (selectedProduct.isEmpty()) throw new RuntimeException();
        selectedProduct.get().setCode(String.valueOf(Integer.parseInt(id)));
        selectedProduct.get().setName(dto.getName());
        selectedProduct.get().setDescription(dto.getDescription());
        selectedProduct.get().setDiscountAvailability(dto.isDiscountAvailability());
        selectedProduct.get().setQtyOnHand(dto.getQtyOnHand());
        selectedProduct.get().setSellingPrice(dto.getSellingPrice());
        selectedProduct.get().setShowPrice(dto.getShowPrice());
        selectedProduct.get().setBuyingPrice(dto.getBuyingPrice());
        productRepo.save(selectedProduct.get());
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> selectedProduct = productRepo.getLastProductId(String.valueOf(id));
        if (selectedProduct.isEmpty()) throw new RuntimeException();
        productRepo.delete(selectedProduct.get());
    }

    @Override
    public List<ProductDto> findAllProducts(){
        List<Product> dtos = productRepo.findAll();
        return productMapper.toResponseProductDto(dtos);
    }
}
