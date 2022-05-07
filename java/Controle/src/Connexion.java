import com.sun.source.tree.ReturnTree;

import java.sql.*;

public class Connexion {
    
    private String Driver;
    private Connection cn;
    private String URL;
    private String User;
    private String Password;
    
    public Connexion(String Driver, String URL, String User, String Password ){
        this.Driver = Driver;
        this.URL = URL;
        this.User = User;
        this.Password = Password;
    }
    
    public boolean connecter(){
        try {
            Class.forName(Driver);
            cn = DriverManager.getConnection(URL, User, Password);
            return true;
        }catch (Exception sqlException) {
            System.out.println("Connection To database failed" + sqlException.getMessage());
        }
        return false;
    }
    
    public ResultSet lire(String requete){
        try {
            Statement statement = cn.createStatement();
            ResultSet rslt =  statement.executeQuery(requete);
            return rslt;
        }catch (SQLException sqlException) {
            System.out.println("Error Executing The Query");
        }
        return null;
    }
    
    public boolean miseAjour(String requete){
        try {
            Statement statement = cn.createStatement();
            int raw = statement.executeUpdate(requete);
            if(raw == 0) {
                return false;
            }else 
                return false;
        }catch (SQLException sqlException) {
            System.out.println("Unable To Update");
        }
        return false;
    }
    
    public void getResultat(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println("Code Emission: " + resultSet.getInt(1));
        }
    }
}
