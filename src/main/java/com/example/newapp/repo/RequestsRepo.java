package com.example.newapp.repo;

import com.example.newapp.models.Requests;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestsRepo extends CrudRepository<Requests, Integer> {
    List<Requests> findAllByUserId(Integer userId);
    Requests findByReqId(Integer reqId);
    List<Requests> findAllByStateId(Integer stateId);
}
