package com.dubin.football.database.dao;

import com.dubin.football.database.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryDao extends CrudRepository<Country, Integer> {

    List<Country> findAll();
}
