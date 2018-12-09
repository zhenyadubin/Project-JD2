package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.AddCityTagDto;
import com.dubin.football.database.dto.AddCoachTagDto;
import com.dubin.football.database.dto.AddCountryTagDto;
import com.dubin.football.database.dto.AddFootballClubTagDto;
import com.dubin.football.database.dto.AddLeagueTagDto;
import com.dubin.football.database.dto.AddPlayerTagDto;
import com.dubin.football.database.dto.VisitorFullInfoDto;
import com.dubin.football.database.dto.VisitorSaveDto;
import com.dubin.football.service.repository.CityService;
import com.dubin.football.service.repository.CoachService;
import com.dubin.football.service.repository.CountryService;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.LeagueService;
import com.dubin.football.service.repository.PlayerService;
import com.dubin.football.service.repository.VisitorServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VisitorController {

    private final VisitorServiceRepository visitorService;
    private final CountryService countryService;
    private final CityService cityService;
    private final LeagueService leagueService;
    private final FootballClubService footballClubService;
    private final CoachService coachService;
    private final PlayerService playerService;

    @GetMapping("/registration")
    public String saveVisitorGet(Model model) {
        model.addAttribute("visitorSaveDto", new VisitorSaveDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveVisitorPost(VisitorSaveDto visitorSaveDto) {
        visitorService.saveVisitor(visitorSaveDto);
        return "login";
    }

    @GetMapping("/visitor-info")
    public String getVisitorFullInfo(Model model, Authentication authentication) {
        VisitorFullInfoDto visitorFullInfoDto = visitorService.getVisitorFullInfo(authentication.getName());
        model.addAttribute("visitor", visitorFullInfoDto);
        model.addAttribute("countries", visitorFullInfoDto.getCountries());
        model.addAttribute("cities", visitorFullInfoDto.getCities());
        model.addAttribute("leagues", visitorFullInfoDto.getLeagues());
        model.addAttribute("clubs", visitorFullInfoDto.getClubs());
        model.addAttribute("coaches", visitorFullInfoDto.getCoaches());
        model.addAttribute("players", visitorFullInfoDto.getPlayers());
        return "visitor-info";
    }

    @GetMapping("/add-country-tag")
    public String addCountryTagGet(Model model) {
        model.addAttribute("countryTag", new AddCountryTagDto());
        model.addAttribute("countriesTag", countryService.findAllCountriesBasicInfo());
        return "add-country-tag";
    }

    @PostMapping("/add-country-tag")
    public String getCountryTag(AddCountryTagDto countryTagDto, Authentication authentication) {
        countryTagDto.setVisitorName(authentication.getName());
        visitorService.addCountryTag(countryTagDto);
        return "redirect:visitor-info";
    }

    @GetMapping("/add-city-tag")
    public String addCityTagGet(Model model) {
        model.addAttribute("cityTag", new AddCityTagDto());
        model.addAttribute("citiesTag", cityService.findAll());
        return "add-city-tag";
    }

    @PostMapping("/add-city-tag")
    public String getCityTag(AddCityTagDto cityTagDto, Authentication authentication) {
        cityTagDto.setVisitorName(authentication.getName());
        visitorService.addCityTag(cityTagDto);
        return "redirect:visitor-info";
    }

    @GetMapping("/add-league-tag")
    public String addLeagueTagGet(Model model) {
        model.addAttribute("leagueTag", new AddLeagueTagDto());
        model.addAttribute("leaguesTag", leagueService.findAll());
        return "add-league-tag";
    }

    @PostMapping("/add-league-tag")
    public String getLeagueTag(AddLeagueTagDto leagueTagDto, Authentication authentication) {
        leagueTagDto.setVisitorName(authentication.getName());
        visitorService.addLeagueTag(leagueTagDto);
        return "redirect:visitor-info";
    }

    @GetMapping("/add-club-tag")
    public String addClubTagGet(Model model) {
        model.addAttribute("clubTag", new AddFootballClubTagDto());
        model.addAttribute("clubsTag", footballClubService.findAll());
        return "add-club-tag";
    }

    @PostMapping("/add-club-tag")
    public String getClubTag(AddFootballClubTagDto footballClubTagDto, Authentication authentication) {
        footballClubTagDto.setVisitorName(authentication.getName());
        visitorService.addClubTag(footballClubTagDto);
        return "redirect:visitor-info";
    }

    @GetMapping("/add-coach-tag")
    public String addCoachTagGet(Model model) {
        model.addAttribute("coachTag", new AddCoachTagDto());
        model.addAttribute("coachesTag", coachService.findAll());
        return "add-coach-tag";
    }

    @PostMapping("/add-coach-tag")
    public String getCoachTag(AddCoachTagDto coachTagDto, Authentication authentication) {
        coachTagDto.setVisitorName(authentication.getName());
        visitorService.addCoachTag(coachTagDto);
        return "redirect:visitor-info";
    }

    @GetMapping("/add-player-tag")
    public String addPlayerTagGet(Model model) {
        model.addAttribute("playerTag", new AddPlayerTagDto());
        model.addAttribute("playersTag", playerService.findAll());
        return "add-player-tag";
    }

    @PostMapping("/add-player-tag")
    public String getPlayerTag(AddPlayerTagDto playerTagDto, Authentication authentication) {
        playerTagDto.setVisitorName(authentication.getName());
        visitorService.addPlayerTag(playerTagDto);
        return "redirect:visitor-info";
    }
}
