package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.presenter.CustomerPresenter;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerPresenter customerPresenter;
    private final ModelMapper modelMapper;

    public CustomerRestController(CustomerPresenter customerPresenter, ModelMapper modelMapper) {
        this.customerPresenter = customerPresenter;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerPresenter.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerPresenter.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1= customerPresenter.createCustomer(customerDTO.getName(),customerDTO.getLastName(),customerDTO.getRun(),
                customerDTO.getCity(), customerDTO.getCommune(), customerDTO.getStreet(), customerDTO.getNumber(),
                customerDTO.getDateOfBirth(), customerDTO.getPhone(), customerDTO.getIsActive());
        return customerDTO1;
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
     CustomerDTO customerDTO = customerPresenter.updateCustomer(id, customer);
        return customerDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerPresenter.deleteCustomer(id);
    }
}
