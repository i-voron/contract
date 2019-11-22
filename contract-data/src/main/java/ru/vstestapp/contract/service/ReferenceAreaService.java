package ru.vstestapp.contract.service;

import org.springframework.stereotype.Service;
import ru.vstestapp.contract.entity.ReferenceArea;
import ru.vstestapp.contract.repository.ReferenceAreaRepository;

@Service("ReferenceAreaService")
public class ReferenceAreaService extends AbstractService<ReferenceArea, ReferenceAreaRepository> {
//    @Autowired
    public ReferenceAreaService(ReferenceAreaRepository repository) {
        super(repository);
    }

    public Float findByRangeCoefficient(Float rangeValue){
        return repository.findByRangeCoefficient(rangeValue);
    }
}
