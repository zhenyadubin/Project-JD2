import lombok.Cleanup;
import model.Coach;
import model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDate;

public class CoachTest {

    @Test
    public void checkSaveCoach() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country;
            country = session.find(Country.class, 2);
            Coach coach = Coach.builder()
                    .firstName("Test")
                    .lastName("Test2")
                    .country(country)
                    .birthDate(LocalDate.of(1977, 2, 15))
                    .build();
            session.save(coach);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Coach coach = session.find(Coach.class, 1);
            System.out.println(coach);
            session.getTransaction().commit();
        }
    }
}
