package com.pos.system.dto;

import com.pos.system.entity.ItemDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailDto {
    private String orderId;
    private double totalCost;
    private double discount;
    private String operatorEmail;

    private List<ItemDetailDto> orderItems;
    private String userId;
    private String customer;
}
