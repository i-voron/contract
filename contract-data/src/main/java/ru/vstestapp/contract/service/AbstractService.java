package ru.vstestapp.contract.service;

import ru.vstestapp.contract.entity.IEntity;
import ru.vstestapp.contract.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService<E extends IEntity, R extends CommonRepository<E>> implements CommonService<E> {
    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }


}
