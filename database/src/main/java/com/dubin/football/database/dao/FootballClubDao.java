package com.dubin.football.database.dao;

import com.dubin.football.database.model.FootballClub;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FootballClubDao extends CrudRepository<FootballClub, Integer> {

    List<FootballClub> findAll();
}
