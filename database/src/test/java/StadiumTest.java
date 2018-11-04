import lombok.Cleanup;
import model.City;
import model.Stadium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class StadiumTest {


    @Test
    public void checkSaveStadiums() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            City city;
            city = session.find(City.class, 2);
            Stadium stadium = Stadium.builder()
                    .name("WCR")
                    .numberOfSeats(8000)
                    .city(city)
                    .build();
            session.save(stadium);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Stadium stadium = session.find(Stadium.class, 1);
            System.out.println(stadium);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetAll() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        List<Stadium> stadiums;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            stadiums = session
                    .createQuery("select e from Stadium e", Stadium.class).list();
            session.getTransaction().commit();
        }
        System.out.println(stadiums);
    }
}
