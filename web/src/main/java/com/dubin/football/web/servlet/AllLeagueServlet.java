package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.LeagueFullInfoDto;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AllLeagueServlet {

    private final LeagueService leagueService;
    private final FootballClubService footballClubService;

    @Autowired
    public AllLeagueServlet(LeagueService leagueService, FootballClubService footballClubService) {
        this.leagueService = leagueService;
        this.footballClubService = footballClubService;
    }

    @GetMapping("/leagues")
    public String getAllLeagues(Model model) {
        model.addAttribute("leagues", leagueService.findAll());
        return "leagues";
    }

    @GetMapping("/league")
    public String getLeague(Model model, @RequestParam("id") String leagueId) {
        LeagueFullInfoDto leagueFullInfoDto = leagueService.findById(Integer.valueOf(leagueId));
        model.addAttribute("league", leagueFullInfoDto);
        model.addAttribute("footballClubs", footballClubService.findAllByLeague(Integer.valueOf(leagueId)));
        model.addAttribute("allNews", leagueFullInfoDto.getNews());
        return "league";
    }
}
