package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.PlayerBasicInfoDto;
import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.database.model.FootballClub;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.PlayerService;
import com.dubin.football.service.util.LocalDateFormatter;
import com.dubin.football.web.util.ApplicationContextHolder;
import com.dubin.football.web.util.JspPathUtil;

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

    private PlayerService playerService = ApplicationContextHolder.getContext()
            .getBean("playerService", PlayerService.class);
    private FootballClubService footballClubService = ApplicationContextHolder.getContext()
            .getBean("footballClubService", FootballClubService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clubs", footballClubService.findAll());
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
            club = footballClubService.findById(Integer.valueOf(req.getParameter("club")));
        }
        req.getSession().setAttribute("club", club);
        if (req.getParameter("position") != null) {
            position = PlayerPosition.valueOf(req.getParameter("position"));
        }
        req.getSession().setAttribute("position", position);
        if (req.getParameter("dateBefore") != null) {
            dateBefore = LocalDateFormatter.format(req.getParameter("dateBefore"));
        }
        req.getSession().setAttribute("dateBefore", dateBefore);
        if (req.getParameter("dateAfter") != null) {
            dateAfter = LocalDateFormatter.format(req.getParameter("dateAfter"));
        }
        req.getSession().setAttribute("dateAfter", dateAfter);
        Long limit = Long.valueOf(req.getParameter("limit"));
        req.getSession().setAttribute("limit", limit);
        Long offset = 0L;
        req.getSession().setAttribute("offset", offset);
        List<PlayerBasicInfoDto> players = playerService
                .findByFilter(club, position, dateBefore, dateAfter, limit, offset);
        req.setAttribute("findPlayers", players);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("players"))
                .forward(req, resp);
    }
}
