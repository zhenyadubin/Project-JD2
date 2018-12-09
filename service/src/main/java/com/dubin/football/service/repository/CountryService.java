package com.dubin.football.service.repository;

import com.dubin.football.database.dao.CountryDao;
import com.dubin.football.database.dto.CountryBasicInfoDto;
import com.dubin.football.database.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryService {

    private final CountryDao countryDao;

    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public List<CountryBasicInfoDto> findAllCountriesBasicInfo() {
        return countryDao.findAll().stream()
                .map(it -> new CountryBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }
}
