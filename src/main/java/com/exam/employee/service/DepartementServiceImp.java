package com.exam.employee.service;

import com.exam.employee.entity.Departement;

import com.exam.employee.entity.Employee;
import com.exam.employee.exception.ResourceNotFoundException;
import com.exam.employee.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartementServiceImp implements DepartementService {
    @Autowired
    DepartementRepository departementRepository;

    @Override
    @Transactional
    public void save(Departement departement) {
        departementRepository.save(departement);
    }


    @Override
    @Transactional
    public void deleteById(long  id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement findDepartementById( long  id)throws ResourceNotFoundException {
        return departementRepository.findDepartementById(id);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }
}
