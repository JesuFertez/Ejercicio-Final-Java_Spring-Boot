package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/web-customers")
public class CustomerWebController {
    private final CustomerService customerService;

    public CustomerWebController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public String getAllCustomers(Model model){
        List<CustomerDTO> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "web-customers";
    }

    @GetMapping("/create-customer")
    public String showFormCreate(Model model){
        model.addAttribute("customer", new Customer());
        return "create-customer"; //carga plantilla .html
    }

    @PostMapping("/save")
    public String createCustomer(
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam String run,
            @RequestParam String city,
            @RequestParam String commune,
            @RequestParam String street,
            @RequestParam int number,
            @RequestParam LocalDate dateOfBirth,
            @RequestParam String phone,
            @RequestParam Boolean isActive,
            RedirectAttributes redirectAttributes){
        Customer customer = new Customer(name,lastName, run, city,commune,street,number,
                dateOfBirth,phone,isActive);
        try {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message","Cliente creado exitosamente");
        } catch (IllegalStateException | IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/web-customers";
    }
}
