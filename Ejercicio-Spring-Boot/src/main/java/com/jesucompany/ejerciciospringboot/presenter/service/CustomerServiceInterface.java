package com.jesucompany.ejerciciospringboot.presenter.service;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerServiceInterface {
    public List<CustomerDTO> findAll();
    CustomerDTO findById(Long id);
    CustomerDTO save(Customer customer);
    CustomerDTO update(Customer customer);
    void delete(Long id);
}
