package com.dubin.football.database.dao;

import com.dubin.football.database.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorDao extends JpaRepository<Visitor, Long> {

    Optional<Visitor> findByName(String name);
}
