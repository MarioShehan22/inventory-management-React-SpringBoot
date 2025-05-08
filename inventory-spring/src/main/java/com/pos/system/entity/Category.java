package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @Column(name = "category_id")
    private String propertyId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public Category(String id) {
        this.propertyId = id;
    }
}
