package com.test.paymenttracking.repository;

import com.test.paymenttracking.entity.Payment;
import com.test.paymenttracking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
