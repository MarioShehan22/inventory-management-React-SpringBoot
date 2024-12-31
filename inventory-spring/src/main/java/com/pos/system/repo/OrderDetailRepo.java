package com.pos.system.repo;

import com.pos.system.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM order_detail o WHERE order_id=?")
    Optional<OrderDetail> findOrderById(String id);
}
