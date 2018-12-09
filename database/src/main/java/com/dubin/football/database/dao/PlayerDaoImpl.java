package com.dubin.football.database.dao;

import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.database.model.Player;
import com.dubin.football.database.model.QPlayer;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PlayerDaoImpl implements BasePlayerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Player> findByFilter(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter
            , Long limit, Long offset) {
        List<Player> players;
        if (position != null & club != null & dateBefore != null & dateAfter != null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.playerPosition.eq(position))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club != null & position != null & dateBefore == null & dateAfter == null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.playerPosition.eq(position))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club != null & position == null & dateBefore != null & dateAfter != null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club == null & position != null & dateBefore != null & dateAfter != null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.playerPosition.eq(position))
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club != null & position == null & dateBefore == null & dateAfter == null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.footballClub.eq(club))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club == null & position == null & dateBefore != null & dateAfter != null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.birthDate.between(dateBefore, dateAfter))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else if (club == null & position != null & dateBefore == null & dateAfter == null) {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .where(QPlayer.player.playerPosition.eq(position))
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        } else {
            players = new JPAQuery<Player>(entityManager)
                    .select(QPlayer.player)
                    .from(QPlayer.player)
                    .orderBy(QPlayer.player.birthDate.asc())
                    .limit(limit)
                    .offset(offset)
                    .fetch();
        }
        return players;
    }

    public List<Player> byFilter(FootballClub club, PlayerPosition position, LocalDate dateBefore, LocalDate dateAfter
            , Long limit, Long offset) {
        List<Player> players;
        players = new JPAQuery<Player>(entityManager)
                .select(QPlayer.player)
                .from(QPlayer.player)
                .where(QPlayer.player.footballClub.isNull().or(QPlayer.player.footballClub.eq(club)))
                .where(QPlayer.player.playerPosition.isNull().or(QPlayer.player.playerPosition.eq(position)))
                .where(QPlayer.player.birthDate.isNull().or(QPlayer.player.birthDate.between(dateBefore, dateAfter)))
                .orderBy(QPlayer.player.birthDate.asc())
                .limit(limit)
                .offset(offset)
                .fetch();
        return players;
    }
}


