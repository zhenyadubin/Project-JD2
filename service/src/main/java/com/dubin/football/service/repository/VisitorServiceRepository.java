package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CityDao;
import com.dubin.football.database.dao.CoachDao;
import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dao.LeagueDao;
import com.dubin.football.database.dao.PlayerDao;
import com.dubin.football.database.dao.VisitorDao;
import com.dubin.football.database.dto.AddCityTagDto;
import com.dubin.football.database.dto.AddCoachTagDto;
import com.dubin.football.database.dto.AddCountryTagDto;
import com.dubin.football.database.dto.AddFootballClubTagDto;
import com.dubin.football.database.dto.AddLeagueTagDto;
import com.dubin.football.database.dto.AddPlayerTagDto;
import com.dubin.football.database.dto.CityBasicInfoDto;
import com.dubin.football.database.dto.CoachBasicInfoDto;
import com.dubin.football.database.dto.CountryBasicInfoDto;
import com.dubin.football.database.dto.FootballClubBasicInfoDto;
import com.dubin.football.database.dto.LeagueBasicInfoDto;
import com.dubin.football.database.dto.PlayerBasicInfoDto;
import com.dubin.football.database.dto.VisitorFullInfoDto;
import com.dubin.football.database.dto.VisitorSaveDto;
import com.dubin.football.database.enams.Role;
import com.dubin.football.database.model.City;
import com.dubin.football.database.model.Coach;
import com.dubin.football.database.model.Country;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.database.model.League;
import com.dubin.football.database.model.Player;
import com.dubin.football.database.model.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VisitorServiceRepository {

    private final VisitorDao visitorDao;
    private final PasswordEncoder passwordEncoder;
    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final LeagueDao leagueDao;
    private final FootballClubDao footballClubDao;
    private final CoachDao coachDao;
    private final PlayerDao playerDao;

    public void saveVisitor(VisitorSaveDto visitorSaveDto) {
        visitorDao.save(Visitor.builder()
                .eMail(visitorSaveDto.getEmail())
                .name(visitorSaveDto.getName())
                .password(passwordEncoder.encode(visitorSaveDto.getPassword()))
                .role(Role.VISITOR)
                .build());
    }

    public VisitorFullInfoDto getVisitorFullInfo(String visitorName) {
        Visitor visitor = visitorDao.findByName(visitorName).get();
        return VisitorFullInfoDto.builder()
                .id(visitor.getId())
                .name(visitor.getName())
                .email(visitor.getEMail())
                .role(visitor.getRole())
                .countries(visitor.getCountries().stream()
                        .map(it -> new CountryBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .cities(visitor.getCities().stream()
                        .map(it -> new CityBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .leagues(visitor.getLeagues().stream()
                        .map(it -> new LeagueBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .clubs(visitor.getClubs().stream()
                        .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .coaches(visitor.getCoaches().stream()
                        .map(it -> new CoachBasicInfoDto(it.getId(), it.getFirstName() + " " + it.getLastName()))
                        .collect(Collectors.toList()))
                .players(visitor.getPlayers().stream()
                        .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                        .collect(Collectors.toList()))
                .build();
    }

    @Transactional
    public void addCountryTag(AddCountryTagDto countryTag) {
        Visitor visitor = visitorDao.findByName(countryTag.getVisitorName()).get();
        Country country = countryDao.findById(countryTag.getCountryId()).orElse(null);
        visitor.getCountries().add(country);
        visitorDao.saveAndFlush(visitor);
    }

    @Transactional
    public void addCityTag(AddCityTagDto cityTagDto) {
        Visitor visitor = visitorDao.findByName(cityTagDto.getVisitorName()).get();
        City city = cityDao.findById(cityTagDto.getCityId()).orElse(null);
        visitor.getCities().add(city);
        visitorDao.saveAndFlush(visitor);
    }

    @Transactional
    public void addLeagueTag(AddLeagueTagDto leagueTagDto) {
        Visitor visitor = visitorDao.findByName(leagueTagDto.getVisitorName()).get();
        League league = leagueDao.findById(leagueTagDto.getLeagueId()).orElse(null);
        visitor.getLeagues().add(league);
        visitorDao.saveAndFlush(visitor);
    }

    @Transactional
    public void addClubTag(AddFootballClubTagDto footballClubTagDto) {
        Visitor visitor = visitorDao.findByName(footballClubTagDto.getVisitorName()).get();
        FootballClub footballClub = footballClubDao.findById(footballClubTagDto.getFootballClubId()).orElse(null);
        visitor.getClubs().add(footballClub);
        visitorDao.saveAndFlush(visitor);
    }

    @Transactional
    public void addCoachTag(AddCoachTagDto coachTagDto) {
        Visitor visitor = visitorDao.findByName(coachTagDto.getVisitorName()).get();
        Coach coach = coachDao.findById(coachTagDto.getCoachId()).orElse(null);
        visitor.getCoaches().add(coach);
        visitorDao.saveAndFlush(visitor);
    }

    @Transactional
    public void addPlayerTag(AddPlayerTagDto playerTagDto) {
        Visitor visitor = visitorDao.findByName(playerTagDto.getVisitorName()).get();
        Player player = playerDao.findById(playerTagDto.getPlayerId()).orElse(null);
        visitor.getPlayers().add(player);
        visitorDao.saveAndFlush(visitor);
    }
}