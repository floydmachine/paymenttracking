package com.test.paymenttracking.repository;

import com.test.paymenttracking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
    List<Users> findByRole(String role);

    Optional<Users> findByUsername(String username);
}
