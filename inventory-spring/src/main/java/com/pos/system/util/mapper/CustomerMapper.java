package com.pos.system.util.mapper;

import com.pos.system.dto.requestDto.CustomerDto;
import com.pos.system.dto.responsedto.ResponseCustomerDto;
import com.pos.system.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<ResponseCustomerDto> toResponseCustomerDtoList(List<Customer> list);
}
