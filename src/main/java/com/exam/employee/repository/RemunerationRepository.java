package com.exam.employee.repository;

import com.exam.employee.entity.Remuneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemunerationRepository extends JpaRepository<Remuneration,Long> {
    List<Remuneration> findAll();

}
