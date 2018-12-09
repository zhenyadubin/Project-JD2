package com.dubin.football.database.dao;

import com.dubin.football.database.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityDao extends CrudRepository<City, Integer> {

    List<City> findAll();
}
