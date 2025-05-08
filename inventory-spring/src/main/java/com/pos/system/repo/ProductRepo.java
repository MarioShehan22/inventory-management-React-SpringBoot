package com.pos.system.repo;

import com.pos.system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.Optional;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Product p ORDER BY product_id DESC LIMIT 1")
    Optional<Product> findLastProduct();

    Optional<Product> findByProductId(Long productId);
}
