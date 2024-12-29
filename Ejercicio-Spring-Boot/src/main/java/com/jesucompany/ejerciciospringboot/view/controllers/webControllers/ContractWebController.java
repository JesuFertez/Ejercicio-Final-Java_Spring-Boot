package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.ContractPresenter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/web-contracts")
public class ContractWebController {

    private final ContractPresenter contractPresenter;


    public ContractWebController(ContractPresenter contractPresenter) {
        this.contractPresenter = contractPresenter;
    }

    @GetMapping
    public String getAllContracts(Model model) {
        List<ContractDTO> contracts = contractPresenter.getAllContracts();
        model.addAttribute("contracts", contracts); // Pasar los datos al modelo
        return "web-contracts";
    }

    @GetMapping("/create-contract")
    public String showFormCreate(Model model) {
        model.addAttribute("contract", new Contract()); // Formulario vacío
        return "create-contract"; // Carga la plantilla crear-contrato.html
    }
    @PostMapping("/save")
    public String createContract(
            @RequestParam Long customerId,
            @RequestParam Long planId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            RedirectAttributes redirectAttributes) {
        Contract contract = new Contract(startDate,endDate);
        try {
            contractPresenter.createContract(contract, planId, customerId);
            redirectAttributes.addFlashAttribute("message", "Contrato creado exitosamente.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/web-contracts";
    }
}