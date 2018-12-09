package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddCoachTagDto {

    private String visitorName;
    private Integer coachId;
}
