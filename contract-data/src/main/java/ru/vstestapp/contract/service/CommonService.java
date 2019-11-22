package ru.vstestapp.contract.service;

import ru.vstestapp.contract.entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends IEntity> {
    Optional<E> findById(Long id);
    List<E> findAll();
    E save(E entity);
}
