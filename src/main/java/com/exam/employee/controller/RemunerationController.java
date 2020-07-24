package com.exam.employee.controller;

import com.exam.employee.entity.Remuneration;
import com.exam.employee.exception.ResourceNotFoundException;
import com.exam.employee.service.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/remunerations"})
public class RemunerationController {


    @Autowired
    RemunerationService remunerationService;

    @GetMapping(value = {"/"})
    public String index( ModelMap model){
        List<Remuneration> liste = remunerationService.getAllRumuneration();
        model.addAttribute("liste", liste);
        return "remuneration/index";
    }
    @GetMapping("/add")
    public String add(ModelMap model,Remuneration remuneration) {
        model.addAttribute("departement", remuneration);
        return "remuneration/add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("remuneration") Remuneration remuneration,
                       BindingResult result, ModelMap model) {
        if(result.hasErrors()){
            model.addAttribute("remuneration",remuneration);
            return "remuneration/add";
        }
        remunerationService.save(remuneration);
        return "redirect:/remunerations/";
    }
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") short  id, ModelMap model)
            throws ResourceNotFoundException {
        model.addAttribute("remuneration",remunerationService.findById(id));
        return "remuneration/view";
    }

    @GetMapping("/add/{id}")
    public String edit(@PathVariable("id") Short id, ModelMap model) throws ResourceNotFoundException {
        Remuneration remuneration=remunerationService.findById(id);

        model.addAttribute("remuneration",remuneration );

        return "remuneration/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Short id, ModelMap model) {
        remunerationService.deleteById(id);
        return "redirect:/remunerations/";
    }
}
