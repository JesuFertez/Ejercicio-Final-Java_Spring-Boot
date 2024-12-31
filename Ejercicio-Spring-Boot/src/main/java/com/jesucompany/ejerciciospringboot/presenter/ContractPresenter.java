package com.jesucompany.ejerciciospringboot.presenter;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.presenter.service.ContractsServiceImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ContractPresenter {

    ContractsServiceImpl contractsService;

    public ContractPresenter(ContractsServiceImpl contractsService) {
        this.contractsService = contractsService;
    }

    public List<ContractDTO> getAllContracts() {
        return  contractsService.getAllContracts();
    }

    public ContractDTO createContract(Long customerId, Long planId, LocalDate startDate, LocalDate endDate) {
        return contractsService.createContract(customerId, planId, startDate, endDate);
    }

    public ContractDTO updateContract(Long id, Contract contract){
        return contractsService.updateContract(id,contract);
    }

    public ContractDTO getContractById(Long id){
        return contractsService.getContractById(id);
    }

    public void deleteContract(Long id){
        contractsService.deleteContractById(id);
    }

    public List<ContractDTO> getContractByCustomerID(Long customerId){
       return contractsService.getContractsByCustomerId(customerId);
    }

    public List<ContractDTO> getContractsByPlanId(Long planId){
    return contractsService.getContractsByPlanId(planId);
    }
}
