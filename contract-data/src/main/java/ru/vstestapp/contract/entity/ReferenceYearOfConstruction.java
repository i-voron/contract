package ru.vstestapp.contract.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("yoc")
public class ReferenceYearOfConstruction extends AbstractReferences {

    public ReferenceYearOfConstruction() {
    }

    public ReferenceYearOfConstruction(String name, Float value, Float rangeFrom, Float rangeTo) {
        super(name, value, rangeFrom, rangeTo);
    }
}
