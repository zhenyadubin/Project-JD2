package com.dubin.football.dao;

import com.dubin.football.configuration.TestConfig;
import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dao.NewsDao;
import com.dubin.football.database.dao.VisitorDao;
import com.dubin.football.database.model.Country;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.database.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@Commit
public class NewsTest {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private FootballClubDao footballClubDao;

    @Autowired
    private CountryDao countryDao;

    @Test
    public void checkAddTags() {
//        Visitor visitor = visitorDao.findById(2L).get();

        Country country = countryDao.findById(1).get();
        FootballClub footballClub = footballClubDao.findById(3).get();
        News news = newsDao.findById(1L).get();
        System.out.println(news + "  " + news.getClubs());
        news.getClubs().add(footballClub);
        news.getCountries().add(country);
        System.out.println(news + "  " + news.getClubs());
        newsDao.saveAndFlush(news);
        System.out.println();
    }

    @Test
    public void checkGetClubByLeague() {
        System.out.println(footballClubDao.findAllByLeagueId(1));
    }
}
