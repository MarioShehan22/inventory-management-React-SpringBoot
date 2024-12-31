package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDetail {
    @Id
    private String itemDetailId;

    private int qty;

    private double discount;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @PrePersist
    @PreUpdate
    protected void calculateSubtotal() {
        this.amount = this.unitPrice.multiply(BigDecimal.valueOf(this.qty));
    }
}
