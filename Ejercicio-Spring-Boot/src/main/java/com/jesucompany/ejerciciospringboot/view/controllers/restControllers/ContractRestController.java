package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.ContractsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {

    private final ContractsService contractsService;

    public ContractRestController(ContractsService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping
    public List<ContractDTO>getAllContracts(){
        return contractsService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ContractDTO getContractById(@PathVariable Long id){
        return contractsService.getContractById(id);
    }

    @PostMapping
    public ContractDTO createContract( @RequestBody Contract contract,
                                       @RequestParam Long customerId,
                                      @RequestParam Long planId){
        return  contractsService.createContract(contract,customerId,planId );
    }

    @PutMapping("/{id}")
    public ContractDTO updateContract(@PathVariable("id")Long id, @RequestBody Contract contract){
        return contractsService.updateContract(id,contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id){
        contractsService.deleteContractById(id);
    }

    @GetMapping("/customer/{customer_id}")
    public List<ContractDTO> getContractsByCustomerId(@PathVariable Long customerId){
        return contractsService.getContractsByCustomerId(customerId);
    }

    @GetMapping("/plan/{planId}")
    public List<ContractDTO> getContractsByPlanId(@PathVariable Long planId){
        return contractsService.getContractsByPlanId(planId);
    }

}
