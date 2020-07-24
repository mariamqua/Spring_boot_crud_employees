package com.exam.employee.service;


import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import com.exam.employee.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);
    void deleteById(long  id);
    public List<Employee> getSousJacents(long  id);
    public Employee findEmployeeByCin(String cin);
    public Employee findEmployeeByEmail( String email);
    public Employee findEmployeeByTel(String tel);
    public List<Employee> getAllEmployees();
    public Employee findEmployeeById(long  id) throws ResourceNotFoundException;

}
