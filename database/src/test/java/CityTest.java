import lombok.Cleanup;
import model.City;
import model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CityTest {

    @Test
    public void checkSaveCity() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country;
            country = session.find(Country.class, 2);
            City city = City.builder()
                    .name("М")
                    .country(country)
                    .build();
            session.save(city);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            City city = session.find(City.class, 2);
            System.out.println(city);
            session.getTransaction().commit();
        }
    }
}
