package com.dubin.football.service.repository;

import com.dubin.football.database.dao.StadiumDao;
import com.dubin.football.database.dto.StadiumBasicInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StadiumService {

    @Autowired
    private final StadiumDao stadiumDao;

    public List<StadiumBasicInfoDto> getAll() {
        return stadiumDao.findAll().stream()
                .map(it -> new StadiumBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }
}
