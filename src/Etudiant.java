import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Etudiant extends Adh{

    private String adresse;
    private Date dateFin;
    private int penalite;

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
    public void ajoutEtudiant(Etudiant etudiant){




    }














    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }

    public Etudiant(long numeroAdh, String nom, String prenom, String email, long dureeMax, long emprunt, long nombreEmprunte, String adresse, Date dateFin, int penalite) {
        super(numeroAdh, nom, prenom, email, dureeMax, emprunt, nombreEmprunte);
        this.adresse = adresse;
        this.dateFin = dateFin;
        this.penalite = penalite;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "adresse='" + adresse + '\'' +
                ", dateFin=" + dateFin +
                ", penalite=" + penalite +
                '}';
    }





}
