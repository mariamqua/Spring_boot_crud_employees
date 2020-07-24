package com.exam.employee.service;

import com.exam.employee.entity.Remuneration;
import com.exam.employee.exception.ResourceNotFoundException;
import com.exam.employee.repository.RemunerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class RemunerationServiceImpl implements RemunerationService {

    @Autowired
    private RemunerationRepository remunerationRepository;

    @Override
    public List<Remuneration> getAllRumuneration() {
        List<Remuneration> all = remunerationRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Remuneration findById(long id) throws ResourceNotFoundException {
        return remunerationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Remuneration remuneration) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        remuneration.setCreated(timestamp);
        remunerationRepository.save(remuneration);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        remunerationRepository.deleteById(id);
    }
}
