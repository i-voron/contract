package ru.vstestapp.contract.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.vstestapp.contract.web.controller.converter.ReferenceRealtyTypeByIdConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ConversionService conversionService () {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ReferenceRealtyTypeByIdConverter());
        return service;
    }

}