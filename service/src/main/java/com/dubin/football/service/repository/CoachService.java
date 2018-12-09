package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CoachDao;
import com.dubin.football.database.dto.CoachBasicInfoDto;
import com.dubin.football.database.dto.CoachFullInfoDto;
import com.dubin.football.database.dto.NewsBasicInfoDto;
import com.dubin.football.database.model.Coach;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoachService {

    private final CoachDao coachDao;

    public List<CoachBasicInfoDto> findAll() {
        return coachDao.findAll().stream()
                .map(it -> new CoachBasicInfoDto(it.getId(), it.getFirstName() + " " + it.getLastName()))
                .collect(Collectors.toList());
    }

    public CoachFullInfoDto findCoachsFullInfo(Integer coachId) {
        Coach coach = coachDao.findById(coachId).get();
        return CoachFullInfoDto.builder()
                .firstName(coach.getFirstName())
                .lastName(coach.getLastName())
                .birthDate(coach.getBirthDate().getDayOfMonth() + " "
                        + coach.getBirthDate().getMonthValue() + " "
                        + coach.getBirthDate().getYear())
                .countryName(coach.getCountry().getName())
                .countryId(coach.getCountry().getId())
                .news(coach.getNews().stream()
                        .map(it -> new NewsBasicInfoDto(it.getId(),
                                it.getName(),
                                it.getDateTime().getDayOfMonth() + " "
                                        + it.getDateTime().getMonthValue() + " "
                                        + it.getDateTime().getYear() + ", "
                                        + it.getDateTime().getHour() + ":"
                                        + it.getDateTime().getMinute(),
                                it.getAuthor().getName()))
                        .collect(Collectors.toList()))
                .build();
    }
}
