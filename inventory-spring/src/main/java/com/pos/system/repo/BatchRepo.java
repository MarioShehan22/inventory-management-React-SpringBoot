package com.pos.system.repo;

import com.pos.system.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,String> {
}
