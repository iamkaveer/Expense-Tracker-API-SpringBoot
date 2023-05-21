package com.expense.expanseTrackerApp.repository;

import com.expense.expanseTrackerApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM tbl_user WHERE email = :email", nativeQuery = true)
    User findUserByEmail(String email);
}
