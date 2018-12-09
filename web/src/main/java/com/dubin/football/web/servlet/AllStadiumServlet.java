package com.dubin.football.web.servlet;

import com.dubin.football.service.repository.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllStadiumServlet {

    @Autowired
    StadiumService stadiumService;

    @GetMapping("/stadiums")
    public String stadiums(Model model) {
        model.addAttribute("stadiums", stadiumService.getAll());
        return "stadiums";
    }
}


//package com.dubin.football.web.servlet;
//
//import com.dubin.football.database.dto.StadiumBasicInfoDto;
//import com.dubin.football.service.repository.StadiumService;
//import com.dubin.football.web.util.ApplicationContextHolder;
//import com.dubin.football.web.util.JspPathUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/stadiums")
//public class AllStadiumServlet extends HttpServlet {
//
//    private StadiumService stadiumService = ApplicationContextHolder.getContext()
//            .getBean("stadiumService", StadiumService.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<StadiumBasicInfoDto> stadiums = stadiumService.getAll();
//        req.setAttribute("stadiums", stadiums);
//        getServletContext()
//                .getRequestDispatcher(JspPathUtil.get("stadiums"))
//                .forward(req, resp);
//    }
//}
