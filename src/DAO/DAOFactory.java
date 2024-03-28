package DAO;

import java.sql.Connection;

public class DAOFactory {

    private Connection connect = null;

    public DAOFactory(Connection connect) {
        this.connect = connect;
    }

    public DeptDAO getDeptDao() {
        return new DeptDAO(connect);
    }

    public EmpDAO getEmpDao() {
        return new EmpDAO(connect);
    }

}
