package ru.vstestapp.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vstestapp.contract.entity.Insurant;
import ru.vstestapp.contract.repository.InsurantRepository;

import java.util.List;

@Service("InsurantService")
public class InsurantService extends AbstractService<Insurant, InsurantRepository> {
    @Autowired
    public InsurantService(InsurantRepository repository) {
        super(repository);
    }

    public List<Insurant> findFio(String surname, String name, String patronymic) {
        return repository.findFio(surname,name,patronymic);
    }
}
