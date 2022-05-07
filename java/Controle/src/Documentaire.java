import java.util.Date;

public class Documentaire extends Emission{
    
    public String theme;

    public Documentaire(String titre, String duree, Date dateEm, String theme) {
        super(titre, duree, dateEm);
        this.theme = theme;
    }

    @Override
    public String getInfo() {
        return super.toString() + "\nTheme: " + this.theme ;
    }
}
