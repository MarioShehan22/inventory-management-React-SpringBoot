package com.pos.system.service;

import com.pos.system.dto.ProductDto;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void saveProduct(ProductDto dto) throws SQLException, ClassNotFoundException;
    void updateProduct(ProductDto dto, String id);
    void deleteProduct(long id);
//    public ProductDto findProduct(int code);
    List<ProductDto> findAllProducts() throws SQLException, ClassNotFoundException;
//    public int getLastProductId() throws SQLException, ClassNotFoundException;
}
