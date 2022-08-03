package com.example.newapp.repo;

import com.example.newapp.models.UserSet;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;

public interface UserSetRepo extends CrudRepository<UserSet, In> {
    Iterable<UserSet> findAllByEmployeeId(Integer empId);
}
