package com.exam.employee.Converter;

import com.exam.employee.entity.Employee;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {
    @Override
    public Employee convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new Employee(Long.parseLong(source));
        }
    }
}
