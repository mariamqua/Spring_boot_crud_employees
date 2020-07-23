package com.exam.employee.controller;

import com.exam.employee.entity.Departement;
import com.exam.employee.entity.Employee;
import com.exam.employee.service.DepartementService;
import com.exam.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/departements"})
public class DepartementController {


    @Autowired
    DepartementService departementService;

    @GetMapping(value = {"/"})
    public String index( ModelMap model){
        List<Departement> liste = departementService.getAllDepartements();
        model.addAttribute("liste", liste);
        return "departement/index";
    }
    @GetMapping("/add")
    public String add(ModelMap model,Departement departement) {
        model.addAttribute("departement", departement);
        return "departement/add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("departement") Departement departement, BindingResult result, ModelMap model) {
        if(result.hasErrors()){
            model.addAttribute("departement",departement);
            return "add";
        }
       departementService.save(departement);
        return "redirect:/departements/";
    }
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") short  id, ModelMap model){
        model.addAttribute("departement",departementService.findDepartementById(id));
        return "departement/view";
    }

    @GetMapping("/add/{id}")
    public String edit(@PathVariable("id") Short id, ModelMap model)  {
        Departement departement=departementService.findDepartementById(id);

        model.addAttribute("departement",departement );

        return "departement/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Short id, ModelMap model) {
        departementService.deleteById(id);
        return "redirect:/departements/";
    }
}
