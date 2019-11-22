package ru.vstestapp.contract.entity;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Справочники
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Table(name = "References")
public abstract class AbstractReferences extends AbstractEntity implements References {
    @Column(length = 50)
    private String name;
    @NotNull
    @Column(columnDefinition="NUMBER(10,2)")
    private Float value;
    @Column(columnDefinition="NUMBER(10,2)")
    private Float rangeFrom;
    @Column(columnDefinition="NUMBER(10,2)")
    private Float rangeTo;

    public AbstractReferences() {
    }

    public AbstractReferences(String name, Float value) {
        this.name = name;
        this.value = value;
    }

    public AbstractReferences(String name, Float value, Float rangeFrom, Float rangeTo) {
        this.name = name;
        this.value = value;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public void setValue(Float value) {
        this.value = value;
    }

    public Float getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Float rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public Float getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Float rangeTo) {
        this.rangeTo = rangeTo;
    }
}
