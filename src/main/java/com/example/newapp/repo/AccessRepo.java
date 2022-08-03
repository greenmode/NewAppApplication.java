package com.example.newapp.repo;

import com.example.newapp.models.Accesses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccessRepo extends CrudRepository<Accesses, Integer> {
    Accesses findByRoleIdAndServiceId(Integer roleId, Integer serviceId);
}
