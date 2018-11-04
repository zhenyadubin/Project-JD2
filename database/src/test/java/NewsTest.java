import lombok.Cleanup;
import model.News;
import model.Visitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDateTime;

public class NewsTest {

    @Test
    public void checkSaveVisitor() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Visitor author = session.find(Visitor.class, 1L);
            News news = News.builder()
                    .name("Test")
                    .text("Test")
                    .author(author)
                    .dateTime(LocalDateTime.now())
                    .build();
            session.save(news);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            News news = session.find(News.class, 1L);
            System.out.println(news);
            session.getTransaction().commit();
        }
    }
}
