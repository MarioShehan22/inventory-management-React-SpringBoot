package com.pos.system.dto.requestDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DiscountDto {
    private String discountId;
    private int discount;
    private BatchDto batch;
}
