package com.pos.system.dto.requestDto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String productId;
    private String name;
    private String description;
    private String brand;
    private String category;
//    private int qtyOnHand  = 0;
//    private int sellingPrice;
//    private int showPrice;
//    private int buyingPrice;
//    private boolean discountAvailability;
}
