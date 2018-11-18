package com.dubin.football.service.repository;

import com.dubin.football.database.dao.FootballClubDao;
import com.dubin.football.database.dto.FootballClubBasicInfoDto;
import com.dubin.football.database.model.FootballClub;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FootballClubService {

    @Autowired
    private final FootballClubDao footballClubDao;

    public List<FootballClubBasicInfoDto> findAll() {
        return footballClubDao.findAll().stream()
                .map(it -> new FootballClubBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public FootballClub findById(Integer clubId) {
        return footballClubDao.findById(clubId).get();
    }
}
