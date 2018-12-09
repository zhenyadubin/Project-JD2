package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dao.PlayerDao;
import com.dubin.football.database.dto.CreatePlayerDto;
import com.dubin.football.database.dto.FilterDto;
import com.dubin.football.database.dto.NewsBasicInfoDto;
import com.dubin.football.database.dto.PlayerBasicInfoDto;
import com.dubin.football.database.dto.PlayerFullInfoDto;
import com.dubin.football.database.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerService {

    private final PlayerDao playerDao;
    private final CountryDao countryDao;
    private final FootballClubDao footballClubDao;

    public List<PlayerBasicInfoDto> findByFilter(FilterDto filterDto) {
        return playerDao.byFilter(filterDto.getFootballClub(), filterDto.getPlayerPosition(),
                filterDto.getDateBefore(), filterDto.getDateAfter(), filterDto.getLimit(),
                filterDto.getOffset()).stream()
                .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }

    public List<PlayerBasicInfoDto> findAll() {
        return playerDao.findAll().stream()
                .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void savePlayer(CreatePlayerDto playerDto) {
        playerDao.save(Player.builder()
                .firstName(playerDto.getFirstName())
                .lastName(playerDto.getLastName())
                .birthDate(playerDto.getBirthDate())
                .country(countryDao.findById(playerDto.getCountryId()).get())
                .footballClub(footballClubDao.findById(playerDto.getClubId()).get())
                .number(playerDto.getNumber())
                .playerPosition(playerDto.getPosition())
                .build());
    }

    public List<PlayerBasicInfoDto> findPlayersByFootballClub(Integer footballClubId) {
        return playerDao.findAllByFootballClubId(footballClubId).stream()
                .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }

    public PlayerFullInfoDto findPlayersFullInfoById(Integer playerId) {
        Player player = playerDao.findById(playerId).get();
        return PlayerFullInfoDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .birthDate(player.getBirthDate().getDayOfMonth() + " "
                        + player.getBirthDate().getMonthValue() + " "
                        + player.getBirthDate().getYear())
                .countryName(player.getCountry().getName())
                .footballClubName(player.getFootballClub().getName())
                .position(player.getPlayerPosition().getDescription())
                .number(player.getNumber())
                .news(player.getNews().stream()
                        .map(it -> new NewsBasicInfoDto(it.getId(),
                                it.getName(),
                                it.getDateTime().getDayOfMonth() + " "
                                        + it.getDateTime().getMonthValue() + " "
                                        + it.getDateTime().getYear() + ", "
                                        + it.getDateTime().getHour() + ":"
                                        + it.getDateTime().getMinute(),
                                it.getAuthor().getName()))
                        .collect(Collectors.toList()))
                .build();
    }
}
