package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.CoachFullInfoDto;
import com.dubin.football.service.repository.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/coach")
    public String getCoachFullInfo(Model model, @RequestParam("id") String coachId) {
        CoachFullInfoDto coachFullInfoDto = coachService.findCoachsFullInfo(Integer.valueOf(coachId));
        model.addAttribute("coach", coachFullInfoDto);
        model.addAttribute("allNews", coachFullInfoDto.getNews());
        return "coach";
    }
}
