import enams.Role;
import lombok.Cleanup;
import model.Visitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class VisitorTest {

    @Test
    public void checkSaveVisitor() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Visitor visitor = Visitor.builder()
                    .name("Test")
                    .eMail("Test@test")
                    .password("12345")
                    .role(Role.VISITOR)
                    .build();
            session.save(visitor);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Visitor visitor = session.find(Visitor.class, 1L);
            System.out.println(visitor);
            session.getTransaction().commit();
        }
    }
}
