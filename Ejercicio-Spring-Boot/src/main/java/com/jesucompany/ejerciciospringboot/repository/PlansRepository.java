package com.jesucompany.ejerciciospringboot.repository;

import com.jesucompany.ejerciciospringboot.model.database.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<Plan, Long> {
}
