package com.pos.system.entity;

import com.pos.system.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String paymentId;

    private int amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderDetail orderDetail;

    private PaymentType paymentType;

    @Column(updatable = false)
    private LocalDateTime paymentAt;

    @PrePersist
    protected void onCreate() {
        paymentAt = LocalDateTime.now();
    }
}
