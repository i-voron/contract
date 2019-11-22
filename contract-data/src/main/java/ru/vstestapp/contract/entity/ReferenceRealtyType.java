package ru.vstestapp.contract.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("rt")
public class ReferenceRealtyType extends AbstractReferences {
    public ReferenceRealtyType() {
    }

    public ReferenceRealtyType(String name, Float value) {
        super(name, value);
    }
}
