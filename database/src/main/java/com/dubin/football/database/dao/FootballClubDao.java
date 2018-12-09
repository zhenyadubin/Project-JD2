package com.dubin.football.database.dao;

import com.dubin.football.database.model.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballClubDao extends JpaRepository<FootballClub, Integer> {

    List<FootballClub> findAll();

    List<FootballClub> findAllByLeagueId(Integer leagueId);
}
