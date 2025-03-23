package com.pos.system.service;

import com.pos.system.dto.requestDto.ItemDetailDto;
import com.pos.system.dto.responsedto.ProductQuantityDTO;
import com.pos.system.dto.responsedto.TotalAmountPerProduct;

import java.sql.SQLException;
import java.util.List;

public interface ItemDetailService {
    void createItemDetail(ItemDetailDto dto) throws SQLException, ClassNotFoundException;
    void updateItemDetail(ItemDetailDto dto, String customerId) throws SQLException, ClassNotFoundException;
    void deleteItemDetail(long id) throws SQLException, ClassNotFoundException;
    //List<OrderDto> findCustomer(String email) throws SQLException, ClassNotFoundException;
    List<ItemDetailDto> findAllOrders() throws SQLException, ClassNotFoundException;
    List<TotalAmountPerProduct> findAllTotalAmountPerProducts() throws SQLException,ClassNotFoundException;
    List<ProductQuantityDTO> findAllTotalQTYPerProducts() throws SQLException,ClassNotFoundException;
}
