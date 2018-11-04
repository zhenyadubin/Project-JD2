import lombok.Cleanup;
import model.Country;
import model.League;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class LeagueTest {

    @Test
    public void checkSaveLeague() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country;
            country = session.find(Country.class, 2);
            League league = League.builder()
                    .name("Лига 1")
                    .country(country)
                    .numberOfClubs(20)
                    .build();
            session.save(league);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            League league = session.find(League.class, 1);
            System.out.println(league);
            session.getTransaction().commit();
        }
    }
}
