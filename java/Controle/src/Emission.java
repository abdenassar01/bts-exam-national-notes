import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Emission implements Comparable{
    
    private String titre;
    private String duree;
    private Date dateEm;

    public Emission(String titre, String duree, Date dateEm) {
        this.titre = titre;
        this.duree = duree;
        this.dateEm = dateEm;
    }

    public Emission(String titre, String duree) {
        this.titre = titre;
        this.duree = duree;
    }

    public Date getDate() {
        return dateEm;
    }
    
    public abstract String getInfo();

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return "Titre: " + this.titre + ", la duree: " 
                         + this.duree + ", Date d'emission"
                         + sdf.format(this.dateEm);
    }
    
    public int compareTo(Object obj){
        Emission e = (Emission) obj;
        
        if(e.dateEm.before(this.dateEm)) {
            return -1;
        }
        else if(e.dateEm.equals(this.dateEm)) {
            return 0;
        }
        return 1;
    }
    
}
