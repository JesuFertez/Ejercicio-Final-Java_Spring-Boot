package com.jesucompany.ejerciciospringboot.view.controllers.restControllers;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.ContractPresenter;
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
    public List<ContractDTO>getAllContracts(){
        return contractPresenter.getAllContracts();
    }

    @GetMapping("/{id}")
    public ContractDTO getContractById(@PathVariable Long id){
        return contractPresenter.getContractById(id);
    }

    @PostMapping
    public ContractDTO createContract( @RequestBody Contract contract,
                                       @RequestParam Long customerId,
                                      @RequestParam Long planId){
        return  contractPresenter.createContract(contract,customerId,planId );
    }

    @PutMapping("/{id}")
    public ContractDTO updateContract(@PathVariable("id")Long id, @RequestBody Contract contract){
        return contractPresenter.updateContract(id,contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id){
       contractPresenter.deleteContract(id);
    }

    @GetMapping("/customer/{customer_id}")
    public List<ContractDTO> getContractsByCustomerId(@PathVariable Long customerId){
        return contractPresenter.getContractByCustomerID(customerId);
    }

    @GetMapping("/plan/{planId}")
    public List<ContractDTO> getContractsByPlanId(@PathVariable Long planId){
        return contractPresenter.getContractsByPlanId(planId);
    }

}
