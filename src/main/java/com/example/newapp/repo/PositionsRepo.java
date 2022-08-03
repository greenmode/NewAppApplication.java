package com.example.newapp.repo;

import com.example.newapp.models.Positions;
import org.springframework.data.repository.CrudRepository;

public interface PositionsRepo extends CrudRepository<Positions, Integer> {

}
