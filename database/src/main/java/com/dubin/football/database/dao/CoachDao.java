package com.dubin.football.database.dao;

import com.dubin.football.database.model.Coach;
import org.springframework.data.repository.CrudRepository;

public interface CoachDao extends CrudRepository<Coach, Integer> {
}
