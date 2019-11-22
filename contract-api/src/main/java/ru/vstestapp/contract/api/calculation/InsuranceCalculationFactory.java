package ru.vstestapp.contract.api.calculation;

public interface InsuranceCalculationFactory<T extends CalculationStrategy> {
    T getStrategy(String strategyName);
}
