package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Discount {
    @Id
    @Column(name = "discount_id")
    private String discountId;

    private int discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "batch")
    private Batch batch;
}
