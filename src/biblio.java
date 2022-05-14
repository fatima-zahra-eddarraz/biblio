import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class biblio {


    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public static void main(String [] args ) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        try {

            Connection cnx =connexion.connectdb();
            st=cnx.createStatement();
            rst=st.executeQuery("select * from etudiant");
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        System.out.println("Veuillez saisir votre NumeroAdh :");
        String Num = scanner.nextLine();

        System.out.println("Veuillez saisir votre nom:");
        String  nomadh = scanner.nextLine();

       ResultSet rs = null;
        String rqt = "SELECT * FROM adh WHERE NumeroAdh="+Num+" ";
        try {
           // st=cnx.createStatement();
            rst=st.executeQuery(rqt);
            if(rst.next()){
                System.out.println("auth avec succee");

                System.out.println("-.-.-.-.-.-.-.-MENU-.-.-.-.-.-.-.-");

                System.out.print("Veuillez saisir votre sélection:\n");
                System.out.println("1: - ajouter exemplaire");
                System.out.println("2: - sup exempleire");
                System.out.println("3: - reserver exemplaire");
                System.out.println("4: - emprunter exemplaire");
                System.out.println("5: - rendre");
                System.out.println("6: - pinalite");
                int selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                            //ajouter

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;

                }


            }else{
                System.out.println("ops");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



}
}
