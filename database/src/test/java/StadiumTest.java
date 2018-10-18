import dao.StadiumDao;
import model.Stadium;
import org.junit.Test;

public class StadiumTest {

    private StadiumDao dao = StadiumDao.getInstance();

    @Test
    public void checkAllStadiums() {
        for (Stadium stadium : dao.getAllStadium()) {
            System.out.println(stadium);
        }
    }
}
