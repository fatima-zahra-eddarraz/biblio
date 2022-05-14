public class Livre extends Exemplaire{

    private String idLivre;
    private String nomEditeur;
    private String prenomEditeur;
    private String titre;

    public Livre(long idExemplaire, boolean disponible) {
        super(idExemplaire, disponible);
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getPrenomEditeur() {
        return prenomEditeur;
    }

    public void setPrenomEditeur(String prenomEditeur) {
        this.prenomEditeur = prenomEditeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }



}
