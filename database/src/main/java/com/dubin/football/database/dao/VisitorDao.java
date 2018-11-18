package com.dubin.football.database.dao;

import com.dubin.football.database.model.Visitor;
import org.springframework.data.repository.CrudRepository;

public interface VisitorDao extends CrudRepository<Visitor, Long> {
}
