package com.pos.system.enums;

public enum CardType {
    GOLD("gold"),PLATINUM("platinum"),SILVER("silver");
    private String cardType;

    CardType(String cardType) {
        this.cardType = cardType;
    }
}
