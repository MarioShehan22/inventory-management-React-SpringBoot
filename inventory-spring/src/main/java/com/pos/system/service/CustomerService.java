package com.pos.system.service;

import com.pos.system.dto.CustomerDto;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    void updateCustomer(CustomerDto dto, String customerId) throws SQLException, ClassNotFoundException;
    void deleteCustomer(long id) throws SQLException, ClassNotFoundException;
    //List<CustomerDto> findCustomer(String email) throws SQLException, ClassNotFoundException;
    List<CustomerDto> findAllCustomers() throws SQLException, ClassNotFoundException;
    //public List<CustomerDto> searchCustomers(String searchText) throws SQLException, ClassNotFoundException;
}
