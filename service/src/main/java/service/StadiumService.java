package service;

import dao.StadiumDaoImpl;
import dto.StadiumBasicInfoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumService {

    private static final StadiumService INSTANCE = new StadiumService();

    public List<StadiumBasicInfoDto> getAll() {
        return StadiumDaoImpl.getInstance().findAll().stream()
                .map(it -> new StadiumBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public static StadiumService getInstance() {
        return INSTANCE;
    }
}
