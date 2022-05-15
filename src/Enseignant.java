import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Enseignant extends Adh {
    private String departement;
    private String email;
    private long DureeMax;
    private long emprunt;
    private long idEnseignant;


    @Override
    public void emprunter(Exemplaire exemplaire) {

    }

    @Override
    public void rendre(Exemplaire exemplaire) {

    }

    @Override
    public void resever(Exemplaire exemplaire) {

    }

    @Override
    public void CalculPenalite() {

    }

    @Override
    public void suppEtudiant(Etudiant etudiant) {

    }

    @Override
    public void ajoutEtudiant(Etudiant etudiant) {
        boolean res = false;
        int r = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez saisir le nom de l'etudiant :");
            String nom = scanner.nextLine();

            System.out.println("Veuillez saisir le prenome l'etudiant:");
            String  prenom = scanner.nextLine();


            Scanner scanner = new Scanner(System.in);
            Connection cnx = connexion.connectdb();
            String SQL = "INSERT INTO adh(nom,prenom,email) VALUES(?, ?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) cnx.prepareStatement(SQL);
            pstmt.setString(1,etudiant.nom);
            pstmt.setString(2, String.valueOf(etudiant.prenom));
            pstmt.setString(3, String.valueOf(etudiant.penalite));
            /*pstmt.setString(4,etudiant.NumeroAdh);
            pstmt.setString(5,etudiant.nom);
            pstmt.setString(6,etudiant.prenom);
            pstmt.setString(7,etudiant.NombreEmprunte);
            pstmt.setString(8,etudiant.DureeMax);
            pstmt.setString(9,etudiant.emprunt);*/
            r = pstmt.executeUpdate();
            if(r==1)
                res=true;


        } catch (SQLException ex) {
            System.out.println("prob d'ajout a la bdd");
            System.out.println(ex.getMessage());
        }

    }


    public void ajoutExamplaire(Etudiant etudiant) {

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

    public Enseignant(long numeroAdh, String nom, String prenom, String email, long dureeMax, long emprunt, long nombreEmprunte, String departement, String email1, long dureeMax1, long emprunt1, long idEnseignant) {
        super(numeroAdh, nom, prenom, email, dureeMax, emprunt, nombreEmprunte);
        this.departement = departement;
        this.email = email1;
        DureeMax = dureeMax1;
        this.emprunt = emprunt1;
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
