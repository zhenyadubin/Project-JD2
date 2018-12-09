package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.CreatePlayerDto;
import com.dubin.football.database.dto.PlayerFullInfoDto;
import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.service.repository.CountryService;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final CountryService countryService;
    private final FootballClubService footballClubService;

    @Autowired
    public PlayerController(PlayerService playerService, CountryService countryService, FootballClubService footballClubService) {
        this.playerService = playerService;
        this.countryService = countryService;
        this.footballClubService = footballClubService;
    }

    @ModelAttribute("allPosition")
    public PlayerPosition[] getIngredients() {
        return PlayerPosition.values();
    }

    @GetMapping("/create-player")
    public String createPlayerGet(Model model) {
        model.addAttribute("countries", countryService.findAllCountriesBasicInfo());
        model.addAttribute("footballClub", footballClubService.findAll());
        model.addAttribute("createPlayerDto", new CreatePlayerDto());
        return "create-player";
    }

    @PostMapping("/create-player")
    public String createPlayerPost(CreatePlayerDto createPlayerDto) {
        playerService.savePlayer(createPlayerDto);
        return "redirect:create-player";
    }

    @GetMapping("/player")
    public String getPlayerFullInfo(Model model, @RequestParam("id") String playerId) {
        PlayerFullInfoDto playerFullInfoDto = playerService.findPlayersFullInfoById(Integer.valueOf(playerId));
        model.addAttribute("player", playerFullInfoDto);
        model.addAttribute("allNews", playerFullInfoDto.getNews());
        return "player";
    }
}
