package com.dubin.football.dao;

import com.dubin.football.configuration.TestConfig;
import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class CountryTest {

    @Autowired
    private CountryDao countryDao;

    @Test
    public void checkSave() {
        Country country = countryDao.save(Country.builder().name("Belarus").build());
        assertNotNull(country);
    }

    @Test
    public void checkGetById() {
        Country country = countryDao.save(Country.builder().name("Belarus").build());
        assertNotNull(country);
        Country saveCountry = countryDao.findById(1).get();
        assertNotNull(saveCountry);
    }

    @Test
    public void checkGetAll() {
        countryDao.save(Country.builder().name("Belarus").build());
        countryDao.save(Country.builder().name("France").build());
        List<Country> countries = countryDao.findAll();
        assertThat(countries, hasSize(2));
    }

    @Test
    public void checkDelete() {
        Country country = countryDao.save(Country.builder().name("Belarus").build());
        countryDao.save(Country.builder().name("France").build());
        assertNotNull(country);
        countryDao.delete(country);
        List<Country> countries = countryDao.findAll();
        assertThat(countries, hasSize(1));
    }
}
