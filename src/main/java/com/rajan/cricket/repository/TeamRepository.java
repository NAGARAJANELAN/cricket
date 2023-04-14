package com.rajan.cricket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rajan.cricket.model.Team;

@Component
public interface TeamRepository extends CrudRepository<Team,String>{
    
    Team findByName(String Name);
}
