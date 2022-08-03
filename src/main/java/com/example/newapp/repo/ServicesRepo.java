package com.example.newapp.repo;

import com.example.newapp.models.Services;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ServicesRepo extends CrudRepository<Services, Integer> {
    Services findByServiceId(Integer serviceId);
}
