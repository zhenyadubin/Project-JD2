package dao;

import enams.PlayerPosition;
import model.FootballClub;
import model.Player;

import java.time.LocalDate;
import java.util.List;

public interface PlayerDao extends BaseDao<Integer, Player> {

    List<Player> findBy(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter);
}
