package dao;

import model.FootballClub;

public class FootballClubDaoImpl extends BaseDaoImpl<Integer, FootballClub> implements FootballClubDao {

    private static final FootballClubDaoImpl INSTANCE = new FootballClubDaoImpl();

    public static FootballClubDaoImpl getInstance() {
        return INSTANCE;
    }

    public FootballClubDaoImpl() {
        super(FootballClub.class);
    }
}
