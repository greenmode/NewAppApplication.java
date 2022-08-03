package com.example.newapp.controllers;

import com.example.newapp.models.Accesses;
import com.example.newapp.models.Requests;
import com.example.newapp.models.RoleSet;
import com.example.newapp.models.Services;
import com.example.newapp.repo.AccessRepo;
import com.example.newapp.repo.RequestsRepo;
import com.example.newapp.repo.RoleSetRepo;
import com.example.newapp.repo.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ServicesRepo servicesRepo;
    @Autowired
    private RequestsRepo requestsRepo;
    @Autowired
    private AccessRepo accessRepo;
    @Autowired
    private RoleSetRepo roleSetRepo;

    @GetMapping("/user")
    public String user(@CookieValue(value = "userId") Cookie cookie, Model model) {
        Integer userId = Integer.valueOf(cookie.getValue());
        //System.out.println(userId);

        Iterable<Services> allservices = servicesRepo.findAll();
        Iterable<RoleSet> userroles = roleSetRepo.findAllByUserId(userId);
        List<Requests> userRequests = requestsRepo.findAllByUserId(userId); //change!
        Requests[] requestsArray = userRequests.toArray(new Requests[0]);

        model.addAttribute("allservices", allservices);
        model.addAttribute("allroles", userroles);
        model.addAttribute("requests", requestsArray);
        return "user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id,
                       @CookieValue(value = "userId") Cookie cookie,
                       Model model) {
        Integer userId = Integer.valueOf(cookie.getValue());
        if(!requestsRepo.existsById(id)) {
            model.addAttribute("notExist", true);
            return "edit";
        }

        Iterable<Services> allservices = servicesRepo.findAll();
        Iterable<RoleSet> userroles = roleSetRepo.findAllByUserId(userId);
        Requests request = requestsRepo.findByReqId(id);

        model.addAttribute("allservices", allservices);
        model.addAttribute("allroles", userroles);
        model.addAttribute("request", request);
        model.addAttribute("currentUserId", userId);
        return "edit";
    }

    @PostMapping("/add_request")
    public String add_request(@RequestParam Integer serviceId,
                              @RequestParam Integer roleId,
                              @RequestParam String requestComment,
                              @CookieValue(value = "userId") Cookie cookieUserId,
                              @CookieValue(value = "empId") Cookie cookieEmployeeId,
                              Model model) {
        Integer userId = Integer.valueOf(cookieUserId.getValue());
        Integer employeeId = Integer.valueOf(cookieEmployeeId.getValue());
        Accesses isAccess = accessRepo.findByRoleIdAndServiceId(roleId, serviceId);
        if(isAccess == null) {
            model.addAttribute("noAccess", "toService");
            return user(cookieUserId, model);
        }

        Integer stateId = 2;    // при добавлении запроса устан. состояние "на рассмот. владельца сервиса"
        Requests requests = new Requests(employeeId, userId, serviceId, roleId, stateId, requestComment);
        requestsRepo.save(requests);
        return "redirect:/user";
    }

    @PostMapping("/edit/{id}")
    public String update_request(@PathVariable(value = "id") Integer id,
                                 @RequestParam Integer serviceId,
                                 @RequestParam Integer roleId,
                                 @RequestParam String requestComment,
                                 @CookieValue(value = "userId") Cookie cookieUserId,
                                 Model model) {
        Accesses isAccess = accessRepo.findByRoleIdAndServiceId(roleId, serviceId);
        if(isAccess == null) {
            model.addAttribute("noAccess", "toService");
            return edit(id, cookieUserId, model);
        }
        Requests requests = requestsRepo.findByReqId(id);
        requests.setServiceId(serviceId);
        requests.setRoleId(roleId);
        requests.setComent(requestComment);
        requestsRepo.save(requests);
        return "redirect:/user";
    }

    @GetMapping("/remove/{id}")
    public String remove_request(@PathVariable(value = "id") Integer id) {
        Requests requests = requestsRepo.findById(id).orElseThrow();
        requestsRepo.delete(requests);
        return "redirect:/user";
    }
}
