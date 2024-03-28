package DAO;

import model.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO extends DAO {

    public EmpDAO(Connection c) {
        super(c);
    }

    @Override
    public Emp find(int id) throws SQLException {
        PreparedStatement statement = this.connect
                .prepareStatement("SELECT * FROM emp WHERE empno = ?;");
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return new Emp(
                    result.getLong(1), // empNo
                    result.getString(2), //ename
                    result.getString(3), //efirst
                    result.getString(4), // job
                    this.find(result.getInt(5)), // mgr
                    result.getDate(6), // hireDate
                    result.getInt(7), // sal
                    result.getInt(8), // comm
                    result.getInt(9), // tel
                    DeptDAO.find(result.getInt(10), this.connect) // dept
                    );
        }

        return null;
    }

    @Override
    public boolean create(Object object) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object object) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Object object) throws SQLException {
        return false;
    }
}
