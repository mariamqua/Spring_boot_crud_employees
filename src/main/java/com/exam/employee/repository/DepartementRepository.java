package com.exam.employee.repository;

import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {


    public Departement findDepartementById(long  id);

}
