package ru.vstestapp.contract.web.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.vstestapp.contract.entity.ReferenceRealtyType;
import ru.vstestapp.contract.service.ReferenceRtService;

//@Component
public class ReferenceRealtyTypeByIdConverter implements Converter<Long, ReferenceRealtyType> {
    @Autowired
    private ReferenceRtService rtService;

    @Override
    public ReferenceRealtyType convert(Long id) {
        return rtService.findById(Long.valueOf(id)).orElse(null);
    }
}
