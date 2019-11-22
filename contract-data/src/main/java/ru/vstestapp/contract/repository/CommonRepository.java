package ru.vstestapp.contract.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.vstestapp.contract.entity.IEntity;

import java.util.List;

@NoRepositoryBean
public interface CommonRepository<T extends IEntity> extends CrudRepository<T, Long> {
    List<T> findAll();
    
}
