package com.dubin.football.database.dto;

import com.dubin.football.database.enams.PlayerPosition;
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
public class CreatePlayerDto {

    private String firstName;
    private String lastName;
    private Integer countryId;
    private Integer clubId;
    private Integer number;
    private PlayerPosition position;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
