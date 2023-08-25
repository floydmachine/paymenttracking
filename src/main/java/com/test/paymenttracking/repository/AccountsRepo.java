package com.test.paymenttracking.repository;

import com.test.paymenttracking.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Integer> {
}
