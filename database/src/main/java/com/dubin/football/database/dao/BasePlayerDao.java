package com.dubin.football.database.dao;

import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.database.model.Player;

import java.time.LocalDate;
import java.util.List;

public interface BasePlayerDao {

    List<Player> findByFilter(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter
            , Long limit, Long offset);

    List<Player> byFilter(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter
            , Long limit, Long offset);
}
