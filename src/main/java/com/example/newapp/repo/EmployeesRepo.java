package com.example.newapp.repo;

import com.example.newapp.models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepo extends CrudRepository<Employees, Integer> {

}
