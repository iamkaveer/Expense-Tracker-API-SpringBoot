package com.expense.expanseTrackerApp.repository;

import com.expense.expanseTrackerApp.model.Product;
import com.expense.expanseTrackerApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByUser(User user);

    @Query(value = "SELECT fk_user_id FROM tbl_product WHERE product_id = :productId", nativeQuery = true)
    Integer findUserIdByProductId(Integer productId);

    @Query(value = "SELECT SUM(price) FROM tbl_product WHERE MONTH(date) = :month AND YEAR(date) = :year AND fk_user_id = :userId", nativeQuery = true)
    Double findExpense(Integer month, Integer year, Integer userId);
}
