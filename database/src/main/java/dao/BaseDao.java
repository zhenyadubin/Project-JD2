package dao;

import model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<P extends Serializable, E extends BaseModel<P>> {

    P save(E entity);

    void update(E entity);

    void delete(E entity);

    E find(P id);

    List<E> findAll();
}
