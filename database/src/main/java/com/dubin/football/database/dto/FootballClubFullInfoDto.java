package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FootballClubFullInfoDto {

    private String name;
    private String stadiumName;
    private String cityName;
    private String foundationDate;
    private String leagueName;
    private String coachName;
    private Integer coachId;

    private List<NewsBasicInfoDto> news = new ArrayList<>();
}
