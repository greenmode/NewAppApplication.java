package com.example.newapp.repo;

import com.example.newapp.models.RoleSet;
import org.springframework.data.repository.CrudRepository;

public interface RoleSetRepo extends CrudRepository<RoleSet, Integer> {
    Iterable<RoleSet> findAllByUserId(Integer userId);
}
