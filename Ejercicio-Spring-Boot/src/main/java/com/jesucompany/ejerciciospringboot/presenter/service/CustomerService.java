package com.jesucompany.ejerciciospringboot.presenter.service;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.model.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(modelMapper.map(customer, CustomerDTO.class));
        }
        return customerDTOS;
    }

    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Customer not found"));

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerDTO save(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO customerDTO = modelMapper.map(savedCustomer, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerDTO update(Customer customer) {
        Customer customerToUpdate = customerRepository.findById(customer.getId()).orElse(null);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setRun(customer.getRun());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setCommune(customer.getCommune());
        customerToUpdate.setStreet(customer.getStreet());
        customerToUpdate.setNumber(customer.getNumber());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setDateOfBirth(customer.getDateOfBirth());
        customerToUpdate.setIsActive(customer.getIsActive());
        customerRepository.save(customerToUpdate);

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
