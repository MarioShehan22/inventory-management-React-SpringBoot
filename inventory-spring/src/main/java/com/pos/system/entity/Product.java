package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product{
    @Id
    @Column(name = "product_code")
    private String code;

    private String name;

    private String description;

    private int qtyOnHand  = 0;

    private int sellingPrice;

    private int showPrice;

    private int buyingPrice;

    private boolean discountAvailability;

    @OneToMany(mappedBy = "product")
    private List<ItemDetail> itemDetails;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
