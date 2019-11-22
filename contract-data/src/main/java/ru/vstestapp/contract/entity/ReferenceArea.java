package ru.vstestapp.contract.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("a")
public class ReferenceArea extends AbstractReferences {
    public ReferenceArea() {
    }

    public ReferenceArea(String name, Float value, Float rangeFrom, Float rangeTo) {
        super(name, value, rangeFrom, rangeTo);
    }
}
