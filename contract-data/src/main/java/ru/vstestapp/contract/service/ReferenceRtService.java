package ru.vstestapp.contract.service;

import org.springframework.stereotype.Service;
import ru.vstestapp.contract.entity.ReferenceRealtyType;
import ru.vstestapp.contract.repository.ReferenceRtRepository;

@Service("ReferenceRtService")
public class ReferenceRtService extends AbstractService<ReferenceRealtyType, ReferenceRtRepository> {
//    @Autowired
    public ReferenceRtService(ReferenceRtRepository repository) {
        super(repository);
    }
}
