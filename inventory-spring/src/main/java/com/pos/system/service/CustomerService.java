package com.pos.system.service;

import com.pos.system.dto.requestDto.CustomerDto;
import com.pos.system.dto.responsedto.ResponseCustomerDto;
import com.pos.system.dto.responsedto.paginated.PaginatedCustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    void updateCustomer(CustomerDto dto, int customerId) throws SQLException, ClassNotFoundException;
    void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<ResponseCustomerDto> findCustomer() throws SQLException, ClassNotFoundException;
    PaginatedCustomerDto findAllCustomers(String searchText, int page, int size) throws SQLException, ClassNotFoundException;
    //public List<CustomerDto> searchCustomers(String searchText) throws SQLException, ClassNotFoundException;
}
