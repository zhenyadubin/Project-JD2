package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsFullInfoDto {

    private Long id;
    private String title;
    private String text;
    private String dateAndTime;
    private String authorName;

    private List<CountryBasicInfoDto> countries;
    private List<CityBasicInfoDto> cities;
    private List<LeagueBasicInfoDto> leagues;
    private List<FootballClubBasicInfoDto> clubs;
    private List<CoachBasicInfoDto> coaches;
    private List<PlayerBasicInfoDto> players;
}
