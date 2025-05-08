package com.pos.system.dto.requestDto;

import com.pos.system.entity.Discount;
import com.pos.system.entity.ItemDetail;
import com.pos.system.entity.Product;

import java.util.Date;
import java.util.List;

public class BatchRequestDto {
    private int qtyOnHand;
    private int sellingPrice;
    private int showPrice;
    private int buyingPrice;
    private Date expDate;
    private List<ItemDetailDto> itemDetails;
    private int productId;
    private List<Discount> discounts;
}
