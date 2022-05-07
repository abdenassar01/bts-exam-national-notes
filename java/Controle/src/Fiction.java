import java.util.Date;

public class Fiction extends Emission{
    
    private String realisateur;
    private String producteur;

    public Fiction(String titre, String duree, Date dateEm, String realisateur, String producteur) {
        super(titre, duree, dateEm);
        this.realisateur = realisateur;
        this.producteur = producteur;
    }


    @Override
    public String getInfo() {
        return super.toString() 
                    + "\n Realisateur: " + this.realisateur
                    + "\n Producteur: " + this.producteur;
    }
}
