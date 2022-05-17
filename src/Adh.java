import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Adh {
    private long NumeroAdh;
    private String nom;
    private String prenom;
    private String email;
    private long emprunt;
    private long NombreEmprunte;
    private String penalite;
    int count=0;
    int nbrExemplaire;
    int nbrAdhEmprunt=0;
    int nb2=0;
    int nbrExemplaireEmprunt=0;
    PreparedStatement pst;
    Connection cnx;
    static Statement st;
    static ResultSet rst;
    PreparedStatement pst1;
    Connection cnx1;
    static Statement st1;
    static ResultSet rst1;
    Scanner scan = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    public void emprunter(String numero,String nom) throws SQLException {
        System.out.print("est ce vous voulez emprunter:\n");
        System.out.println("1: - livre");
        System.out.println("2: - doc");
        int selection = scan.nextInt();

        switch (selection) {
            case 1:

                System.out.println("Veuillez saisir le titre du livre :");
                String titre = scanner.nextLine();
                System.out.println("Veuillez saisir prenom editeur:");
                String prenomEditeur = scanner.nextLine();
                System.out.println("Veuillez saisir nom editeur:");
                String nomEditeur = scanner.nextLine();

                int id=0;
                try {
                    Connection conn = connexion.connectdb();
                    String reqq = "SELECT * FROM livre WHERE nomEditeur= '"+nomEditeur+"' AND prenomEditeur='"+prenomEditeur+"'AND titre='"+titre+"'";
                    PreparedStatement ps = conn.prepareStatement(reqq);
                    ResultSet rs = ps.executeQuery(reqq);
                    if (rs.next()) {
                        id = rs.getInt("idLivre");
                        nbrExemplaire=rs.getInt("nbrExemplaire");
                        nbrExemplaireEmprunt=rs.getInt("nbrExemplaireEmprunter");

                        try {
                            String sqlAdh11 = "select * from emprunt WHERE adh ='"+numero+"'AND livre='"+id+"' AND rendu= '0'";
                            Connection condb145 = connexion.connectdb();
                            PreparedStatement pst34 = condb145.prepareStatement(sqlAdh11);
                            ResultSet rst34 = pst34.executeQuery(sqlAdh11);
                            if (rst34.next()) {
                                System.out.println("vous avez deja ce livre");
                            }else {

                                if (nbrExemplaire > nbrExemplaireEmprunt) {
                                    String rqt = "SELECT * FROM adh WHERE NumeroAdh= '" + numero + "' AND nom='" + nom + "'";
                                    try {
                                        Connection condb = connexion.connectdb();
                                        PreparedStatement pst1 = condb.prepareStatement(rqt);
                                        ResultSet rst1 = pst1.executeQuery(rqt);
                                        if (rst1.next()) {
                                            nbrAdhEmprunt = rst1.getInt("NombreEmprunte");
                                            if (nbrAdhEmprunt < 3) {
                                                try {
                                                    Connection condb1 = connexion.connectdb();
                                                    String sqlEmprunt = "INSERT INTO emprunt (`livre`, `dateEmprunt`, `DateFinEmprunt`, `adh`,`rendu`) VALUES ('" + id + "', Date(now()), Date(now())+3,'" + numero + "',0)";
                                                    PreparedStatement pst11 = condb1.prepareStatement(sqlEmprunt);
                                                    pst11.execute();
                                                    System.out.println("emprunt executer");
                                                } catch (SQLException e) {
                                                    System.out.println("emprt insert err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("emprt insert err2" + E.getMessage());
                                                }
                                                try {
                                                    Connection condb2 = connexion.connectdb();
                                                    int nb2 = nbrExemplaireEmprunt + 1;
                                                    String sqlAdh = "UPDATE `livre` SET `nbrExemplaireEmprunter` = '" + nb2 + "' WHERE idLivre = '" + id + "'";
                                                    PreparedStatement pst33 = condb2.prepareStatement(sqlAdh);
                                                    pst33.execute();
                                                    System.out.println("update ADH");
                                                } catch (SQLException e) {
                                                    System.out.println("adh updat err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("adh updat err2" + E.getMessage());
                                                }
                                                try {
                                                    Connection condb3 = connexion.connectdb();
                                                    int nb = nbrAdhEmprunt + 1;
                                                    String sqlLivre = "UPDATE `adh` SET `NombreEmprunte` = '" + nb + "' WHERE NumeroAdh = '" + numero + "'";
                                                    PreparedStatement pst44 = condb3.prepareStatement(sqlLivre);
                                                    pst44.execute();
                                                    System.out.println("UPDATE LIVRE");
                                                } catch (SQLException e) {
                                                    System.out.println("livre updat err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("livre updat err2" + E.getMessage());
                                                }

                                            } else {
                                                System.out.println("vous avez deja emprunter 3");
                                            }
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("hna erreur2" + e.getMessage());
                                        e.printStackTrace();
                                    } catch (Exception E) {
                                        System.out.println("hna erreur 3" + E.getMessage());
                                    }
                                } else {

                                    System.out.println("rupture de stock");
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else {

                        System.out.println("livre n'existe pas");
                    }
                } catch (SQLException e) {
                    System.out.println("hna erreur1"+e.getMessage());
                    e.printStackTrace();
                }catch (Exception E){
                    System.out.println("hna erreur 4"+E.getMessage());
                }

                break;
            case 2 :

                System.out.println("Veuillez saisir le nom du doc :");
                String nomDoc = scanner.nextLine();


                try {
                    Connection conn = connexion.connectdb();
                    String rq = "SELECT * FROM document WHERE nomDoc= '"+nomDoc+"'";
                    PreparedStatement ps = conn.prepareStatement(rq);
                    ResultSet rs = ps.executeQuery(rq);
                    if (rs.next()) {
                        id = rs.getInt("idDoc");
                        nbrExemplaire=rs.getInt("nbrExemplaire");
                        nbrExemplaireEmprunt=rs.getInt("nbrExemplaireEmprunter");
                        try {
                            String sqlAdh11 = "select * from emprunt WHERE adh ='"+numero+"'AND livre='"+id+"' AND rendu='0'";
                            Connection condb145 = connexion.connectdb();
                            PreparedStatement pst34 = condb145.prepareStatement(sqlAdh11);
                            ResultSet rst34 = pst34.executeQuery(sqlAdh11);
                            if (rst34.next()) {
                                System.out.println("vous avez deja ce document");
                            }else {
                                if (nbrExemplaire > nbrExemplaireEmprunt) {
                                    String rqt = "SELECT * FROM adh WHERE NumeroAdh= '" + numero + "' AND nom='" + nom + "'";
                                    try {
                                        Connection condb = connexion.connectdb();
                                        PreparedStatement pst1 = condb.prepareStatement(rqt);
                                        ResultSet rst1 = pst1.executeQuery(rqt);
                                        if (rst1.next()) {
                                            nbrAdhEmprunt = rst1.getInt("NombreEmprunte");
                                            if (nbrAdhEmprunt < 3) {
                                                try {
                                                    Connection condb1 = connexion.connectdb();
                                                    String sqlEmprunt = "INSERT INTO emprunt (`document`, `dateEmprunt`, `DateFinEmprunt`, `adh`,`rendu`) VALUES ('" + id + "', Date(now()), Date(now())+3,'" + numero + "',0)";
                                                    PreparedStatement pst11 = condb1.prepareStatement(sqlEmprunt);
                                                    pst11.execute();
                                                    System.out.println("emprunt doc executer");
                                                } catch (SQLException e) {
                                                    System.out.println("emprt insert err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("emprt insert err2" + E.getMessage());
                                                }
                                                try {
                                                    Connection condb2 = connexion.connectdb();
                                                    int nb2 = nbrExemplaireEmprunt + 1;
                                                    String sqlAdh = "UPDATE `document` SET `nbrExemplaireEmprunter` = '" + nb2 + "' WHERE idDoc = '" + id + "'";
                                                    PreparedStatement pst33 = condb2.prepareStatement(sqlAdh);
                                                    pst33.execute();
                                                    System.out.println("update ADH");
                                                } catch (SQLException e) {
                                                    System.out.println("adh updat err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("adh updat err2" + E.getMessage());
                                                }
                                                try {
                                                    Connection condb3 = connexion.connectdb();
                                                    int nb = nbrAdhEmprunt + 1;
                                                    String sqlLivre = "UPDATE `adh` SET `NombreEmprunte` = '" + nb + "' WHERE NumeroAdh = '" + numero + "'";
                                                    PreparedStatement pst44 = condb3.prepareStatement(sqlLivre);
                                                    pst44.execute();
                                                    System.out.println("UPDATE doc");
                                                } catch (SQLException e) {
                                                    System.out.println("doc updat err1" + e.getMessage());
                                                    e.printStackTrace();
                                                } catch (Exception E) {
                                                    System.out.println("doc updat err2" + E.getMessage());
                                                }

                                            } else {
                                                System.out.println("vous avez deja emprunter 3");
                                            }
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("hna erreur2" + e.getMessage());
                                        e.printStackTrace();
                                    } catch (Exception E) {
                                        System.out.println("hna erreur 3" + E.getMessage());
                                    }
                                } else {

                                    System.out.println("rupture de stock");
                                }
                            }
                        }catch (Exception E){
                            E.printStackTrace();
                        }
                    }else {

                        System.out.println("doc n'existe pas");
                    }
                } catch (SQLException e) {
                    System.out.println("hna erreur1"+e.getMessage());
                    e.printStackTrace();
                }catch (Exception E){
                    System.out.println("hna erreur 4"+E.getMessage());
                }
                break;
        }


    }
    public  void rendre(String numero,String nom) throws SQLException {
        System.out.print("vous voulez rendre  un:\n");
        System.out.println("1: - livre");
        System.out.println("2: - doc");
        int selection = scan.nextInt();

        switch (selection) {
            case 1:

                System.out.println("Veuillez saisir le titre du livre :");
                String titre = scanner.nextLine();
                System.out.println("Veuillez saisir prenom editeur:");
                String prenomEditeur = scanner.nextLine();
                System.out.println("Veuillez saisir nom editeur:");
                String nomEditeur = scanner.nextLine();

                int id=0;
                try {
                    Connection conn = connexion.connectdb();
                    String reqq = "SELECT * FROM livre WHERE nomEditeur= '"+nomEditeur+"' AND prenomEditeur='"+prenomEditeur+"'AND titre='"+titre+"'";
                    PreparedStatement ps = conn.prepareStatement(reqq);
                    ResultSet rs = ps.executeQuery(reqq);
                    if (rs.next()) {
                        id = rs.getInt("idLivre");
                        nbrExemplaire=rs.getInt("nbrExemplaire");
                        nbrExemplaireEmprunt=rs.getInt("nbrExemplaireEmprunter");

                        try {
                            String sqlAdh11 = "select  * from emprunt WHERE adh ='"+numero+"'AND livre='"+id+"' AND `rendu` = '0' ";
                            Connection condb1 = connexion.connectdb();
                            PreparedStatement pst34 = condb1.prepareStatement(sqlAdh11);
                            ResultSet rst34 = pst34.executeQuery(sqlAdh11);
                            if (rst34.next()) {
                                Date dateFin = rst34.getDate("DateFinEmprunt");
                                if(nbrExemplaire > nbrExemplaireEmprunt){
                                    String rqt = "SELECT * FROM adh WHERE NumeroAdh= '"+numero+"' AND nom='"+nom+"'";
                                    try {
                                        Connection condb = connexion.connectdb();
                                        PreparedStatement pst1 = condb.prepareStatement(rqt);
                                        ResultSet rst1 = pst1.executeQuery(rqt);
                                        if (rst1.next()) {
                                            nbrAdhEmprunt=rst1.getInt("NombreEmprunte");
                                            int pen = rst1.getInt("penalite");
                                            if (nbrAdhEmprunt<3){
                                                try {
                                                    Connection condb12 = connexion.connectdb();
                                                    String sqlEmprunt = "UPDATE `emprunt` SET `rendu` = '1' WHERE adh ='"+numero+"'AND livre='"+id+"'";
                                                    PreparedStatement pst11 = condb12.prepareStatement(sqlEmprunt);
                                                    pst11.execute();
                                                    System.out.println("update emprunt");
                                                }catch (SQLException e) {
                                                    System.out.println("emprt insert err1"+e.getMessage());
                                                    e.printStackTrace();
                                                }catch (Exception E){
                                                    System.out.println("emprt insert err2"+E.getMessage());
                                                }
                                                try {

                                                    Connection condb2 = connexion.connectdb();
                                                    int nb2=nbrExemplaireEmprunt-1;
                                                    String sqlAdh = "UPDATE `livre` SET `nbrExemplaireEmprunter` = '"+nb2+"' WHERE idLivre = '"+id+"'";
                                                    PreparedStatement pst33 = condb2.prepareStatement(sqlAdh);
                                                    pst33.execute();
                                                    System.out.println("update ADH");
                                                }catch (SQLException e) {
                                                    System.out.println("adh updat err1"+e.getMessage());
                                                    e.printStackTrace();
                                                }catch (Exception E){
                                                    System.out.println("adh updat err2"+E.getMessage());
                                                }
                                                try {
                                                    int nb = nbrAdhEmprunt - 1;
                                                    if(new Date().before(dateFin) || new Date().equals(dateFin) ) {
                                                        try {
                                                            Connection condb3 = connexion.connectdb();
                                                            String sqlLivre = "UPDATE `adh` SET `NombreEmprunte` = '" + nb + "' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst44 = condb3.prepareStatement(sqlLivre);
                                                            pst44.execute();
                                                            System.out.println("UPDATE livre");
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                    }else  if(new Date().after(dateFin) ){
                                                         nb2=nb2+1;
                                                        try {
                                                            Connection condb56 = connexion.connectdb();
                                                            String mm = "UPDATE `adh` SET `NombreEmprunte` = '" + nb +"' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst447 = condb56.prepareStatement(mm);
                                                            pst447.execute();
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                        try {
                                                            Connection condb56 = connexion.connectdb();
                                                            String mm = "UPDATE `adh` SET `penalite` = '" + nb2 +"' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst447 = condb56.prepareStatement(mm);
                                                            pst447.execute();
                                                            System.out.println("rendre avec penalite  livre");
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                    }

                                                } catch (Exception E){
                                                    System.out.println("doc updat err2"+E.getMessage());
                                                }

                                            }
                                            else {
                                                System.out.println("vous avez deja emprunter 3");
                                            }
                                        }
                                    }catch (SQLException e) {
                                        System.out.println("hna erreur2"+e.getMessage());
                                        e.printStackTrace();
                                    }catch (Exception E){
                                        System.out.println("hna erreur 3"+E.getMessage());
                                    }
                                }else {

                                    System.out.println("rupture de stock");
                                }

                            }
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }else {

                        System.out.println("livre n'existe pas");
                    }
                } catch (SQLException e) {
                    System.out.println("hna erreur1"+e.getMessage());
                    e.printStackTrace();
                }catch (Exception E){
                    System.out.println("hna erreur 4"+E.getMessage());
                }

                break;
            case 2 :

                System.out.println("Veuillez saisir le nom du doc :");
                String nomDoc = scanner.nextLine();


                try {

                    Connection conn = connexion.connectdb();
                    String rq = "SELECT * FROM document WHERE nomDoc= '"+nomDoc+"'";
                    PreparedStatement ps = conn.prepareStatement(rq);
                    ResultSet rs = ps.executeQuery(rq);
                    if (rs.next()) {
                        id = rs.getInt("idDoc");
                        nbrExemplaire=rs.getInt("nbrExemplaire");
                        nbrExemplaireEmprunt=rs.getInt("nbrExemplaireEmprunter");
                        try {
                            String sqlAdh11 = "select  * from emprunt WHERE adh ='"+numero+"'AND document='"+id+"'AND `rendu` = '0' ";
                            Connection condb1 = connexion.connectdb();
                            PreparedStatement pst34 = condb1.prepareStatement(sqlAdh11);
                            ResultSet rst34 = pst34.executeQuery(sqlAdh11);
                            if (rst34.next()) {
                               Date dateFin = rst34.getDate("DateFinEmprunt");
                                if(nbrExemplaire > nbrExemplaireEmprunt){
                                    String rqt = "SELECT * FROM adh WHERE NumeroAdh= '"+numero+"' AND nom='"+nom+"'";
                                    try {
                                        Connection condb = connexion.connectdb();
                                        PreparedStatement pst1 = condb.prepareStatement(rqt);
                                        ResultSet rst1 = pst1.executeQuery(rqt);
                                        if (rst1.next()) {
                                            nbrAdhEmprunt=rst1.getInt("NombreEmprunte");
                                            int pen = rst1.getInt("penalite");
                                            if (nbrAdhEmprunt<3){
                                                try {
                                                    Connection condb12 = connexion.connectdb();
                                                    String sqlEmprunt = "UPDATE `emprunt` SET `rendu` = '1' WHERE adh ='"+numero+"'AND document='"+id+"'";
                                                    PreparedStatement pst11 = condb12.prepareStatement(sqlEmprunt);
                                                    pst11.execute();
                                                    System.out.println("update info emprunt");
                                                }catch (SQLException e) {
                                                    System.out.println("emprt insert err1"+e.getMessage());
                                                    e.printStackTrace();
                                                }catch (Exception E){
                                                    System.out.println("emprt insert err2"+E.getMessage());
                                                }
                                                try {

                                                    Connection condb2 = connexion.connectdb();
                                                    int nb2=nbrExemplaireEmprunt-1;
                                                    String sqlAdh = "UPDATE `document` SET `nbrExemplaireEmprunter` = '"+nb2+"' WHERE idDoc = '"+id+"'";
                                                    PreparedStatement pst33 = condb2.prepareStatement(sqlAdh);
                                                    pst33.execute();
                                                }catch (SQLException e) {
                                                    System.out.println("adh updat err1"+e.getMessage());
                                                    e.printStackTrace();
                                                }catch (Exception E){
                                                    System.out.println("adh updat err2"+E.getMessage());
                                                }
                                                try {
                                                    int nb = nbrAdhEmprunt - 1;
                                                    if(new Date().before(dateFin)  || new Date().equals(dateFin) ) {
                                                        try {
                                                            Connection condb3 = connexion.connectdb();
                                                            String sqlLivre = "UPDATE `adh` SET `NombreEmprunte` = '" + nb + "' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst44 = condb3.prepareStatement(sqlLivre);
                                                            pst44.execute();
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }

                                                    }else  if(new Date().after(dateFin) ){
                                                        nb2=nb2+1;
                                                        try {
                                                            Connection condb56 = connexion.connectdb();
                                                            String mm = "UPDATE `adh` SET `NombreEmprunte` = '" + nb +"' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst447 = condb56.prepareStatement(mm);
                                                            pst447.execute();
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                        try {
                                                            Connection condb56 = connexion.connectdb();
                                                            String mm = "UPDATE `adh` SET `penalite` = '" + nb2 +"' WHERE NumeroAdh = '" + numero + "'";
                                                            PreparedStatement pst447 = condb56.prepareStatement(mm);
                                                            pst447.execute();
                                                            System.out.println("rendre avec penalite doc");
                                                        }catch (Exception e){
                                                            e.printStackTrace();
                                                        }
                                                    }

                                                } catch (Exception E){
                                                    System.out.println("doc updat err2"+E.getMessage());
                                                }

                                            }
                                            else {
                                                System.out.println("vous avez deja emprunter 3");
                                            }
                                        }
                                    }catch (SQLException e) {
                                        System.out.println("hna erreur2"+e.getMessage());
                                        e.printStackTrace();
                                    }catch (Exception E){
                                        System.out.println("hna erreur 3"+E.getMessage());
                                    }
                                }else {

                                    System.out.println("rupture de stock");
                                }

                            }
                        }catch (SQLException e){
                            e.printStackTrace();
                        }

                    }else {

                        System.out.println("doc n'existe pas");
                    }
                } catch (SQLException e) {
                    System.out.println("hna erreur1"+e.getMessage());
                    e.printStackTrace();
                }catch (Exception E){
                    System.out.println("hna erreur 4"+E.getMessage());
                }
                break;
        }


    }




    public Adh() {
    }

    public long getNumeroAdh() {
        return NumeroAdh;
    }

    public void setNumeroAdh(long numeroAdh) {
        NumeroAdh = numeroAdh;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(long emprunt) {
        this.emprunt = emprunt;
    }

    public long getNombreEmprunte() {
        return NombreEmprunte;
    }

    public void setNombreEmprunte(long nombreEmprunte) {
        NombreEmprunte = nombreEmprunte;
    }
}
