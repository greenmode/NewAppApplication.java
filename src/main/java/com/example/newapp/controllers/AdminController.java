package com.example.newapp.controllers;

import com.example.newapp.models.Requests;
import com.example.newapp.repo.RequestsRepo;
import com.example.newapp.repo.RolesRepo;
import com.example.newapp.repo.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private RequestsRepo requestsRepo;

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Requests> userRequests = requestsRepo.findAllByStateId(5); // передаются заявки с сост. "на рассмотрении админа"
        Requests[] requestsArray = userRequests.toArray(new Requests[0]);

        model.addAttribute("requests", requestsArray);
        return "admin";
    }

    @GetMapping("/admin/confirm/{id}")
    public String admin_confirm(@PathVariable(value = "id") Integer id) {
        Requests requests = requestsRepo.findById(id).orElseThrow();
        requests.setStateId(7); // устан. статус "выполнена"
        requestsRepo.save(requests);
        return "redirect:/admin";
    }
    @GetMapping("/admin/dismiss/{id}")
    public String admin_dismiss(@PathVariable(value = "id") Integer id) {
        Requests requests = requestsRepo.findById(id).orElseThrow();
        requests.setStateId(6); // устан. статус "отклонена"
        requestsRepo.save(requests);
        return "redirect:/admin";
    }
}
