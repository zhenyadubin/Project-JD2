import lombok.Cleanup;
import model.News;
import model.Visitor;
import model.VisitorComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDateTime;

public class VisitorCommentTest {

    @Test
    public void checkSaveComment() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Visitor visitor = session.find(Visitor.class, 1L);
            News news = session.find(News.class, 1L);
            VisitorComment comment = VisitorComment.builder()
                    .visitor(visitor)
                    .news(news)
                    .text("Test")
                    .dateTime(LocalDateTime.now())
                    .build();
            session.save(comment);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkGetById() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            VisitorComment comment = session.find(VisitorComment.class, 1L);
            System.out.println(comment);
            session.getTransaction().commit();
        }
    }
}
