package com.jesucompany.ejerciciospringboot.view.controllers;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1= customerService.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO1;
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
     CustomerDTO customerDTO = customerService.findById(id);
     customerDTO = customerService.update(customer);
        return customerDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }
}
