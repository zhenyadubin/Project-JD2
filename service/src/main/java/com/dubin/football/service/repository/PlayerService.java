package com.dubin.football.service.repository;

import com.dubin.football.database.dao.PlayerDao;
import com.dubin.football.database.dto.PlayerBasicInfoDto;
import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.database.model.FootballClub;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerService {

    @Autowired
    private final PlayerDao playerDao;

    public List<PlayerBasicInfoDto> findByFilter(FootballClub club, PlayerPosition position
            , LocalDate dateBefore, LocalDate dateAfter, Long limit, Long offset) {
        return playerDao.findByFilter(club, position, dateBefore, dateAfter, limit, offset).stream()
                .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }
}
