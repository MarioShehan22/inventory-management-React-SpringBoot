package com.pos.system.dto.responsedto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDTO {
    private String propertyId;
    private String categoryName;
}
