package dao;

import model.Coach;

public class CoachDaoImpl extends BaseDaoImpl<Integer, Coach> implements CoachDao {

    private static final CoachDaoImpl INSTANCE = new CoachDaoImpl();

    public static CoachDaoImpl getInstance() {
        return INSTANCE;
    }

    public CoachDaoImpl() {
        super(Coach.class);
    }
}
