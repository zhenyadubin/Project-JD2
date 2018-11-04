import enams.PlayerPosition;
import lombok.Cleanup;
import model.Country;
import model.FootballClub;
import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDate;

public class PlayerTest {

    @Test
    public void checkSaveClub() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = session.find(Country.class, 1);
            FootballClub footballClub = session.find(FootballClub.class, 1);
            Player player = Player.builder()
                    .firstName("Test")
                    .lastName("Test2")
                    .birthDate(LocalDate.of(1990, 2, 9))
                    .country(country)
                    .footballClub(footballClub)
                    .number(1)
                    .playerPosition(PlayerPosition.GOALKEEPER)
                    .build();
            session.save(player);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Player player = session.find(Player.class, 1);
            System.out.println(player);
            session.getTransaction().commit();
        }
    }
}
