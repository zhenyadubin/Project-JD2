package servlet;

import dto.PlayerBasicInfoDto;
import enams.PlayerPosition;
import model.FootballClub;
import service.FootballClubService;
import service.PlayerService;
import util.JspPathUtil;
import util.LocalDateFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/find-players")
public class FindPlayersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clubs", FootballClubService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("find-players"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FootballClub club = null;
        PlayerPosition position = null;
        LocalDate dateBefore = null;
        LocalDate dateAfter = null;

        if (!req.getParameter("club").equals("")) {
            club = FootballClubService.getInstance().findById(Integer.valueOf(req.getParameter("club")));
        }
        if (req.getParameter("position") != null) {
            position = PlayerPosition.valueOf(req.getParameter("position"));
        }
        if (req.getParameter("dateBefore") != null) {
            dateBefore = LocalDateFormatter.format(req.getParameter("dateBefore"));
        }
        if (req.getParameter("dateAfter") != null) {
            dateAfter = LocalDateFormatter.format(req.getParameter("dateAfter"));
        }
        List<PlayerBasicInfoDto> players = PlayerService.getInstance()
                .findByFilter(club, position, dateBefore, dateAfter);
        req.setAttribute("findPlayers", players);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("players"))
                .forward(req, resp);
    }
}
