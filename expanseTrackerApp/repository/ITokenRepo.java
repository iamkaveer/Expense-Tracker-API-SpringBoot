package com.expense.expanseTrackerApp.repository;

import com.expense.expanseTrackerApp.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByToken(String token);

    @Query(value = "SELECT fk_user_id FROM authentication_token WHERE token = :token", nativeQuery = true)
    Integer findUserIdByToken(String token);
}
