package com.dubin.football.database.enams;

import lombok.Getter;

@Getter
public enum PlayerPosition {

    GOALKEEPER("Вратарь"),
    DEFENDER("Защитник"),
    MIDFIELDER("Полузащитник"),
    FORWARD("Нападающий");

    private String description;

    PlayerPosition(String description) {
        this.description = description;
    }
}
