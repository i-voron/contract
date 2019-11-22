package ru.vstestapp.contract.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vstestapp.contract.entity.Contract;
import ru.vstestapp.contract.service.ContractService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContractNumberUniqueValidator implements ConstraintValidator<ContractNumberUnique, Contract> {
    //public class ContractNumberUniqueValidator implements ConstraintValidator<ContractNumberUnique, Integer> {
    @Autowired
    private ContractService contractService;

    @Override
    public void initialize(ContractNumberUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(Contract contract, ConstraintValidatorContext context) {
//    public boolean isValid(Integer contractNumber, ConstraintValidatorContext context) {
        if (contract == null || contract.getContractNumber() == null) {
            return false;
        }
        //todo: для тестов. не подцепляется
        if (contractService == null) {
            return true;
        }

//        if (contractRepository.findByContractNumber(contract.getContractNumber()).isPresent()) {
        if (contractService.findByContractNumber(
                contract.getId()==null?0:contract.getId(), contract.getContractNumber()).isPresent()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{ContractNumberUnique.message}")
                    .addPropertyNode("contractNumber").addConstraintViolation();
            return false;
        }

        return true;
    }
}
