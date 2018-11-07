package dao;

import model.City;
import model.Coach;
import model.Country;
import model.FootballClub;
import model.League;
import model.News;
import model.Player;

public interface NewsDao extends BaseDao<Long, News> {

    void addTags(News news, Country country, City city, Coach coach, Player player, FootballClub club, League league);

    News getNewsWithTags(Long id);


}
