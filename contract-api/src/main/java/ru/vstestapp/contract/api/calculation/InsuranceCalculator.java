package ru.vstestapp.contract.api.calculation;

import ru.vstestapp.contract.entity.Insurance;

public interface InsuranceCalculator {
    String calculate(Insurance insurance);
}
