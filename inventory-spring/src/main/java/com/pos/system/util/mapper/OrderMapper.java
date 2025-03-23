package com.pos.system.util.mapper;

import com.pos.system.dto.responsedto.OrderDetailInterface;
import com.pos.system.dto.responsedto.ResponseOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mappings({
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "issuedDate", source = "issuedDate"),
            @Mapping(target = "totalCost", source = "totalCost")
    })
    ResponseOrderDto map(OrderDetailInterface orderDetailInterface);

    List<ResponseOrderDto> toResponseOrderDto(List<OrderDetailInterface> list);
}
