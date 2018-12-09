package com.dubin.football.database.dto;

import com.dubin.football.database.enams.PlayerPosition;
import com.dubin.football.database.model.FootballClub;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterDto {

    private FootballClub footballClub;
    private PlayerPosition playerPosition;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBefore;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAfter;
    private Long limit;
    private Long offset;
}
