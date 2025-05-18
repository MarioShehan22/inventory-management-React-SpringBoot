package com.pos.system.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchRequestDto {
    private int qtyOnHand;
    private int sellingPrice;
    private int showPrice;
    private int buyingPrice;
    private Date expDate;
    private int productId;
}
