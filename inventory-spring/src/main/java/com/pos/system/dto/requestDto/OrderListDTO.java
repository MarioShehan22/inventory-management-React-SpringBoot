package com.pos.system.dto.requestDto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderListDTO {
    private String customerName;
    private String customerEmail;

}
