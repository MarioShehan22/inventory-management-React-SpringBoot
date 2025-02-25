package com.pos.system.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "time-based")
    @GenericGenerator(name = "time-based", strategy = "com.pos.system.util.TimeBasedIdGenerator")
    private String id;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
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
