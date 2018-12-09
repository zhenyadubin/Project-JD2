package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagsForNews {

    private Long newsId;
    private Integer countryId;
    private Integer cityId;
    private Integer leagueId;
    private Integer clubId;
    private Integer coachId;
    private Integer playerId;
}
