package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CityDao;
import com.dubin.football.database.dao.CoachDao;
import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dao.LeagueDao;
import com.dubin.football.database.dao.NewsDao;
import com.dubin.football.database.dao.PlayerDao;
import com.dubin.football.database.dao.VisitorDao;
import com.dubin.football.database.dto.CityBasicInfoDto;
import com.dubin.football.database.dto.CoachBasicInfoDto;
import com.dubin.football.database.dto.CountryBasicInfoDto;
import com.dubin.football.database.dto.FootballClubBasicInfoDto;
import com.dubin.football.database.dto.LeagueBasicInfoDto;
import com.dubin.football.database.dto.NewsBasicInfoDto;
import com.dubin.football.database.dto.NewsFullInfoDto;
import com.dubin.football.database.dto.PlayerBasicInfoDto;
import com.dubin.football.database.dto.SaveNewsDto;
import com.dubin.football.database.dto.TagsForNews;
import com.dubin.football.database.model.City;
import com.dubin.football.database.model.Coach;
import com.dubin.football.database.model.Country;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.database.model.League;
import com.dubin.football.database.model.News;
import com.dubin.football.database.model.Player;
import com.dubin.football.database.model.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NewsService {

    private final NewsDao newsDao;
    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final LeagueDao leagueDao;
    private final FootballClubDao footballClubDao;
    private final CoachDao coachDao;
    private final PlayerDao playerDao;
    private final VisitorDao visitorDao;

    @Transactional
    public void addTagsToNews(TagsForNews tagsForNews) {
        News news = newsDao.findById(tagsForNews.getNewsId()).get();
        Country country = countryDao.findById(tagsForNews.getCountryId()).orElse(null);
        City city = cityDao.findById(tagsForNews.getCityId()).orElse(null);
        League league = leagueDao.findById(tagsForNews.getLeagueId()).orElse(null);
        FootballClub footballClub = footballClubDao.findById(tagsForNews.getClubId()).orElse(null);
        Coach coach = coachDao.findById(tagsForNews.getCoachId()).orElse(null);
        Player player = playerDao.findById(tagsForNews.getPlayerId()).orElse(null);

        news.getCountries().add(country);
        news.getCities().add(city);
        news.getLeagues().add(league);
        news.getClubs().add(footballClub);
        news.getCoaches().add(coach);
        news.getPlayers().add(player);

        newsDao.saveAndFlush(news);
    }

    public List<NewsBasicInfoDto> findAll() {
        return newsDao.findAll().stream()
                .map(it -> new NewsBasicInfoDto(it.getId(),
                        it.getName(),
                        it.getDateTime().toString(),
                        it.getAuthor().getName()))
                .collect(Collectors.toList());
    }

    public NewsFullInfoDto findNews(Long newsId) {
        News news = newsDao.findById(newsId).get();
        return NewsFullInfoDto.builder()
                .id(news.getId())
                .title(news.getName())
                .text(news.getText())
                .dateAndTime(news.getDateTime().toString())
                .authorName(news.getAuthor().getName())
                .countries(news.getCountries().stream()
                        .map(it -> new CountryBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .cities(news.getCities().stream()
                        .map(it -> new CityBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .leagues(news.getLeagues().stream()
                        .map(it -> new LeagueBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .clubs(news.getClubs().stream()
                        .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                        .collect(Collectors.toList()))
                .coaches(news.getCoaches().stream()
                        .map(it -> new CoachBasicInfoDto(it.getId(), it.getFirstName() + " " + it.getLastName()))
                        .collect(Collectors.toList()))
                .players(news.getPlayers().stream()
                        .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                        .collect(Collectors.toList()))
                .build();
    }

    @Transactional
    public void saveNews(SaveNewsDto saveNewsDto) {
        Visitor author = visitorDao.findByName(saveNewsDto.getAuthorName()).get();
        News news = News.builder()
                .name(saveNewsDto.getTitle())
                .text(saveNewsDto.getText())
                .dateTime(saveNewsDto.getDateTime())
                .author(author)
                .build();
        newsDao.save(news);
    }
}
