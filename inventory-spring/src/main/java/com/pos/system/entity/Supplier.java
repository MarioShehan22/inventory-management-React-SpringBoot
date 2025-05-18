package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String supplierId;

    private String name;

    private String contact;

    @ManyToMany (mappedBy = "supplier")
    private List<Product> productList = new ArrayList<>();
}
