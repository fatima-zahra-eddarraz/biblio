import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class Etudiant extends Adh{

    private String adresse;
    private Date dateFin;
    private int penalite;



    public void emprunter() {

    }


    public void rendre() {

    }


    public void resever() {

    }

    public void CalculPenalite() {

    }

    public void suppEtudiant() {

    }
    public void ajoutEtudiant(){




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



    @Override
    public String toString() {
        return "Etudiant{" +
                "adresse='" + adresse + '\'' +
                ", dateFin=" + dateFin +
                ", penalite=" + penalite +
                '}';
    }





}
