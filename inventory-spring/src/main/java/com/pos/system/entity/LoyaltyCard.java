package com.pos.system.entity;

import com.pos.system.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoyaltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private CardType cardType;
    private String barcode;
    private String email;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;
}
