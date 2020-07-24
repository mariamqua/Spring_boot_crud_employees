package com.exam.employee.controller;

import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import com.exam.employee.exception.ResourceNotFoundException;
import com.exam.employee.service.DepartementService;
import com.exam.employee.service.EmployeeService;
import com.exam.employee.service.RemunerationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/employees"})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartementService departementService;

    @Autowired
    RemunerationService remunerationService;

    @GetMapping(value = {"/"})
    public String index( ModelMap model){
        List<Employee> liste = employeeService.getAllEmployees();
        model.addAttribute("liste", liste);
        return "employee/index";
    }
    @GetMapping("/add")
    public String add(ModelMap model,Employee employee) {
        model.addAttribute("remuneration",remunerationService.getAllRumuneration() );
        model.addAttribute("departement",departementService.getAllDepartements() );
        model.addAttribute("employee",employee);
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employee/add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
        if(result.hasErrors()){
            model.addAttribute("remuneration",remunerationService.getAllRumuneration() );
            model.addAttribute("departement",departementService.getAllDepartements() );
            model.addAttribute("employee",employee);
            model.addAttribute("employees",employeeService.getAllEmployees());
            return "employee/add";
        }
        employee.setMot_de_passe(employee.getCin()+employee.getTel());
       employeeService.save(employee);
        return "redirect:/employees/";
    }
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") long  id, ModelMap model) throws ResourceNotFoundException {
        model.addAttribute("employee",employeeService.findEmployeeById(id));
        model.addAttribute("liste",employeeService.getSousJacents(employeeService.findEmployeeById(id).getId()));
        return "employee/view";
    }

    @GetMapping("/add/{id}")
    public String edit(@PathVariable("id") Short id, ModelMap model) throws ResourceNotFoundException {
        Employee employee=employeeService.findEmployeeById(id);
       /* Departement departement=departementService.findDepartementById(employee.getDepartement().getId());
        model.addAttribute("departement",departementService.getAllDepartements() );
        model.addAttribute("employee",employee);
        model.addAttribute("employees",employeeService.getAllEmployees());

        return "admin/add";*/
        model.addAttribute("remuneration",remunerationService.getAllRumuneration() );
        model.addAttribute("departement",departementService.getAllDepartements() );
        model.addAttribute("employee",employee);
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employee/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long  id, ModelMap model) {
        employeeService.deleteById(id);
        return "redirect:/employees/";
    }

}
