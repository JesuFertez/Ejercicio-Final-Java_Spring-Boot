package com.jesucompany.ejerciciospringboot.repository;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractsRepository extends JpaRepository<Contract, Long> {
    List<Contract>findCustomerById(Long customerId);
    List<Contract>findByPlanId(Long planId);
}
