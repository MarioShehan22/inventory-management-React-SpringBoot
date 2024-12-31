package com.pos.system.repo;

import com.pos.system.dto.ItemDetailDto;
import com.pos.system.entity.ItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableJpaRepositories
public interface ItemDetailRepo extends JpaRepository<ItemDetail, Long> {
    // Correct way to find by OrderDetail
    @Query("SELECT i FROM ItemDetail i WHERE i.orderDetail.orderId = :orderId")
    List<ItemDetail> findByOrderDetailOrderId(String orderId);

    // More efficient delete using a query
    @Transactional
    @Modifying
    @Query("DELETE FROM ItemDetail i WHERE i.orderDetail.orderId = :orderId")
    void deleteByOrderDetailOrderId(String orderId);
}
