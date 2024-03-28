package DAO;

import model.Dept;

import java.sql.*;

public class DeptDAO extends DAO {

    public DeptDAO(Connection c) {
        super(c);
    }

    @Override
    public Dept find(int id) throws SQLException {
        PreparedStatement statement = this.connect
                .prepareStatement("SELECT deptno, dname, loc FROM dept WHERE deptno = ?;");
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return new Dept(result.getLong(1), result.getString(2), result.getString(3));
        }

        throw new SQLException("Not found");
    }

    public static Dept find(int id, Connection connection) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("SELECT deptno, dname, loc FROM dept WHERE deptno = ?;");
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return new Dept(result.getLong(1), result.getString(2), result.getString(3));
        }

        throw new SQLException("Not found");
    }

    @Override
    public boolean create(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }
}
