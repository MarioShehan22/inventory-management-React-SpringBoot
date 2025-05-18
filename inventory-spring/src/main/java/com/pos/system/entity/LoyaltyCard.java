package com.pos.system.entity;

import com.pos.system.enums.CardType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoyaltyCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private CardType cardType;
    private String barcode;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", unique = true, nullable = false)
    private Customer customer;
}
