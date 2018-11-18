package com.dubin.football.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StadiumBasicInfoDto {

    private Integer id;
    private String name;
}