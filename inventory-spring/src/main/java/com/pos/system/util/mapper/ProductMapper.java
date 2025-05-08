package com.pos.system.util.mapper;

import com.pos.system.dto.responsedto.CategoryResponseDTO;
import com.pos.system.dto.responsedto.ProductResponseDTO;
import com.pos.system.entity.Category;
import com.pos.system.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductResponseDTO> toResponseProductDto(List<Product> list);

    CategoryResponseDTO map(Category category);
}
