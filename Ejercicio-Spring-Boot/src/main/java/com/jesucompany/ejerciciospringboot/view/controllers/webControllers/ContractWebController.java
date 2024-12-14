package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.ContractsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/web-contracts")
public class ContractWebController {

    private final ContractsService contractsService;

    public ContractWebController(ContractsService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping
    public String getAllContracts(Model model) {
        List<ContractDTO> contracts = contractsService.getAllContracts();
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
            @ModelAttribute Contract contract,
            @RequestParam Long planId,
            @RequestParam Long customerId,
            RedirectAttributes redirectAttributes) {
        try {
            contractsService.createContract(contract, planId, customerId);
            redirectAttributes.addFlashAttribute("message", "Contrato creado exitosamente.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/web-contracts";
    }
}