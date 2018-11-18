package com.dubin.football.database.dao;

import com.dubin.football.database.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDao extends CrudRepository<Player, Integer>, BasePlayerDao {
}
