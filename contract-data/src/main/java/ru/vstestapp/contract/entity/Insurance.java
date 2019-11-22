package ru.vstestapp.contract.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vstestapp.contract.validation.ContractDuration;
import ru.vstestapp.contract.validation.IsNumberJsonDeserializeConverter;
import ru.vstestapp.contract.validation.PastOrPresentYear;
import ru.vstestapp.contract.validation.RealtyTypeIsSelected;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Расчет. Страховая премия
 */
@ContractDuration
@Embeddable
public class Insurance {
    @JsonDeserialize(converter = IsNumberJsonDeserializeConverter.class)
    @NotNull
    @PositiveOrZero(message = "{NumberPositiveOrZero.message}")
    private Integer insuranceAmount; //Страховая сумма
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFrom;
    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateTo;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date calculationDate;

    @PastOrPresentYear
    private String yearOfConstruction;

    @NotNull
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d)?$", message = "{javax.validation.constraints.NotNull.message}")
    private String area;

    @NotNull
    @RealtyTypeIsSelected
    @ManyToOne
    private ReferenceRealtyType realtyType;

    @NotNull
    @Pattern(regexp = "^(0|[1-9]\\d*)(\\.\\d[0-9]{0,1})?$", message = "{javax.validation.constraints.NotNull.message}")
    private String insurancePremium; //Страховая премия

    @PrePersist
    void dateFrom() {
        this.dateFrom = new Date();
    }

    public Insurance() {
    }

    public Insurance(@NotNull @PositiveOrZero Integer insuranceAmount, @NotNull @PastOrPresent Date dateFrom, @NotNull @Future Date dateTo, @NotNull Date calculationDate, String yearOfConstruction, @NotNull @Pattern(regexp = "^[1-9]\\d*(\\.\\d)?$", message = "Invalid area") String area, @NotNull ReferenceRealtyType realtyType, @NotNull @Pattern(regexp = "^(0|[1-9]\\d*)(\\.\\d[0-9]{0,1})?$", message = "Invalid bonusSum") String insurancePremium) {
        this.insuranceAmount = insuranceAmount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.calculationDate = calculationDate;
        this.yearOfConstruction = yearOfConstruction;
        this.area = area;
        this.realtyType = realtyType;
        this.insurancePremium = insurancePremium;
    }

    public Integer getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Integer insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(Date calculationDate) {
        this.calculationDate = calculationDate;
    }

    public String getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(String yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInsurancePremium() {
        return insurancePremium;
    }

    public void setInsurancePremium(String insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    public ReferenceRealtyType getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(ReferenceRealtyType realtyType) {
        this.realtyType = realtyType;
    }
}
