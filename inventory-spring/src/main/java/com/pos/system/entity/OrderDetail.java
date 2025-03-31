package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetail{
    @Id
    private String orderId;
    private double totalCost;
    private double discount;
    private String operatorEmail;

    @OneToMany(mappedBy = "orderDetail",  cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ItemDetail> itemDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(updatable = false)
    private LocalDateTime issuedDate;

    public void addItemDetails(ItemDetail itemDetail) {
        itemDetails.add(itemDetail);
        itemDetail.setOrderDetail(this);
    }

    @PrePersist
    protected void onCreate() {
        issuedDate = LocalDateTime.now();
    }
}
