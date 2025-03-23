package com.pos.system.repo;

import com.pos.system.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %?1%")
            List<Customer> findByNameContaining(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM Customer c WHERE id=?")
    public Optional<Customer> findUserByCustomerId(String id);

    public List<Customer> findAllByName(String name);

    @Query(value = "SELECT * FROM customer WHERE name LIKE ?1 OR email LIKE ?1", nativeQuery = true)
    public List<Customer> searchCustomers(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM customer WHERE name LIKE ?1 OR email LIKE ?1", nativeQuery = true)
    public Long countCustomers(String searchText);
}
