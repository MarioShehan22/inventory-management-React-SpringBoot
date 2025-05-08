package com.pos.system.repo;

import com.pos.system.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository<Discount,String> {
}
