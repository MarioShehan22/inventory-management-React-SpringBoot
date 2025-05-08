package com.pos.system.dto.responsedto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
    private String productId;
    private String name;
    private String description;
    private String brand;
    private CategoryResponseDTO category;
}
