import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost/postgres";
        String user = "admin";
        String pass = "1234";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, user, pass);

            /* Requests to bdd will be here */
            System.out.println("DB Connected");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connexion != null)
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
        }

    }
}