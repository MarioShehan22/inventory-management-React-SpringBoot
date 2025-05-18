package com.pos.system.dto.responsedto;

import com.pos.system.dto.requestDto.BatchRequestDto;
import lombok.*;

import java.util.List;

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
    private List<BatchRequestDto> batch;
}
