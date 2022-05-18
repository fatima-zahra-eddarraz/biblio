import java.sql.*;
import java.util.Scanner;

public class Document extends Exemplaire{
    private long idDoc;
    private String nomDoc;
    private boolean reserver;
    private String nbrExemplaire;

    public Document(boolean disponible) {
        super(disponible);
    }
    PreparedStatement pst =null;
    Connection cnx=null;
    static Statement st;
    static ResultSet rst;
    public long getIdDoc() {
        return idDoc;
    }

    public String getNbrExemplaire() {
        return nbrExemplaire;
    }

    public void setNbrExemplaire(String nbrExemplaire) {
        this.nbrExemplaire = nbrExemplaire;
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


    @Override
    public String toString() {
        return "Document{" +
                "idDoc=" + idDoc +
                ", nomDoc='" + nomDoc + '\'' +
                '}';
    }
    public void ajouterDoc() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir nom DOCUMANT :");
        nomDoc = scan.nextLine();
        System.out.println("Veuillez saisir nombre de copie :");
        int nbrExemplaire2 = scan.nextInt();

        Connection cn =connexion.connectdb();
        st=cn.createStatement();
        String rq = "SELECT * FROM document WHERE nomDoc= '"+nomDoc+"'";
        try {
            pst = cn.prepareStatement(rq);
            rst = pst.executeQuery(rq);
            if (rst.next()) {
                int nb2=rst.getInt("nbrExemplaire")+nbrExemplaire2;
                try {
                    Connection condb2 = connexion.connectdb();
                    String sqlAdh = "UPDATE `document` SET `nbrExemplaire` = '"+nb2+"' WHERE nomDoc = '"+rst.getString("nomDoc")+"'";
                    PreparedStatement pst33 = condb2.prepareStatement(sqlAdh);
                    pst33.execute();
                    System.out.println("nombre documet augumenter");
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                String sql = "INSERT INTO document (`nomDoc`,`exemplaire`,`reserver`,`nbrExemplaire`,`nbrExemplaireEmprunter`) VALUES ('"+nomDoc+"', 1,0,'"+nbrExemplaire+"',0)";
                pst = cn.prepareStatement(sql);
                pst.execute();
                System.out.println("document enregistrer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void supDoc() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir nom DOCUMANT :");
        nomDoc = scan.nextLine();


        Connection cn =connexion.connectdb();
        st=cn.createStatement();
        String rq = "SELECT * FROM document WHERE nomDoc= '"+nomDoc+"'";
        try {
            pst = cn.prepareStatement(rq);
            rst = pst.executeQuery(rq);
            if (rst.next()) {
                String sql = "DELETE FROM document WHERE nomDoc= '"+nomDoc+"'";
                pst = cn.prepareStatement(sql);
                pst.execute();
                System.out.println("document supprimer");
            }else {
                System.out.println("Doc N'existe pas");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
