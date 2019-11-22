package ru.vstestapp.contract.api.calculation;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Формула (Страховая сумма / кол-во дней) * Коэф.ТН * Коэф.ГП * Коэф.Пл
 */
@Component("InsCalcA")
public class InsuranceCalculationStrategyA implements CalculationStrategy {
    @Override
    public String calculate(Integer insuranceAmount, Integer daysCount,
                            Float coefficientRt, Float coefficientYoc, Float coefficientArea) {

        Float result=(insuranceAmount/daysCount)*coefficientRt*coefficientYoc*coefficientArea;

        DecimalFormatSymbols dfs=DecimalFormatSymbols.getInstance(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#0.##",dfs);

        return df.format(result);
    }
}
