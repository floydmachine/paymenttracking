package com.test.paymenttracking.repository;

import com.test.paymenttracking.entity.Team;
import com.test.paymenttracking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> {
}
