package com.exam.employee.Converter;

import com.exam.employee.entity.Departement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartementConverter implements Converter<String, Departement> {
    @Override
    public Departement convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new Departement(Short.parseShort(source));
        }
    }
}
