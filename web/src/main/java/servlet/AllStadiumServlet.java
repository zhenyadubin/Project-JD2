package servlet;

import dto.StadiumBasicInfoDto;
import service.StadiumService;
import util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stadiums")
public class AllStadiumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StadiumBasicInfoDto> stadiums = StadiumService.getInstance().getAll();
        req.setAttribute("stadiums", stadiums);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("stadiums"))
                .forward(req, resp);
    }
}
