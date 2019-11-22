package ru.vstestapp.contract.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 * Страхователь
 */
@Entity
public class Insurant extends AbstractEntity {
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String surname;
    @NotBlank(message = "{javax.validation.constraints.NotNull.message}")
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String patronymic;
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @NotNull
    @Embedded
    @Valid
    private Passport passport;

    public Insurant() {
    }

    public Insurant(@NotBlank(message = "surname is required") String surname, @NotBlank(message = "name is required") String name, String patronymic, @NotNull @PastOrPresent Date birthday, @NotNull Passport passport) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passport = passport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
