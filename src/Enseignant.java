import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Enseignant extends Adh {
    private String departement;
    private String email;
    private long DureeMax;
    private long emprunt;
    private long idEnseignant;



    public void rendre() {

    }

    public void resever() {

    }

    public void CalculPenalite() {

    }


    public void suppEtudiant() throws SQLException {
        System.out.println("Veuillez saisir votre NumeroAdh :");
        String nume = scan.nextLine();

        System.out.println("Veuillez saisir votre nom:");
        String  nomadhEtu = scan.nextLine();
        Connection cn =connexion.connectdb();
        st=cn.createStatement();
        String rq = "SELECT * FROM adh WHERE NumeroAdh= '"+nume+"' AND nom='"+nomadhEtu+"'";
        try {
            pst = cn.prepareStatement(rq);
            rst = pst.executeQuery(rq);
            if (rst.next()) {
                String sql = "DELETE FROM adh WHERE NumeroAdh= '"+nume+"' AND nom='"+nomadhEtu+"'";
                pst = cn.prepareStatement(sql);
                pst.execute();
                System.out.println("etudiant supprimer");
            }else {
                System.out.println("etudiant n'est pas inscrit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void ajoutEtudiant() throws SQLException {
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
        String rq = "SELECT * FROM adh WHERE NumeroAdh= '"+nume+"'";
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

    }






    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDureeMax() {
        return DureeMax;
    }

    public void setDureeMax(long dureeMax) {
        DureeMax = dureeMax;
    }

    public long getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(long emprunt) {
        this.emprunt = emprunt;
    }

    public long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }


    @Override
    public String toString() {
        return "Enseignant{" +
                "departement='" + departement + '\'' +
                ", email='" + email + '\'' +
                ", DureeMax=" + DureeMax +
                ", emprunt=" + emprunt +
                ", idEnseignant=" + idEnseignant +
                '}';
    }








}
