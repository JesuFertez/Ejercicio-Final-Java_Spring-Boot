package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.ContractPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {

    private final ContractPresenter contractPresenter;

    public ContractRestController(ContractPresenter contractPresenter) {
        this.contractPresenter = contractPresenter;
    }

    @GetMapping
    public ResponseEntity<List<ContractDTO>> getAllContracts() {
        try {
            List<ContractDTO> contracts = contractPresenter.getAllContracts();
            return ResponseEntity.ok(contracts);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable Long id) {
        try {
            ContractDTO contractDTO = contractPresenter.getContractById(id);
            return ResponseEntity.ok(contractDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ContractDTO> createContract(@RequestBody Contract contract,
                                                      @RequestParam Long customerId,
                                                      @RequestParam Long planId) {
        try {
            ContractDTO contractDTO = contractPresenter.createContract(contract, customerId, planId);
            return ResponseEntity.ok(contractDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractDTO> updateContract(@PathVariable("id") Long id, @RequestBody Contract contract) {
        try {
            ContractDTO contractDTO = contractPresenter.updateContract(id, contract);
            return ResponseEntity.ok(contractDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        try {
            contractPresenter.deleteContract(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<List<ContractDTO>> getContractsByCustomerId(@PathVariable Long customerId) {
        try {
            List<ContractDTO> contracts = contractPresenter.getContractByCustomerID(customerId);
            return ResponseEntity.ok(contracts);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<List<ContractDTO>> getContractsByPlanId(@PathVariable Long planId) {
        try {
            List<ContractDTO> contracts = contractPresenter.getContractsByPlanId(planId);
            return ResponseEntity.ok(contracts);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
