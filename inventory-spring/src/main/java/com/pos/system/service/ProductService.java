package com.pos.system.service;

import com.pos.system.dto.requestDto.ProductDto;
import com.pos.system.dto.responsedto.ProductResponseDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void saveProduct(ProductDto dto) throws SQLException, ClassNotFoundException;
    void updateProduct(ProductDto dto, int id);
    void deleteProduct(int id);
    public ProductDto findBatchByProduct(String code);
    List<ProductResponseDTO> findAllProducts() throws SQLException, ClassNotFoundException;
    //int getLastProductId() throws SQLException, ClassNotFoundException;
}
