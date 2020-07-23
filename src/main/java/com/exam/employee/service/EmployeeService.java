package com.exam.employee.service;


import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);
    void deleteById(short id);
    public List<Employee> getSousJacents(short id);
    public Employee findEmployeeByCin(String cin);
    public Employee findEmployeeByEmail( String email);
    public Employee findEmployeeByTel(String tel);
    public List<Employee> getAllEmployees();
    public Employee findEmployeeById(short id);

}
