package com.pos.system.entity;

import com.pos.system.enums.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    private int code;
    private CardType cardType;
    private String barcode;
    private String email;

    @OneToOne
    @JoinColumn(name = "customer", unique = true)
    private Customer customer;
}
