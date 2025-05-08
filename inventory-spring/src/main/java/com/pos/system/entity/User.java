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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
