package com.pos.system.service.impl;

import com.pos.system.dto.requestDto.ProductDto;
import com.pos.system.dto.responsedto.ProductResponseDTO;
import com.pos.system.entity.Category;
import com.pos.system.entity.Product;
import com.pos.system.exception.ResourceNotFoundException;
import com.pos.system.repo.CategoryRepo;
import com.pos.system.repo.ProductRepo;
import com.pos.system.service.ProductService;
import com.pos.system.util.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
   private final ProductRepo productRepo;

    private final ProductMapper productMapper;
    private final CategoryRepo categoryRepo;
    @Override
    @Transactional
    public void saveProduct(ProductDto dto) {
        Category category = categoryRepo.findById(dto.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .brand(dto.getBrand())
                .category(category)
                .build();
        productRepo.save(product);
    }

    @Override
    public void updateProduct(ProductDto dto, int id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        Category category = categoryRepo.findById(dto.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(dto.getBrand());
        product.setCategory(category);
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepo.deleteById(id);
    }

    @Override
    public ProductDto findBatchByProduct(String code) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> findAllProducts(){
        List<Product> dtos = productRepo.findAll();
        return productMapper.toResponseProductDto(dtos);
    }
}
