package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CityDao;
import com.dubin.football.database.dto.CityBasicInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityService {

    private final CityDao cityDao;

    public List<CityBasicInfoDto> findAll() {
        return cityDao.findAll().stream()
                .map(it -> new CityBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }
}
