package dao;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import model.Stadium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumDao {

    private static final StadiumDao INSTANCE = new StadiumDao();

    public List<Stadium> getAll() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        List<Stadium> stadiums;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            stadiums = session
                    .createQuery("select e from Stadium e", Stadium.class).list();
            session.getTransaction().commit();
        }
        return stadiums;
    }

    public static StadiumDao getInstance() {
        return INSTANCE;
    }
}
