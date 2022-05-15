import java.sql.*;
import java.util.Scanner;

public class Livre extends Exemplaire{

    private String idLivre;
    private String nomEditeur;
    private String prenomEditeur;
    private String titre;
    private boolean reserver;
    private String nbrExemplaire;

    public String getNbrExemplaire() {
        return nbrExemplaire;
    }

    public void setNbrExemplaire(String nbrExemplaire) {
        this.nbrExemplaire = nbrExemplaire;
    }

    PreparedStatement pst =null;
    Connection cnx=null;
    static Statement st;
    static ResultSet rst;

    public Livre(boolean disponible) {
        super(disponible);
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



    public boolean isReserver() {
        return reserver;
    }

    public void setReserver(boolean reserver) {
        this.reserver = reserver;
    }

    public void ajouterLivre() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir nom editeur :");
        nomEditeur = scan.nextLine();

        System.out.println("Veuillez saisir prenom editeur:");
        prenomEditeur = scan.nextLine();
        System.out.println("Veuillez saisir titre du livre:");
        titre = scan.nextLine();
        System.out.println("Veuillez saisir nombre de copie :");
        nbrExemplaire = scan.nextLine();
        Connection cn =connexion.connectdb();
        st=cn.createStatement();
        String rq = "SELECT * FROM livre WHERE nomEditeur= '"+nomEditeur+"' AND prenomEditeur='"+prenomEditeur+"'AND titre='"+titre+"'";
        try {
            pst = cn.prepareStatement(rq);
            rst = pst.executeQuery(rq);
            if (rst.next()) {
                System.out.println("livre existe");
            }else {
                String sql = "INSERT INTO `livre` (`nomEditeur`, `prenomEditeur`, `titre`, `exemplaire`,`reserver`,`nbrExemplaire`,`nbrExemplaireEmprunter`) VALUES ('"+nomEditeur+"', '"+prenomEditeur+"', '"+titre+"', 1,0,'"+nbrExemplaire+"',0)";
                pst = cn.prepareStatement(sql);
                pst.execute();
                System.out.println("livre enregistrer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void supLivre() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir nom editeur :");
        nomEditeur = scan.nextLine();

        System.out.println("Veuillez saisir prenom editeur:");
        prenomEditeur = scan.nextLine();
        System.out.println("Veuillez saisir titre du livre:");
        titre = scan.nextLine();

        Connection cn =connexion.connectdb();
        st=cn.createStatement();
        String rq = "SELECT * FROM livre WHERE nomEditeur= '"+nomEditeur+"' AND prenomEditeur='"+prenomEditeur+"'AND titre='"+titre+"'";
        try {
            pst = cn.prepareStatement(rq);
            rst = pst.executeQuery(rq);
            if (rst.next()) {
                String sql = "DELETE FROM `livre` WHERE nomEditeur= '"+nomEditeur+"' AND prenomEditeur='"+prenomEditeur+"'AND titre='"+titre+"'";
                pst = cn.prepareStatement(sql);
                pst.execute();
                System.out.println("livre supprimer");
            }else {
                System.out.println("livre N'existe");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
