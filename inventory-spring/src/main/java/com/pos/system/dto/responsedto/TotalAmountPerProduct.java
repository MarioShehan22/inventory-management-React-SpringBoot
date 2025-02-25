package com.pos.system.dto.responsedto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TotalAmountPerProduct {
    String name;
    BigDecimal sum;
}
