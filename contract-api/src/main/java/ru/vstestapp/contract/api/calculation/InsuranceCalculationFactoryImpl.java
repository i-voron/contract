package ru.vstestapp.contract.api.calculation;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class InsuranceCalculationFactoryImpl implements InsuranceCalculationFactory<CalculationStrategy> {
    private final Map<String, CalculationStrategy> strategyMap;

    public InsuranceCalculationFactoryImpl(Map<String, CalculationStrategy> strategyMap) {
        this.strategyMap = Collections.unmodifiableMap(strategyMap);
    }

    @Override
    public CalculationStrategy getStrategy(String strategyName) {
        return strategyMap.get(strategyName);
    }
}
