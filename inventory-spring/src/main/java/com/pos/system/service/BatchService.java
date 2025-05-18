package com.pos.system.service;

import com.pos.system.dto.requestDto.BatchDto;
import com.pos.system.dto.requestDto.BatchRequestDto;
import com.pos.system.dto.requestDto.CustomerDto;

import java.sql.SQLException;

public interface BatchService {
    void createBatch(BatchRequestDto dto) throws SQLException, ClassNotFoundException;
    void updateBatch(BatchRequestDto dto, int customerId) throws SQLException, ClassNotFoundException;
    void deleteBatch(String id) throws SQLException, ClassNotFoundException;
    //List<ResponseCustomerDto> findBatch() throws SQLException, ClassNotFoundException;
    //PaginatedCustomerDto findAllBatch(String searchText, int page, int size) throws SQLException, ClassNotFoundException;
}
