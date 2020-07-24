package com.exam.employee.service;


import com.exam.employee.entity.Remuneration;
import com.exam.employee.exception.ResourceNotFoundException;

import java.util.List;

public interface RemunerationService {

    public List<Remuneration> getAllRumuneration();

    Remuneration findById(long id) throws ResourceNotFoundException;

    void save(Remuneration remuneration);

    void deleteById(long id);
}
