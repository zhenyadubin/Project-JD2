package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerFullInfoDto {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String countryName;
    private String footballClubName;
    private String position;
    private Integer number;

    private List<NewsBasicInfoDto> news = new ArrayList<>();
}
