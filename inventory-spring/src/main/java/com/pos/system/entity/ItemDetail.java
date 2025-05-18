package com.pos.system.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String itemDetailId;

    private int qty;

    private double discount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "batch_id", nullable = false)
    @Valid
    private Batch batch;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @Valid
    private OrderDetail orderDetail;

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
