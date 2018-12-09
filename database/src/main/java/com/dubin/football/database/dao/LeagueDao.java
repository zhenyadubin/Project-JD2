package com.dubin.football.database.dao;

import com.dubin.football.database.model.League;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueDao extends CrudRepository<League, Integer> {

    List<League> findAll();
}
