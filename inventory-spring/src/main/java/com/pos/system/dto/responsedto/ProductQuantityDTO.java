package com.pos.system.dto.responsedto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductQuantityDTO {
    private String productName;
    private Long totalQuantity;
}
