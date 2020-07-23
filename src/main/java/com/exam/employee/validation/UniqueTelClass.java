package com.exam.employee.validation;


import com.exam.employee.entity.Employee;
import com.exam.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueTelClass implements ConstraintValidator<UniqueTel, Employee> {
   @Autowired
   EmployeeService employeeService;
   public boolean isValid(Employee obj, ConstraintValidatorContext context) {

      try {
         return employeeService.findEmployeeByTel(obj.getTel())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
