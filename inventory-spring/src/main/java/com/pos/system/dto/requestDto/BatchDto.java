package com.pos.system.dto.requestDto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchDto {
    private int qtyOnHand;
    private int sellingPrice;
    private int showPrice;
    private int buyingPrice;
    private Date expDate;
    private List<ItemDetailDto> itemDetails;
}
