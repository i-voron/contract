package ru.vstestapp.contract.entity;

import org.springframework.format.annotation.DateTimeFormat;
import ru.vstestapp.contract.validation.ContractNumberUnique;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;


/**
 * Договор
 */
@Entity
@ContractNumberUnique
public class Contract extends AbstractEntity {
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    @Valid
    private Insurant insurant;
    @Embedded
    @Valid
    private Address address;
    @Embedded
    @Valid
    private Insurance insurance;
    @NotNull
//    @ContractNumberUnique
    @PositiveOrZero
    private Integer contractNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conclusionDate ;
    @Column(length = 500)
    private String comments;
    
    @PrePersist
    void conclusionDate() {
        this.conclusionDate = new Date();
    }

    public Insurant getInsurant() {
        return insurant;
    }

    public void setInsurant(Insurant insurant) {
        this.insurant = insurant;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
