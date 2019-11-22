package ru.vstestapp.contract.service;

import org.springframework.stereotype.Service;
import ru.vstestapp.contract.entity.ReferenceYearOfConstruction;
import ru.vstestapp.contract.repository.ReferenceYocRepository;

@Service("ReferenceYocService")
public class ReferenceYocService extends AbstractService<ReferenceYearOfConstruction, ReferenceYocRepository> {
//    @Autowired
    public ReferenceYocService(ReferenceYocRepository repository) {
        super(repository);
    }

    public Float findByRangeCoefficient(Float rangeValue){
        return repository.findByRangeCoefficient(rangeValue);
    }
}
