package com.example.newapp.controllers;

import com.example.newapp.models.Employees;
import com.example.newapp.models.UserSet;
import com.example.newapp.repo.EmployeesRepo;
import com.example.newapp.repo.UserSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {
    @Autowired
    private EmployeesRepo employeesRepo;
    @Autowired
    private UserSetRepo userSetRepo;

    @GetMapping("/auth")
    public String auth(Model model) {
        Iterable<Employees> employees = employeesRepo.findAll();
        model.addAttribute("employees", employees);
        return "auth";
    }

    @GetMapping("/auth/{empId}")
    public String authPost(@PathVariable(value = "empId") Integer empId, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("empId", empId.toString());
        cookie.setPath("/");
        cookie.setMaxAge(360000);
        response.addCookie(cookie);
        Iterable<UserSet> users = userSetRepo.findAllByEmployeeId(empId);
        model.addAttribute("users", users);
        model.addAttribute("empId", empId);
        auth(model);
        return "auth";
    }

    @PostMapping("/auth/enter")
    public String enter(@RequestParam Integer user, HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", user.toString());
        cookie.setPath("/");
        cookie.setMaxAge(360000);
        response.addCookie(cookie);
        if (user == 16) {
            return "redirect:/admin";
        }
        if (user == 17) {
            return "redirect:/owner";
        }
        return "redirect:/user";
    }
}
