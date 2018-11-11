package service;

import dao.PlayerDaoImpl;
import dto.PlayerBasicInfoDto;
import enams.PlayerPosition;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.FootballClub;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerService {

    private static final PlayerService INSTANCE = new PlayerService();

    public List<PlayerBasicInfoDto> findByFilter(FootballClub club, PlayerPosition position
            , LocalDate dateBefore, LocalDate dateAfter) {
        return PlayerDaoImpl.getInstance().findBy(club, position, dateBefore, dateAfter).stream()
                .map(it -> new PlayerBasicInfoDto(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }

    public static PlayerService getInstance() {
        return INSTANCE;
    }
}
