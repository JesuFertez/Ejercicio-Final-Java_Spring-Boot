package com.jesucompany.ejerciciospringboot.presenter.service;

import com.jesucompany.ejerciciospringboot.model.database.Contract;
import com.jesucompany.ejerciciospringboot.model.database.Customer;
import com.jesucompany.ejerciciospringboot.model.database.Plan;
import com.jesucompany.ejerciciospringboot.model.dto.ContractDTO;
import com.jesucompany.ejerciciospringboot.model.repository.ContractsRepository;
import com.jesucompany.ejerciciospringboot.model.repository.CustomerRepository;
import com.jesucompany.ejerciciospringboot.model.repository.PlansRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractsService implements ContractServiceInterface{
    private final ContractsRepository contractsRepository;
    private final CustomerRepository customerRepository;
    private final PlansRepository plansRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContractsService(ContractsRepository contractsRepository, CustomerRepository customerRepository,
                            PlansRepository plansRepository) {
        this.contractsRepository = contractsRepository;
        this.customerRepository = customerRepository;
        this.plansRepository = plansRepository;
    }

    @Override
    public List<ContractDTO> getAllContracts() {
        List<Contract> contracts = contractsRepository.findAll();
        List<ContractDTO> contractDTOs = new ArrayList<>();
        contracts.forEach(contract -> {
            contractDTOs.add(modelMapper.map(contract, ContractDTO.class));
        });
        return contractDTOs;
    }

    @Override
    public ContractDTO createContract(Contract contract, Long customerId, Long planId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(!customer.getIsActive()){
            throw new IllegalStateException("El cliente está inactivo, no puede contratar planes");
        }
        Plan plan = plansRepository.findById(planId).orElseThrow(
                ()-> new IllegalArgumentException("Plan no encontrado"));

        contract.setCustomer(customer);
        contract.setPlan(plan);
        contract.setStartDate(contract.getStartDate());
        contract.setEndDate(contract.getEndDate());
        contractsRepository.save(contract);

        ContractDTO contractDTO = modelMapper.map(contract, ContractDTO.class);
        return contractDTO;
    }

    @Override
    public ContractDTO updateContract(Long id,Contract contract){
        Contract contract1 = contractsRepository.findById(id).orElse(null);
        contract1.setCustomer(contract.getCustomer());
        contract1.setPlan(contract.getPlan());
        contract1.setEndDate(contract.getEndDate());
        contract1.setStartDate(contract.getStartDate());
        ContractDTO contractDTO = modelMapper.map(contract,ContractDTO.class);
        return contractDTO;
        }

    @Override
    public ContractDTO getContractById(Long id) {
        return modelMapper.map(contractsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Contract not found")), ContractDTO.class);
    }
    @Override
    public void deleteContractById(Long id) {
        contractsRepository.deleteById(id);
    }

    public List<ContractDTO> getContractsByCustomerId(Long customerId) {
        List<ContractDTO> contractDTOs = new ArrayList<>();
        contractsRepository.findCustomerById(customerId).forEach(contract -> {
            contractDTOs.add(modelMapper.map(contract, ContractDTO.class));
        });
        return contractDTOs;
    }

    @Override
    public List<ContractDTO> getContractsByPlanId(Long planId) {
        List<ContractDTO> contractDTOs = new ArrayList<>();
        contractsRepository.findByPlanId(planId).forEach(contract -> {
            contractDTOs.add(modelMapper.map(contract, ContractDTO.class));
        });
        return contractDTOs;
    }
}
