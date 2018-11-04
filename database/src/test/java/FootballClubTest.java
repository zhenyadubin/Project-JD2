import lombok.Cleanup;
import model.Coach;
import model.FootballClub;
import model.League;
import model.Stadium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDate;

public class FootballClubTest {

    @Test
    public void checkSaveClub() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            League league = session.find(League.class, 1);
            Stadium stadium = session.find(Stadium.class, 1);
            Coach coach = session.find(Coach.class, 1);
            FootballClub footballClub = FootballClub.builder()
                    .name("Марсель Олимпик")
                    .stadium(stadium)
                    .league(league)
                    .coach(coach)
                    .foundationDate(LocalDate.of(1900, 01, 01))
                    .build();
            session.save(footballClub);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            FootballClub footballClub = session.find(FootballClub.class, 1);
            System.out.println(footballClub);
            session.getTransaction().commit();
        }
    }
}
