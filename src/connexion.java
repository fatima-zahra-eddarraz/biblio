import java.io.IOException;
import java.sql.*;

public class connexion {



    public static Connection connectdb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver done");
            String url = "jdbc:mysql://localhost/biblio";
            String user = "root";
            String password = "";
            Connection cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connexion bien etablie");
            return cnx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
