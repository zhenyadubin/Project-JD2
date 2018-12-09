package com.dubin.football.service.repository;

import com.dubin.football.database.dao.LeagueDao;
import com.dubin.football.database.dto.LeagueBasicInfoDto;
import com.dubin.football.database.dto.LeagueFullInfoDto;
import com.dubin.football.database.dto.NewsBasicInfoDto;
import com.dubin.football.database.model.League;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LeagueService {

    private final LeagueDao leagueDao;

    public List<LeagueBasicInfoDto> findAll() {
        return leagueDao.findAll().stream()
                .map(it -> new LeagueBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public LeagueFullInfoDto findById(Integer id) {
        League league = leagueDao.findById(id).get();
        return LeagueFullInfoDto.builder()
                .name(league.getName())
                .numberOfClubs(league.getNumberOfClubs())
                .country(league.getCountry().getName())
                .news(league.getNews().stream()
                        .map(it -> new NewsBasicInfoDto(it.getId(),
                                it.getName(),
                                " " + it.getDateTime().getDayOfMonth() + " "
                                        + it.getDateTime().getMonthValue() + " "
                                        + it.getDateTime().getYear() + ", "
                                        + it.getDateTime().getHour() + ":"
                                        + it.getDateTime().getMinute(),
                                it.getAuthor().getName()))
                        .collect(Collectors.toList()))
                .build();
    }
}
