package com.jesucompany.ejerciciospringboot.presenter.service;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;

import java.util.List;

public interface ContractServiceInterface {
    public List<ContractDTO> getAllContracts();
    public ContractDTO createContract(Contract contract, Long customerId, Long planId);
    public ContractDTO updateContract(Long id,Contract contract);
    public ContractDTO getContractById(Long id);
    public void deleteContractById(Long id);
    public List<ContractDTO> getContractsByCustomerId(Long customerId);
    public List<ContractDTO> getContractsByPlanId(Long planId);
}
