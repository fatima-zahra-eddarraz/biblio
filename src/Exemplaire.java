public class Exemplaire {

    private long idExemplaire;
    private boolean disponible;

    public long getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(long idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Exemplaire(long idExemplaire, boolean disponible) {
        this.idExemplaire = idExemplaire;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "idExemplaire=" + idExemplaire +
                ", disponible=" + disponible +
                '}';
    }
}
