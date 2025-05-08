package com.pos.system.enums;

public enum PaymentType {
    CASH("cash"),CREDIT_CARD("credit_card"),DEBIT_CARD("debit_card");
    private String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
