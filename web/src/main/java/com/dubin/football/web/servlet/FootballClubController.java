package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.FootballClubFullInfoDto;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FootballClubController {

    private final FootballClubService footballClubService;
    private final PlayerService playerService;

    @Autowired
    public FootballClubController(FootballClubService footballClubService, PlayerService playerService) {
        this.footballClubService = footballClubService;
        this.playerService = playerService;
    }

    @GetMapping("/football-club")
    public String getFootballClub(Model model, @RequestParam("id") String clubId) {
        FootballClubFullInfoDto footballClubFullInfoDto = footballClubService.findFullInfoById(Integer.valueOf(clubId));
        model.addAttribute("footballClub", footballClubFullInfoDto);
        model.addAttribute("players", playerService.findPlayersByFootballClub(Integer.valueOf(clubId)));
        model.addAttribute("allNews", footballClubFullInfoDto.getNews());
        return "football-club";
    }
}
