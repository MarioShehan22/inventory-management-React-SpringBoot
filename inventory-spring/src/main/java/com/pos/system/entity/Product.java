package com.pos.system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-increment primary key
    @Column(name = "product_id")
    private int productId;

    private String name;

    private String description;

    private String brand;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<Batch> batch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> supplier = new ArrayList<>();

//    public void addProduct(Batch b){
//        batch.add(b);
//    }
}
