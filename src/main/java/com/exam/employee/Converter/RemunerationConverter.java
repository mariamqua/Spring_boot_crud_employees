package com.exam.employee.Converter;

import com.exam.employee.entity.Remuneration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RemunerationConverter implements Converter<String, Remuneration> {
    @Override
    public Remuneration convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new Remuneration(Long.parseLong(source));
        }
    }
}
