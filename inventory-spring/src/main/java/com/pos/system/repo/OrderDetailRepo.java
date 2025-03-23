package com.pos.system.repo;

import com.pos.system.dto.responsedto.OrderDetailInterface;
import com.pos.system.entity.OrderDetail;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM order_detail o WHERE order_id=?")
    Optional<OrderDetail> findOrderById(String id);

    @Query(value = "SELECT c.name as name,c.email as email,o.issued_date as issuedDate,o.total_cost as totalCost FROM order_detail o,customer c where c.id = o.customer_id",nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(PageRequest of);

    @Query(value = "SELECT COUNT(*) FROM order_detail o,customer c where c.id = o.customer_id",nativeQuery = true)
    long countAllOrders();
}
//SELECT COUNT(order_id) FROM order_detail WHERE issued_date LIKE '%2024-12%';
//SELECT SUM(total_cost) FROM order_detail WHERE issued_date LIKE '%2024-12%';

//SELECT customer_id,SUM(total_cost) as total_sales FROM order_detail GROUP BY customer_id;
//SELECT
//        customer_id,
//    COUNT(*) as order_count,
//    SUM(total_cost) as total_spend
//    FROM order_detail
//    WHERE total_cost > 0
//        GROUP BY customer_id;

//SELECT issued_date,COUNT(*) as total_orders FROM order_detail GROUP BY issued_date;
//SELECT o.issued_date,o.customer_id as Customers FROM order_detail o GROUP BY issued_date;
//SELECT c.name,o.order_id,o.total_cost FROM customer c INNER JOIN order_detail o ON c.id= o.customer_id;

//SELECT
//        p.product_name,
//        c.category_name,
//        SUM(od.quantity) as total_sold
//        FROM products p
//        JOIN categories c ON p.category_id = c.category_id
//        JOIN order_details od ON p.product_id = od.product_id
//        GROUP BY p.product_name, c.category_name;

//SELECT COUNT(i.product_id),SUM(i.amount) as total_cost FROM item_detail i GROUP BY i.product_id;
