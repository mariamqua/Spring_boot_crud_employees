package com.exam.employee.validation;

import com.exam.employee.entity.Employee;
import com.exam.employee.service.EmployeeService;
import com.exam.employee.validation.annotations.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailClass implements ConstraintValidator<UniqueEmail, Employee> {
   @Autowired
   EmployeeService employeeService;

   public boolean isValid(Employee obj, ConstraintValidatorContext context) {
      try {

         return employeeService.findEmployeeByEmail(obj.getEmail())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
