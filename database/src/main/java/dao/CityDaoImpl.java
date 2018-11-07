package dao;

import model.City;

public class CityDaoImpl extends BaseDaoImpl<Integer, City> implements CityDao {

    private static final CityDaoImpl INSTANCE = new CityDaoImpl();

    public static CityDaoImpl getInstance() {
        return INSTANCE;
    }

    public CityDaoImpl() {
        super(City.class);
    }

}
