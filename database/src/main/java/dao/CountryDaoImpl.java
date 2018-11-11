package dao;

import model.Country;

public class CountryDaoImpl extends BaseDaoImpl<Integer, Country> implements CountryDao {

    private static final CountryDaoImpl INSTANCE = new CountryDaoImpl();

    public static CountryDaoImpl getInstance() {
        return INSTANCE;
    }

    public CountryDaoImpl() {
        super(Country.class);
    }
}
