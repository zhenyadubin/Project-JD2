import dao.CountryDaoImpl;
import model.Country;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CountryDaoTest {

    @Test
    public void checkSave() {
        Country country = Country.builder()
                .name("Belarus")
                .build();
        Serializable id = CountryDaoImpl.getInstance().save(country);
        assertNotNull(id);
        CountryDaoImpl.getInstance().delete(country);
    }

    @Test
    public void checkGetById() {
        Country country = Country.builder()
                .name("Belarus")
                .build();
        Serializable savedId = CountryDaoImpl.getInstance().save(country);
        assertNotNull(savedId);
        Country saveCountry = CountryDaoImpl.getInstance().find((Integer) savedId);
        assertNotNull(saveCountry);
        CountryDaoImpl.getInstance().delete(country);
    }

    @Test
    public void checkGetAll() {
        Country firstCountry = Country.builder()
                .name("Belarus")
                .build();
        Serializable savedId = CountryDaoImpl.getInstance().save(firstCountry);
        assertNotNull(savedId);
        Country secondCountry = Country.builder()
                .name("France")
                .build();
        Serializable savedId2 = CountryDaoImpl.getInstance().save(secondCountry);
        assertNotNull(savedId2);
        List<Country> countries = CountryDaoImpl.getInstance().findAll();
        assertNotNull(countries);
        CountryDaoImpl.getInstance().delete(firstCountry);
        CountryDaoImpl.getInstance().delete(secondCountry);
    }

    @Test
    public void checkDelete() {
        Country country = Country.builder()
                .name("Belarus")
                .build();
        Serializable savedId = CountryDaoImpl.getInstance().save(country);
        assertNotNull(savedId);
        CountryDaoImpl.getInstance().delete(country);
        Country deletedCountry = CountryDaoImpl.getInstance().find((Integer) savedId);
        assertNull(deletedCountry);
    }

    @Test
    public void checkUpdate() {
        Country country = Country.builder()
                .name("Belarus")
                .build();
        Serializable savedId = CountryDaoImpl.getInstance().save(country);
        assertNotNull(savedId);
        country.setName("Belorussian");
        CountryDaoImpl.getInstance().update(country);
        Country countryTest = CountryDaoImpl.getInstance().find((Integer) savedId);
        assertEquals(country, countryTest);
        CountryDaoImpl.getInstance().delete(country);
    }
}


