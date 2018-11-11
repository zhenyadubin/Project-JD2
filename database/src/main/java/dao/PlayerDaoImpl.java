package dao;

import com.querydsl.jpa.impl.JPAQuery;
import connection.ConnectionManager;
import enams.PlayerPosition;
import model.FootballClub;
import model.Player;
import model.QPlayer;

import java.time.LocalDate;
import java.util.List;

public class PlayerDaoImpl extends BaseDaoImpl<Integer, Player> implements PlayerDao {

    private static final PlayerDaoImpl INSTANCE = new PlayerDaoImpl();

    @Override
    public List<Player> findBy(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter) {
        List<Player> players;
        if (position != null & club != null & dateBefore != null & dateAfter != null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.playerPosition.eq(position))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club != null & position != null & dateBefore == null & dateAfter == null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.playerPosition.eq(position))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club != null & position == null & dateBefore != null & dateAfter != null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club == null & position != null & dateBefore != null & dateAfter != null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.playerPosition.eq(position))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club != null & position == null & dateBefore == null & dateAfter == null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club == null & position == null & dateBefore != null & dateAfter != null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else if (club == null & position != null & dateBefore == null & dateAfter == null) {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.playerPosition.eq(position))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        } else {
            players = new  JPAQuery<Player>(ConnectionManager.getSession())
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .orderBy(QPlayer.player.birthDate.asc())
                    .fetch();
        }
        return players;
    }

    public static PlayerDaoImpl getInstance() {
        return INSTANCE;
    }

    public PlayerDaoImpl() {
        super(Player.class);
    }
}
