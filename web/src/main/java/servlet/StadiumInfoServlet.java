package servlet;

import dto.StadiumFullInfoDto;
import service.StadiumService;
import util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stadium")
public class StadiumInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stadiumId = req.getParameter("id");
        StadiumFullInfoDto stadium = StadiumService.getInstance().getById(Integer.valueOf(stadiumId));
        req.setAttribute("stadium", stadium);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("stadium"))
                .forward(req, resp);
    }
}
