package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetail {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    private double totalCost;

    private double discount; // Order-level discount (percentage)

    @OneToMany(mappedBy = "orderDetail", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ItemDetail> itemDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "orderDetail", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Payment payment;

    @Column(updatable = false)
    private LocalDateTime issuedDate;

    public void addItemDetails(ItemDetail itemDetail) {
        itemDetails.add(itemDetail);
        itemDetail.setOrderDetail(this);

        // Recalculate total cost whenever an item is added
        calculateTotalCost();
    }

    public void removeItemDetail(ItemDetail itemDetail) {
        itemDetails.remove(itemDetail);
        itemDetail.setOrderDetail(null);

        // Recalculate total cost whenever an item is removed
        calculateTotalCost();
    }

    @PrePersist
    protected void onCreate() {
        issuedDate = LocalDateTime.now();
        calculateTotalCost();
    }

    @PreUpdate
    protected void onUpdate() {
        calculateTotalCost();
    }

    /**
     * Calculates the total cost of the order by summing all item costs and applying the order discount
     */
    public void calculateTotalCost() {
        // Sum up the amount from all items after applying their individual discounts
        double subtotal = itemDetails.stream()
                .mapToDouble(item -> {
                    // Calculate item total after its own discount
                    BigDecimal itemAmount = item.getAmount();
                    if (itemAmount == null) {
                        // If amount hasn't been calculated yet (happens during initial persistence)
                        itemAmount = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQty()));
                    }

                    // Apply the item-level discount
                    double itemDiscount = item.getDiscount();
                    double discountMultiplier = 1 - (itemDiscount / 100.0);
                    return itemAmount.doubleValue() * discountMultiplier;
                })
                .sum();

        // Apply the order-level discount
        double orderDiscountMultiplier = 1 - (this.discount / 100.0);
        this.totalCost = subtotal * orderDiscountMultiplier;
    }
}
