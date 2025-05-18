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
    private double discount;
    private String operatorEmail;
    private List<ItemDetailDto> orderItems;
    private int customer;
}
