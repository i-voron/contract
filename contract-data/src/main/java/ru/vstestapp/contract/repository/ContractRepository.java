package ru.vstestapp.contract.repository;

import org.springframework.stereotype.Repository;
import ru.vstestapp.contract.entity.Contract;

import java.util.Optional;

@Repository
public interface ContractRepository extends CommonRepository<Contract> {
    Optional<Contract> findByIdNotAndContractNumber(Long id, Integer contractNumber);
}
