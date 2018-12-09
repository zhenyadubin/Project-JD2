package com.dubin.football.database.dao;

import com.dubin.football.database.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerDao extends CrudRepository<Player, Integer>, BasePlayerDao {

    List<Player> findAll();

    List<Player> findAllByFootballClubId(Integer footballClubId);
}
