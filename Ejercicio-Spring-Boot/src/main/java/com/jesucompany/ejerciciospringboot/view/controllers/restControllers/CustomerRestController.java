package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.presenter.CustomerPresenter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        List<CustomerDTO> customers = customerPresenter.findAll();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(customers); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        try {
            CustomerDTO customer = customerPresenter.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //404
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO customerDTO1 = customerPresenter.createCustomer(customerDTO.getName(), customerDTO.getLastName(), customerDTO.getRun(),
                    customerDTO.getCity(), customerDTO.getCommune(), customerDTO.getStreet(), customerDTO.getNumber(),
                    customerDTO.getDateOfBirth(), customerDTO.getPhone(), customerDTO.getIsActive());
            return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO1);  //201
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        try {
            CustomerDTO customerDTO = customerPresenter.updateCustomer(id, customer);
            return ResponseEntity.ok(customerDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerPresenter.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
