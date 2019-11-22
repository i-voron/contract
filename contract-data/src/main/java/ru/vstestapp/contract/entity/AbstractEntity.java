package ru.vstestapp.contract.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AbstractEntity() {
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        IEntity that = (IEntity) o;

        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + (null == getId() ? super.hashCode() : getId().hashCode());
        return hash;
    }

}
