package com.dubin.football.database.dao;

import com.dubin.football.database.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<News, Long> {
}
