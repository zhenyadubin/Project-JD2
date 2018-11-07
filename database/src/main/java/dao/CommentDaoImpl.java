package dao;

import model.VisitorComment;

public class CommentDaoImpl extends BaseDaoImpl<Long, VisitorComment> implements CommentDao {

    private static final CommentDaoImpl INSTANCE = new CommentDaoImpl();

    public static CommentDaoImpl getInstance() {
        return INSTANCE;
    }

    public CommentDaoImpl() {
        super(VisitorComment.class);
    }
}
