package com.pos.system.dto.requestDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private String propertyId;
    private String categoryName;
    private List<ProductDto> products;
}
