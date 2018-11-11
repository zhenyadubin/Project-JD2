package dao;

import connection.ConnectionManager;
import lombok.Cleanup;
import model.City;
import model.Coach;
import model.Country;
import model.FootballClub;
import model.League;
import model.News;
import model.Player;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDaoImpl<Long, News> implements NewsDao {

    private static final NewsDaoImpl INSTANCE = new NewsDaoImpl();

    @Override
    public void addTags(News news, Country country, City city, Coach coach, Player player, FootballClub club, League league) {
        @Cleanup Session session = ConnectionManager.getSession();
        session.beginTransaction();
        List<Country> countries = new ArrayList<>();
        countries.add(country);
        news.setCountries(countries);

        List<City> cities = new ArrayList<>();
        cities.add(city);
        news.setCities(cities);

        List<Coach> coaches = new ArrayList<>();
        coaches.add(coach);
        news.setCoaches(coaches);

        List<League> leagues = new ArrayList<>();
        leagues.add(league);
        news.setLeagues(leagues);

        List<Player> players = new ArrayList<>();
        players.add(player);
        news.setPlayers(players);

        List<FootballClub> clubs = new ArrayList<>();
        clubs.add(club);
        news.setClubs(clubs);

        session.update(news);
        session.getTransaction().commit();
    }

    @Override
    public News getNewsWithTags(Long id) {
        Session session = ConnectionManager.getSession();
        session.beginTransaction();
        News news = session.find(News.class, id);
        session.getTransaction().commit();
        return news;
    }

    public static NewsDaoImpl getInstance() {
        return INSTANCE;
    }

    public NewsDaoImpl() {
        super(News.class);
    }
}
