package com.pos.system.service;

import com.pos.system.dto.ItemDetailDto;
import com.pos.system.dto.OrderDetailDto;
import com.pos.system.entity.ItemDetail;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ItemDetailService {
    void createItemDetail(ItemDetailDto dto) throws SQLException, ClassNotFoundException;
    void updateItemDetail(ItemDetailDto dto, String customerId) throws SQLException, ClassNotFoundException;
    void deleteItemDetail(long id) throws SQLException, ClassNotFoundException;
    //List<OrderDto> findCustomer(String email) throws SQLException, ClassNotFoundException;
    List<ItemDetailDto> findAllOrders() throws SQLException, ClassNotFoundException;
}
