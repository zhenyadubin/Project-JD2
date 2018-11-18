package com.dubin.football.database.dao;

import com.dubin.football.database.model.VisitorComment;
import org.springframework.data.repository.CrudRepository;

public interface CommentDao extends CrudRepository<VisitorComment, Long> {
}
