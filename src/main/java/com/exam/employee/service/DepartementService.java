package com.exam.employee.service;


import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;

import java.util.List;

public interface DepartementService {
    public List<Departement> getAllDepartements();
    void save(Departement departement);
    void deleteById(short id);
    public Departement findDepartementById( short id);

}
