package com.dubin.football.database.dao;

import com.dubin.football.database.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsDao extends CrudRepository<News, Long> {
}
