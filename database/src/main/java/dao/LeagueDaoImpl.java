package dao;

import model.League;

public class LeagueDaoImpl extends BaseDaoImpl<Integer, League> implements LeagueDao {

    private static final LeagueDaoImpl INSTANCE = new LeagueDaoImpl();

    public static LeagueDaoImpl getInstance() {
        return INSTANCE;
    }

    public LeagueDaoImpl() {
        super(League.class);
    }
}
