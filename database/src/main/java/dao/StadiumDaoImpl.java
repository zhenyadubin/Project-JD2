package dao;

import model.Stadium;

public class StadiumDaoImpl extends BaseDaoImpl<Integer, Stadium> implements StadiumDao {

    private static final StadiumDaoImpl INSTANCE = new StadiumDaoImpl();

    public static StadiumDaoImpl getInstance() {
        return INSTANCE;
    }

    public StadiumDaoImpl() {
        super(Stadium.class);
    }
}
