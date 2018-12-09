package com.dubin.football.database.dto;

import com.dubin.football.database.enams.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VisitorFullInfoDto {

    private Long id;
    private String name;
    private String email;
    private Role role;

    private List<CountryBasicInfoDto> countries = new ArrayList<>();
    private List<CityBasicInfoDto> cities = new ArrayList<>();
    private List<LeagueBasicInfoDto> leagues = new ArrayList<>();
    private List<FootballClubBasicInfoDto> clubs = new ArrayList<>();
    private List<CoachBasicInfoDto> coaches = new ArrayList<>();
    private List<PlayerBasicInfoDto> players = new ArrayList<>();
}
