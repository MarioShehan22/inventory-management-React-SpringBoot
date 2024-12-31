package com.pos.system.service;

import com.pos.system.dto.CustomerDto;
import com.pos.system.dto.OrderDetailDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface OrderDetailService {
    void createOrder(OrderDetailDto dto) throws SQLException, ClassNotFoundException;
    void updateOrder(OrderDetailDto dto, String customerId) throws SQLException, ClassNotFoundException;
    void deleteOrder(String id) throws SQLException, ClassNotFoundException;
    //List<OrderDto> findCustomer(String email) throws SQLException, ClassNotFoundException;
    Set<OrderDetailDto> findAllOrders() throws SQLException, ClassNotFoundException;
    //public List<CustomerDto> searchCustomers(String searchText) throws SQLException, ClassNotFoundException;
}
