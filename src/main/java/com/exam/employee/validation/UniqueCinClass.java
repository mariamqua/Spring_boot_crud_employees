package com.exam.employee.validation;

import com.exam.employee.entity.Employee;
import com.exam.employee.service.EmployeeService;
import com.exam.employee.validation.annotations.UniqueCin;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCinClass implements ConstraintValidator<UniqueCin, Employee> {
   @Autowired
   EmployeeService employeeService;

   public boolean isValid(Employee obj, ConstraintValidatorContext context) {
      try {
         return employeeService.findEmployeeByCin(obj.getCin())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
