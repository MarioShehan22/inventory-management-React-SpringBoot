package com.pos.system.dto.requestDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
