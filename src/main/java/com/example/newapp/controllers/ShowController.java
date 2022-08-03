package com.example.newapp.controllers;

import com.example.newapp.models.Requests;
import com.example.newapp.models.Services;
import com.example.newapp.repo.RequestsRepo;
import com.example.newapp.repo.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ShowController {
    @Autowired
    private ServicesRepo servicesRepo;

    @GetMapping("/service_view/{id}")
    public String service_view(@PathVariable(value = "id") Integer serviceId, Model model) {
        Services service = servicesRepo.findByServiceId(serviceId);
        //Services[] sArray = userRequests.toArray(new Requests[0]);

        model.addAttribute("service", service);
        return "showservice";
    }
}
