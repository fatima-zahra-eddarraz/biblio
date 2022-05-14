import java.io.IOException;

public abstract class Adh {

    private long NumeroAdh;
    private String nom;
    private String prenom;
    private String email;
    private long DureeMax;
    private long emprunt;
    private long NombreEmprunte;

    public abstract void emprunter(Exemplaire exemplaire);

    public abstract void rendre(Exemplaire exemplaire);

    public abstract void resever(Exemplaire exemplaire);
    public abstract void CalculPenalite();
    public abstract void suppEtudiant(Etudiant etudiant);
    public abstract void ajoutEtudiant(Etudiant etudiant);





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

    public long getNombreEmprunte() {
        return NombreEmprunte;
    }

    public void setNombreEmprunte(long nombreEmprunte) {
        NombreEmprunte = nombreEmprunte;
    }

    public Adh(long numeroAdh, String nom, String prenom, String email, long dureeMax, long emprunt, long nombreEmprunte) {
        NumeroAdh = numeroAdh;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        DureeMax = dureeMax;
        this.emprunt = emprunt;
        NombreEmprunte = nombreEmprunte;

    }

























}
