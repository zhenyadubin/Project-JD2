package service;

import dao.StadiumDao;
import dto.StadiumBasicInfoDto;
import dto.StadiumFullInfoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Stadium;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumService {

    private static final StadiumService INSTANCE = new StadiumService();

    public List<StadiumBasicInfoDto> getAll() {
        return StadiumDao.getInstance().getAllStadium().stream()
                .map(it -> new StadiumBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public StadiumFullInfoDto getById(Integer stadiumId) {
        Stadium stadium = StadiumDao.getInstance().getById(stadiumId);
        return StadiumFullInfoDto.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .numberOfSeats(stadium.getNumberOfSeats())
                .city(stadium.getCity())
                .build();
    }

    public static StadiumService getInstance() {
        return INSTANCE;
    }
}
