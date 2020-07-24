package com.exam.employee.repository;

import com.exam.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select e from Employee e where e.manager.id=:id")
    public List<Employee> getSousJacents(@Param("id") long id);

    public Employee findEmployeeByCin(String cin);
    public Employee findEmployeeByEmail( String email);
    public Employee findEmployeeByTel(String tel);
    public Employee findEmployeeById(long  id);

    @Query("select e from Employee e where e.id  <>:id")
    public List<Employee> getAllEmployeesExceptOne(@Param("id") long id);
}
