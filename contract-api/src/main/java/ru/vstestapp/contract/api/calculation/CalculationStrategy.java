package ru.vstestapp.contract.api.calculation;

public interface CalculationStrategy {
    /**
     * Расчет страховой премии 
     * @param insuranceAmount - Страховая сумма
     * @param daysCount - кол-во дней
     * @param coefficientRt - Коэф.ТН
     * @param coefficientYoc - Коэф.ГП
     * @param coefficientArea - Коэф.Пл
     * @return 
     */
    String calculate(Integer insuranceAmount,Integer daysCount,Float coefficientRt,Float coefficientYoc,Float coefficientArea);
}
