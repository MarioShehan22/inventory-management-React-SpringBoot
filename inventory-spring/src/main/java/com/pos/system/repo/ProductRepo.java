package com.pos.system.repo;

import com.pos.system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM Product p WHERE code=?")
    Optional<Product> getLastProductId(String code);

    Optional<Product> findByCode(String productCode);
    // or if you're using product name
    Optional<Product> findByName(String name);
//    @Query("SELECT p FROM Product p WHERE p.description LIKE %?1%")
//    List<Product> findByNameContaining(String description);
}
