package com.test.paymenttracking.repository;

import com.test.paymenttracking.entity.Leads;
import com.test.paymenttracking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepo extends JpaRepository<Leads, Integer> {
}
