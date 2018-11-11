package service;

import dao.FootballClubDaoImpl;
import dto.FootballClubBasicInfoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.FootballClub;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FootballClubService {

    private static final FootballClubService INSTANCE = new FootballClubService();

    public List<FootballClubBasicInfoDto> findAll() {
        return FootballClubDaoImpl.getInstance().findAll().stream()
                .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public FootballClub findById(Integer clubId) {
        return FootballClubDaoImpl.getInstance().find(clubId);
    }

    public static FootballClubService getInstance() {
        return INSTANCE;
    }
}
