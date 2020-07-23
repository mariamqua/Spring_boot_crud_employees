package com.exam.employee.service;

import com.exam.employee.entity.Employee;
import com.exam.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(Employee e) {
        employeeRepository.save(e);
    }


    @Override
    @Transactional
    public void deleteById(short id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getSousJacents(short id) {
        return employeeRepository.getSousJacents(id);
    }

    @Override
    public Employee findEmployeeById(short id) {return employeeRepository.findEmployeeById(id);}

    @Override
    public Employee findEmployeeByCin(String cin) {
        return employeeRepository.findEmployeeByCin(cin);
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Employee findEmployeeByTel(String tel) {
        return employeeRepository.findEmployeeByTel(tel);
    }

}
