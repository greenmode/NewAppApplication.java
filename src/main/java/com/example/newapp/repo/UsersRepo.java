package com.example.newapp.repo;

import com.example.newapp.models.Roles;
import com.example.newapp.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<Users, Integer> {

}
