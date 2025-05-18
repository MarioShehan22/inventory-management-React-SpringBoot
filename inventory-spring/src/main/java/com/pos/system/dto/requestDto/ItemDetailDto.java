package com.pos.system.dto.requestDto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDetailDto {
    private int qty;
    private double discount;
    private BigDecimal unitPrice;
    private String code;
}
