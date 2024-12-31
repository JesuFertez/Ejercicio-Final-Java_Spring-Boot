package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.model.dto.CustomerDTO;
import com.jesucompany.ejerciciospringboot.presenter.CustomerPresenter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/web-customers")
public class CustomerWebController {
    private final CustomerPresenter customerPresenter;

    public CustomerWebController(CustomerPresenter customerPresenter){
        this.customerPresenter = customerPresenter;
    }

    @GetMapping
    public String getAllCustomers(Model model){
        List<CustomerDTO> customers = customerPresenter.findAll();
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
            customerPresenter.createCustomer(name,lastName, run, city,commune,street,number,
                    dateOfBirth,phone,isActive);
            redirectAttributes.addFlashAttribute("message","Cliente creado exitosamente");
        return "redirect:/web-customers";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id, Model model){
        CustomerDTO customerDTO = customerPresenter.getCustomerById(id);
        List<ContractDTO> contractDTO = customerPresenter.getCustomerById(id).getContracts();
        model.addAttribute("customerDTO", customerDTO);
        model.addAttribute("contractDTO", contractDTO);
        return "customer-details";
    }
}
