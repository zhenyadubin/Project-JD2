package com.dubin.football.database.dao;

import com.dubin.football.database.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDao extends CrudRepository<City, Integer> {
}
