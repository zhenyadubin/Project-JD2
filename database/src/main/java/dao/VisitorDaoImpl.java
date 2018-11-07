package dao;

import model.Visitor;

public class VisitorDaoImpl extends BaseDaoImpl<Long, Visitor> implements VisitorDao {

    private static final VisitorDaoImpl INSTANCE = new VisitorDaoImpl();

    public static VisitorDaoImpl getInstance() {
        return INSTANCE;
    }

    public VisitorDaoImpl() {
        super(Visitor.class);
    }
}
