package com.dubin.football.database.dao;

import com.dubin.football.database.model.Stadium;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StadiumDao extends CrudRepository<Stadium, Integer> {

    List<Stadium> findAll();
}
