package com.pos.system.repo;

import com.pos.system.entity.ItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ItemDetailRepo extends JpaRepository<ItemDetail, Long> {
    // Correct way to find by OrderDetail
    //@Query("SELECT i FROM ItemDetail i WHERE i.orderDetail.orderId = :orderId")
    List<ItemDetail> findByOrderDetailOrderId(String orderId);

    // More efficient delete using a query
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM ItemDetail i WHERE i.orderDetail.orderId = :orderId")
    void deleteByOrderDetailOrderId(String orderId);
    //void deleteByOrderDetailOrderId(String orderId);

//    @Query("SELECT p.name, SUM(id.amount) FROM ItemDetail id INNER JOIN Product p ON id.product = p GROUP BY p.name")
//    List<Object[]> findTotalAmountPerProduct();

//    @Query(value = "SELECT p.name, SUM(id.qty) FROM ItemDetail id INNER JOIN id.product p GROUP BY p.name")
//    List<Object[]> findTotalQtyPerProduct();
}
//SELECT product_id, COUNT(qty) FROM item_detail GROUP BY product_id;
//SELECT product_id, SUM(qty) FROM item_detail GROUP BY product_id;
//SELECT product.name, SUM(item_detail.amount) FROM item_detail INNER JOIN product ON item_detail.product_id =product.product_code GROUP BY product.name;

//find single product income
//SELECT order_id, SUM(amount), FROM item_detail GROUP BY order_id;
//        SELECT product_id,SUM(amount) FROM item_detail GROUP BY product_id;
//        SELECT product_id,SUM(amount) FROM item_detail GROUP BY product_id IN (SELECT name FROM product);
//        product_code

//GROUP and return product name and Ordered Product qty in item_detail table
// SELECT p.name, SUM(id.qty) FROM item_detail id INNER JOIN product p ON id.product_id =p.product_code GROUP BY p.name;
