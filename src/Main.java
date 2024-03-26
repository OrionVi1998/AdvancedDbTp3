import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost/lab1";
        Properties props = new Properties();

        props.setProperty("user", "admin");
        props.setProperty("password", "1234");


        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, props);

            System.out.println("DB Connected");
            displayDepartment(connexion);

            moveDepartment(connexion, 7499, 20);
            moveDepartment(connexion, 7499, 30);
            displayTable(connexion, "emp");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connexion != null)
                try {
                    connexion.close();
                } catch (SQLException _ignore) {
                    _ignore.printStackTrace();
                }
        }


    }

    public static void displayDepartment(Connection connexion) throws SQLException {
        Statement statement = connexion.createStatement();
        ResultSet result = statement.executeQuery("SELECT deptno, dname,loc FROM dept;");

        while (result.next()) {
            int deptno = result.getInt("deptno");
            String dname = result.getString("dname");
            String loc = result.getString("loc");


            System.out.println("Department " + deptno + " is for "
                    + dname + " and located in " + loc);
        }
        result.close();
    }

    public static void moveDepartment(Connection connexion, int empno, int newDeptno) throws SQLException {
        PreparedStatement statement = connexion
                .prepareStatement("UPDATE emp SET deptno = ? WHERE empno = ?");
        statement.setInt(1, newDeptno);
        statement.setInt(2, empno);

        int result = statement.executeUpdate();
        System.out.println(result + ": Update by moveDepartment");
    }

    public static void displayTable(Connection connexion, String tableName) throws SQLException {
        PreparedStatement statement = connexion
                .prepareStatement("SELECT * FROM " + tableName);

        ResultSet result = statement.executeQuery();

        ResultSetMetaData metaData = result.getMetaData();
        int colCount = metaData.getColumnCount();

        StringBuilder tableNameBuilder = new StringBuilder();
        for (int i = 1; i <= colCount; i++) {
            tableNameBuilder.append(metaData.getColumnName(i)).append(" | ");
        }


        System.out.println(tableNameBuilder);

        while (result.next()) {

            StringBuilder tableValBuilder = new StringBuilder();
            for (int i = 1; i <= colCount; i++) {
                tableValBuilder.append(result.getArray(i)).append(" | ");
            }
            System.out.println(tableValBuilder);



        }
        result.close();

    }
}