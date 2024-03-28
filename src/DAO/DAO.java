package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection connect) {
        this.connect = connect;
    }

    public abstract T find(int id) throws SQLException;

    public abstract boolean create(T object) throws SQLException;

    public abstract boolean update(T object) throws SQLException;

    public abstract boolean delete(T object) throws SQLException;

}
