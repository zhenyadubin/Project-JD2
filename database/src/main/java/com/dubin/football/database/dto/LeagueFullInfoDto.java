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
public class LeagueFullInfoDto {

    private String name;
    private String country;
    private int numberOfClubs;

    private List<NewsBasicInfoDto> news = new ArrayList<>();
}
