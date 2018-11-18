package com.dubin.football.database.dao;

import com.dubin.football.database.model.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueDao extends CrudRepository<League, Integer> {
}
