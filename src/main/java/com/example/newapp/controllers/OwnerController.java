package com.example.newapp.controllers;

import com.example.newapp.models.Requests;
import com.example.newapp.repo.RequestsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    private RequestsRepo requestsRepo;

    @GetMapping("/owner")
    public String owner(Model model) {
        List<Requests> userRequests = requestsRepo.findAllByStateId(2); // передаются заявки с сост. "на рассмотрении владельца"
        Requests[] requestsArray = userRequests.toArray(new Requests[0]);

        model.addAttribute("requests", requestsArray);
        return "owner";
    }

    @GetMapping("/owner/confirm/{id}")
    public String owner_confirm(@PathVariable(value = "id") Integer id) {
        Requests requests = requestsRepo.findById(id).orElseThrow();
        requests.setStateId(5); // устан. статус "выполнена"
        requestsRepo.save(requests);
        return "redirect:/owner";
    }
    @GetMapping("/owner/dismiss/{id}")
    public String owner_dismiss(@PathVariable(value = "id") Integer id) {
        Requests requests = requestsRepo.findById(id).orElseThrow();
        requests.setStateId(3); // устан. статус "отклонена"
        requestsRepo.save(requests);
        return "redirect:/owner";
    }
}
