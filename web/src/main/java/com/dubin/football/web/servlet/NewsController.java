package com.dubin.football.web.servlet;

import com.dubin.football.database.dto.NewsFullInfoDto;
import com.dubin.football.database.dto.SaveNewsDto;
import com.dubin.football.database.dto.TagsForNews;
import com.dubin.football.service.repository.CityService;
import com.dubin.football.service.repository.CoachService;
import com.dubin.football.service.repository.CountryService;
import com.dubin.football.service.repository.FootballClubService;
import com.dubin.football.service.repository.LeagueService;
import com.dubin.football.service.repository.NewsService;
import com.dubin.football.service.repository.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NewsController {

    private final NewsService newsService;
    private final CountryService countryService;
    private final CityService cityService;
    private final LeagueService leagueService;
    private final FootballClubService footballClubService;
    private final CoachService coachService;
    private final PlayerService playerService;

    @GetMapping("/all-news")
    public String getAllNews(Model model) {
        model.addAttribute("allNews", newsService.findAll());
        return "all-news";
    }

    @GetMapping("/news")
    public String getNews(Model model, @RequestParam("id") Long newsId) {
        NewsFullInfoDto news = newsService.findNews(newsId);
        model.addAttribute("news", news);
        model.addAttribute("countries", news.getCountries());
        model.addAttribute("cities", news.getCities());
        model.addAttribute("leagues", news.getLeagues());
        model.addAttribute("clubs", news.getClubs());
        model.addAttribute("coaches", news.getCoaches());
        model.addAttribute("players", news.getPlayers());
        return "news";
    }

    @GetMapping("/create-news")
    public String saveNewsGet(Model model) {
        model.addAttribute("saveNewsDto", new SaveNewsDto());
        return "create-news";
    }

    @PostMapping("/create-news")
    public String saveNewsPost(SaveNewsDto saveNewsDto, Authentication authentication) {
        saveNewsDto.setAuthorName(authentication.getName());
        saveNewsDto.setDateTime(LocalDateTime.now());
        newsService.saveNews(saveNewsDto);
        return "redirect:create-news";
    }

    @GetMapping("/add-tags-to-news")
    public String addTagsGet(Model model) {
        model.addAttribute("news", newsService.findAll());
        model.addAttribute("countries", countryService.findAllCountriesBasicInfo());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("leagues", leagueService.findAll());
        model.addAttribute("footballClub", footballClubService.findAll());
        model.addAttribute("coaches", coachService.findAll());
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("tagsForNews", new TagsForNews());
        return "add-tags-to-news";
    }

    @PostMapping("/add-tags-to-news")
    public String addTagsPost(TagsForNews tagsForNews) {
        newsService.addTagsToNews(tagsForNews);
        return "redirect:add-tags-to-news";
    }
}
