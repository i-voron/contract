package ru.vstestapp.contract.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.vstestapp.contract.validation.DigitsCount;
import ru.vstestapp.contract.validation.IsNumberJsonDeserializeConverter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class Passport {
    @JsonDeserialize(converter = IsNumberJsonDeserializeConverter.class)
    @NotNull
    @Positive(message = "{NumberPositive.message}")
    @DigitsCount
//    @Digits(integer=4, fraction=0)
    private Integer series;
    @JsonDeserialize(converter = IsNumberJsonDeserializeConverter.class)
    @NotNull
    @Positive(message = "{NumberPositive.message}")
    @DigitsCount(count = 6)
//    @Digits(integer=6, fraction=0)
    private Integer number;

    public Passport() {
    }

    public Passport(@NotNull @Digits(integer = 4, fraction = 0) Integer series, @NotNull @Digits(integer = 6, fraction = 0) Integer number) {
        this.series = series;
        this.number = number;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
