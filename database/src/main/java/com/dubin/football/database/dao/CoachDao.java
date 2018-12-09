package com.dubin.football.database.dao;

import com.dubin.football.database.model.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoachDao extends CrudRepository<Coach, Integer> {

    List<Coach> findAll();
}
