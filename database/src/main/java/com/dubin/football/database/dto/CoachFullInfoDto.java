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
public class CoachFullInfoDto {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String countryName;
    private Integer countryId;

    private List<NewsBasicInfoDto> news = new ArrayList<>();
}
