public class Document extends Exemplaire{
    private long idDoc;
    private String nomDoc;

    public long getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(long idDoc) {
        this.idDoc = idDoc;
    }

    public String getNomDoc() {
        return nomDoc;
    }

    public void setNomDoc(String nomDoc) {
        this.nomDoc = nomDoc;
    }

    public Document(long idExemplaire, boolean disponible, long idDoc, String nomDoc) {
        super(idExemplaire, disponible);
        this.idDoc = idDoc;
        this.nomDoc = nomDoc;
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDoc=" + idDoc +
                ", nomDoc='" + nomDoc + '\'' +
                '}';
    }
}
