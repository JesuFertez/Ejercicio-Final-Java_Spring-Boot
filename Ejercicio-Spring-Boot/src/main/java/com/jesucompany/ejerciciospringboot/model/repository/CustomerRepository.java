package com.jesucompany.ejerciciospringboot.model.repository;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
