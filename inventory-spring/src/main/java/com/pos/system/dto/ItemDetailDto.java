package com.pos.system.dto;

import com.pos.system.entity.OrderDetail;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDetailDto {
    private String itemDetailId;

    private int order;

    private int qty;

    private double discount;

    private BigDecimal unitPrice;

    private BigDecimal amount;

    private OrderDetail orderDetail;

    private String code;
}
