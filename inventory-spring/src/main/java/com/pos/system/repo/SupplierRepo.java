package com.pos.system.repo;

import com.pos.system.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,String> {
}
