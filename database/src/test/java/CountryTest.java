import lombok.Cleanup;
import model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CountryTest {

    @Test
    public void checkCountrySave() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Country country = Country.builder()
                    .name("Ф")
                    .build();

            session.save(country);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Country country;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            country = session.find(Country.class, 2);
            System.out.println(country);
            session.getTransaction().commit();
        }
    }
}
