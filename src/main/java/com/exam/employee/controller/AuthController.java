package com.exam.employee.controller;


import com.exam.employee.entity.User;
import com.exam.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Enumeration;
import java.util.Optional;
@Controller
@RequestMapping(value = {"","/auth"})
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "auth/register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        User userNameExists = userService.findByUsername(user.getUsername());
        User EmailExists = userService.findByEmail(user.getEmail());
        if (userNameExists != null) {
            result
                    .rejectValue("username", "error.user",
                            "Il existe déjà un utilisateur avec ce nom d'utilisateur");
        }
        if (EmailExists != null) {
            result
                    .rejectValue("email", "error.user",
                            "Il existe déjà un utilisateur avec cet email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user",user);
            return "auth/register";
        } else {
            userService.save(user);
            return "redirect:/employees/";

        }
    }


    @GetMapping("/register/{id}")

    public String edit(@PathVariable("id") long id, ModelMap model)  {
        model.addAttribute("user", userService.findById(id));
        return "users/add";
    }


    @GetMapping("/delete/{page}/{id}")
    public String delete(@PathVariable("page") long page, @PathVariable("id") long id, ModelMap model)
           {
        userService.deleteById(id);
        return "redirect:/user/page/" + page;
    }




    @GetMapping("/")
    public String login(Model model) {

        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, BindingResult result, ModelMap model ,
                        HttpSession session, HttpServletRequest request) {
        if(result.hasErrors()){
            model.addAttribute("user",user);
            System.out.println(result);
            return "auth/login";
        }

        if(userService.validateUserCredential(user.getUsername(),user.getPassword())){

            User user1= userService.findByUsername(user.getUsername());

            System.out.println(" -------------- session ----------------");
            Enumeration<String> enumeration = request.getSession(true).getAttributeNames();
            if (enumeration.hasMoreElements()) {
                while (enumeration.hasMoreElements()) {
                    String param = (String) enumeration.nextElement();
                    String value = session.getAttribute(param).toString();
                    System.out.println(param + " From User ====== " + value);
                }
            }
            System.out.println("Request body"+ session.toString());

            session.setAttribute("user", user1.getUsername());

            return "redirect:/employees/";
        }
        else{
            result.rejectValue("password", "error.user",
                    "Echec d'authentification, essayez à nouveau");
        }
        return  "auth/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/";
    }

    @GetMapping("/redirect")
    public String redirect(String str) {
        return "redirect:/"+str;}
}
