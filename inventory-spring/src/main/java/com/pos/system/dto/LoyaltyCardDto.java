package com.pos.system.dto;

import com.pos.system.enums.CardType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoyaltyCardDto {
    private int code;
    private CardType cardType;
    private String barcode;
    private String email;
}
