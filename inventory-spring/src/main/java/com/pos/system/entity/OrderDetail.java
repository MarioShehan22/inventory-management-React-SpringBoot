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
    @Column(name = "order_id")
    private String orderId;

    private double totalCost;

    private double discount;

    @OneToMany(mappedBy = "orderDetail",fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ItemDetail> itemDetails;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "orderDetail",fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Payment payment;

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
