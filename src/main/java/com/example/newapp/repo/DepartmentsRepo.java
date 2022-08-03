package com.example.newapp.repo;

import com.example.newapp.models.Departments;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepo extends CrudRepository<Departments, Integer> {

}
