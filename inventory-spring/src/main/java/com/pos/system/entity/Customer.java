package com.pos.system.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer{
    @Id
    private long id;
    private String email;
    private String name;
    private String contact;
    private double salary;

    @OneToOne(mappedBy = "customer")
    @Nullable
    private LoyaltyCard loyaltyCard;

    @OneToMany(mappedBy = "customer")
    private List<OrderDetail> orderDetail = new ArrayList<>();

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
