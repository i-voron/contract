package ru.vstestapp.contract.validation;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.util.NumberUtils;

public class IsNumberJsonDeserializeConverter extends StdConverter<Object, Object> {
    @Override
    public Object convert(Object value) {
        try {
            value = NumberUtils.parseNumber(value.toString(), Integer.class);
        } catch (NullPointerException | NumberFormatException ex) {
            try {
                value = NumberUtils.parseNumber(value.toString(), Double.class);
            } catch (NullPointerException | NumberFormatException ex2) {
                return -1;
            }
        }
        return value;
    }
}
