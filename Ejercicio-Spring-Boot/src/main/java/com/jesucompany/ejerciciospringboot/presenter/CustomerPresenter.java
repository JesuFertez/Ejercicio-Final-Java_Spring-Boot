package com.jesucompany.ejerciciospringboot.presenter;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.model.dto.PlanDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.CustomerService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CustomerPresenter {

    public CustomerService customerService;

    CustomerPresenter(CustomerService customerService){
        this.customerService = customerService;
    }

    public List<CustomerDTO>findAll(){
        try{
            return customerService.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los clientes", e);
        }
    }

    public CustomerDTO createCustomer(String name, String lastName, String run, String city,
                                      String commune, String street, int number, LocalDate dateOfBirth,
                                      String phone, boolean isActive) {
        Customer customer = new Customer(name, lastName, run, city,commune,street,number,dateOfBirth,phone,isActive);
        return customerService.save(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerService.findById(id);
    }

    public void deleteCustomer(Long id) {
        customerService.delete(id);
    }

    public CustomerDTO updateCustomer(Long id, Customer customer) {
        return updateCustomer(id,customer);
    }
}
