package com.dubin.football.service.repository;

import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dto.FootballClubBasicInfoDto;
import com.dubin.football.database.dto.FootballClubFullInfoDto;
import com.dubin.football.database.dto.NewsBasicInfoDto;
import com.dubin.football.database.model.FootballClub;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = "football")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FootballClubService {

    @Autowired
    private final FootballClubDao footballClubDao;

    public List<FootballClubBasicInfoDto> findAll() {
        return footballClubDao.findAll().stream()
                .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    @Cacheable 
    public List<FootballClubBasicInfoDto> findAllByLeague(Integer leagueId) {
        return footballClubDao.findAllByLeagueId(leagueId).stream()
                .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public FootballClub findById(Integer clubId) {
        return footballClubDao.findById(clubId).get();
    }

    public FootballClubFullInfoDto findFullInfoById(Integer clubId) {
        FootballClub footballClub = footballClubDao.findById(clubId).get();
        return FootballClubFullInfoDto.builder()
                .name(footballClub.getName())
                .stadiumName(footballClub.getStadium().getName())
                .cityName(footballClub.getStadium().getCity().getName())
                .foundationDate(String.valueOf(footballClub.getFoundationDate().getYear()))
                .leagueName(footballClub.getLeague().getName())
                .coachName(footballClub.getCoach().getFirstName() + " " + footballClub.getCoach().getLastName())
                .coachId(footballClub.getCoach().getId())
                .news(footballClub.getNews().stream()
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
