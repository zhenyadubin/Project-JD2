//package com.dubin.football.web.servlet;
//
//import com.dubin.football.database.dto.PlayerBasicInfoDto;
//import com.dubin.football.database.enams.PlayerPosition;
//import com.dubin.football.database.model.FootballClub;
//import com.dubin.football.service.repository.PlayerService;
//import com.dubin.football.web.util.ApplicationContextHolder;
//import com.dubin.football.web.util.JspPathUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//
//@WebServlet("/players")
//public class PlayersServlet extends HttpServlet {
//
//    private PlayerService playerService = ApplicationContextHolder.getContext().getBean("playerService", PlayerService.class);
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        FootballClub club = ((FootballClub) (req.getSession().getAttribute("club")));
//        PlayerPosition position = ((PlayerPosition) (req.getSession().getAttribute("position")));
//        LocalDate dateBefore = ((LocalDate) (req.getSession().getAttribute("dateBefore")));
//        LocalDate dateAfter = ((LocalDate) (req.getSession().getAttribute("dateAfter")));
//        Long limit = ((Long) (req.getSession().getAttribute("limit")));
//        Long offset = ((Long) (req.getSession().getAttribute("offset")) + limit);
//        req.getSession().setAttribute("offset", offset);
//
//        List<PlayerBasicInfoDto> players = playerService
//                .findByFilter(club, position, dateBefore, dateAfter, limit, offset);
//        req.setAttribute("findPlayers", players);
//        getServletContext()
//                .getRequestDispatcher(JspPathUtil.get("players"))
//                .forward(req, resp);
//    }
//}
