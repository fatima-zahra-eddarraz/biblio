import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class connexion {
    Connection conn=null;


    public static Connection connectdb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");
            return conn;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
