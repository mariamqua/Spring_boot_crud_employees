package com.exam.employee.service;


import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import com.exam.employee.exception.ResourceNotFoundException;

import java.util.List;

public interface DepartementService {
    public List<Departement> getAllDepartements();
    void save(Departement departement);
    void deleteById(long id);
    public Departement findDepartementById( long  id) throws ResourceNotFoundException;

}
