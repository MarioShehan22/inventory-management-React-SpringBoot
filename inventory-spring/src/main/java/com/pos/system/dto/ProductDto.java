package com.pos.system.dto;

import com.pos.system.entity.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String code;
    private String name;
    private String description;
    private int qtyOnHand  = 0;
    private int sellingPrice;
    private int showPrice;
    private int buyingPrice;
    private boolean discountAvailability;
}
