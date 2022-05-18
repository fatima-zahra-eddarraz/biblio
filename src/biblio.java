import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class biblio {

     Connection cnx=null;
    static Statement st;
    static ResultSet rst;

    public static void main(String [] args ) throws IOException, SQLException {
        PreparedStatement pst =null;
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.print("Veuillez saisir votre sélection:\n");
        System.out.println("1: - sign in");
        System.out.println("2: - sing up");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("________________________");

                System.out.println("Veuillez saisir votre NumeroAdh :");
                String Num = scan.nextLine();

                System.out.println("Veuillez saisir votre nom:");
                String  nomadh = scan.nextLine();
                Connection cnx =connexion.connectdb();
                st=cnx.createStatement();
                String rqt = "SELECT * FROM adh WHERE NumeroAdh= '"+Num+"' AND nom='"+nomadh+"'";
                try {
                    pst= cnx.prepareStatement(rqt);
                    rst=pst.executeQuery(rqt);
                    if(rst.next()){
                        if(rst.getString("status").equals("admin")) {
                            System.out.println("auth avec succee");

                            System.out.println("-.-.-.-.-.-.-.-MENU-.-.-.-.-.-.-.-");

                            System.out.print("Veuillez saisir votre sélection:\n");
                            System.out.println("1: - ajouter exemplaire");
                            System.out.println("2: - sup exempleire");
                            System.out.println("3: - emprunter");
                            System.out.println("4: - rendre");
                            System.out.println("5: - ajouter etudiant");
                            System.out.println("6: - supprimer etudiant");
                            int selection2 = scanner.nextInt();

                            switch (selection2) {
                                case 1:
                                    System.out.print("Veuillez saisir votre sélection:\n");
                                    System.out.println("1: - ajouter livre");
                                    System.out.println("2: - ajouter document");
                                    int selection4 = scanner.nextInt();

                                    switch (selection4) {
                                        case 1:

                                            Livre l=new Livre(true);
                                            l.ajouterLivre();
                                            break;
                                        case 2:

                                            Document d=new Document(true);
                                            d.ajouterDoc();
                                            break;
                                    }

                                    break;
                                case 2:
                                    System.out.print("Veuillez saisir votre sélection:\n");
                                    System.out.println("1: - supp livre");
                                    System.out.println("2: - supp document");
                                    int selection5 = scanner.nextInt();

                                    switch (selection5) {
                                        case 1:
                                            Livre l=new Livre(true);
                                            l.supLivre();
                                            break;
                                        case 2:
                                            Document d=new Document(true);
                                            d.supDoc();
                                            break;
                                    }

                                    break;
                                case 3:

                                            Adh adh= new Adh();
                                            adh.emprunter(Num,nomadh);
                                    break;
                                case 4:

                                    Adh adh2= new Adh();
                                    adh2.rendre(Num,nomadh);
                                    break;
                                case 5:

                                    Enseignant ens= new Enseignant();
                                    ens.ajoutEtudiant();
                                    break;
                                case 6:

                                    Enseignant ens1= new Enseignant();
                                    ens1.suppEtudiant();
                                    break;

                            }
                        }else if(rst.getString("status").equals("etudiant")){
                            System.out.println("-.-.-.-.-.-.-.-MENU-.-.-.-.-.-.-.-");
                            System.out.print("Veuillez saisir votre sélection:\n");
                            System.out.println("1: - emprunter exemplaire");
                            System.out.println("2: - rendre");
                            int selection3 = scanner.nextInt();
                            switch (selection3) {

                                case 1:
                                    Adh adh= new Adh();
                                    adh.emprunter(Num,nomadh);
                                    break;
                                case 2:
                                    Adh adh2= new Adh();
                                    adh2.rendre(Num,nomadh);
                                    break;
                            }
                        }

                    }else{
                        System.out.println("ops");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case 2:
                System.out.println("Veuillez saisir votre NumeroAdh :");
                String nume = scan.nextLine();

                System.out.println("Veuillez saisir votre nom:");
                String  nomadhEtu = scan.nextLine();
                System.out.println("Veuillez saisir votre prenom:");
                String  prenom = scan.nextLine();
                System.out.println("Veuillez saisir votre email:");
                String  email = scan.nextLine();
                Connection cn =connexion.connectdb();
                st=cn.createStatement();
                String rq = "SELECT * FROM adh WHERE NumeroAdh= '"+nume+"' AND nom='"+nomadhEtu+"'";
                try {
                    pst = cn.prepareStatement(rq);
                    rst = pst.executeQuery(rq);
                    if (rst.next()) {
                        System.out.println("etudiant deja inscrit");
                    }else {
                        String etd ="etudiant";
                        String sql = "INSERT INTO `adh` (`NumeroAdh`, `nom`, `prenom`, `email`,`NombreEmprunte`,`status`,`penalite`) VALUES ('"+nume+"', '"+nomadhEtu+"', '"+prenom+"', '"+email+"','0','"+etd+"','0')";
                        pst = cn.prepareStatement(sql);
                        pst.execute();
                        System.out.println("inscription avec succes");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }







}
}
