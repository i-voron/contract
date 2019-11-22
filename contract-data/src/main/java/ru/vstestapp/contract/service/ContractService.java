package ru.vstestapp.contract.service;

import org.springframework.stereotype.Service;
import ru.vstestapp.contract.entity.Contract;
import ru.vstestapp.contract.repository.ContractRepository;

import java.util.Optional;

@Service
public class ContractService extends AbstractService<Contract,ContractRepository> {
    public ContractService(ContractRepository repository) {
        super(repository);
    }

    public Optional<Contract> findByContractNumber(Long contractId, Integer contractNumber) {
        return repository.findByIdNotAndContractNumber(contractId,contractNumber);
    }

}
