package com.pos.system.util.mapper;

import com.pos.system.dto.requestDto.ProductDto;
import com.pos.system.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDto> toResponseProductDto(List<Product> list);
}
