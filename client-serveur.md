# Client-Serveur

## JDBC
#

- _execute un requette de selection_

```
    Connection conn = null;

    public Connection getConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://server_name/db_name", "username", "password");
            return conn;
        }catch(Exception e){
            return null;
        }
    }
````

- _executer une requette utilisant prepared statement_

```
 public ResultSet afficherEtudiant(String nom){
       try{
            PreparedStatement ps = 
                        conn.prepareStatement("SELECT * FROM Etudiant WHERE nom = ?");
            ps.setString(1, nom);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
       }catch(Exception e){
           return null;
       }
    }
```

- _transferer un ResultSet vers ArrayList_

```
public ArrayList<Etudiant> toArrayList(ResultSet rs){
        try{
            ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
            while(rs.next()){
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getDate("dateNais")));
            }
            
            return etudiants;
        }catch(Exception e){
            return null;
        }
    }
```

- _requette de modifications (update, delete, insert)_

```
public boolean modifierEtudiant(int id, String nom, Date dateNais){
    try{
        PreparedStatement ps = conn.prepareStatement("UPDATE Etudiant SET nom = ?, dateNais = ? WHERE id = ?");
        ps.setString(1, nom);
        ps.setDate(2, dateNais);
        ps.setInt(3, id);

        ps.executeUpdate();

        return true;
    }catch(Exception e){
        return false;
    }
}
```


## RMI
#

- _**declarer un l'interface qui contient les methodes**_

```
public interface IntObjectDistant extends Remote {
    
    ArrayList<Vehicule> vehDisponible() throws RemoteException;
    ArrayList<Document> invalidDocs() throws RemoteException;
}
```

- _**declarer un class qui implimenter cet interface**_

```
public class ObjetDistant extends UnicastRemoteObject implements IntObjectDistant{
    //constructeur par deafault nicessaire
    public ObjetDistant() throws RemoteException{}

    @Override
    public ArrayList<Vehicule> vehDisponible() throws RemoteException {
        //traitement
        return new ArrayList<Vehicule>();
    }

    @Override
    ArrayList<Document> invalidDocs() throws RemoteException{
        //traitement
        return new ArrayList<Document>();
    }
}
```

- _**class serveur qui demarer registry instancier l'object Distinct et enregistrer cet object dans registry**_

```
public class Serveur {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            ObjetDistant objetDistant = new ObjetDistant();
            Naming.rebind("rmi://NomServeur:1099/NOBJ", objetDistant);

        }catch(Exception exception){
            System.out.println("Erreur: " + exception.toString());
        }
    }
}
```

- _**class client qui recherche l'object dans registry fait l'appel a les methodes**_

```
public class Client {
    ObjetDistant obj;
    JList list;

    public static void main(String[] args){
        Remote remote = Naming.lookup("rmi://NomServeur:1099/NOBJ");
        if (remote instanceof ObjetDistant){
            obj = (ObjetDistant) remote;
        }

        list.setListData(obj.vehDisponible().toArray());
    }
}
```

## Socket
#

- _**class serveur avec un methode ```startServer()``` qui start un serveur et accept la demande d'un connection avec client, instancier les objects input/output**_

```
public class Serveur {
    private ServerSocket ss=null;
    private Socket sc=null;
    private BufferedReader in = null;
    private ObjectOutputStream out= null;

    public void startServer() {
        try{
            ss = new ServerSocket(3000);
            while(true) {
                sc = ss.accept();
                in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                out = new ObjectOutputStream(sc.getOutputStream());
                while(true) {
                    int numEq = in.read();
                    if (numEq < 0){
                        break;
                    }
                    ArrayList<Etudiant> etudiants = getEtudiants(numEq);
                    for (Etudiant e : etudiants){
                        out.writeObject(e);
                        out.flush();
                    }
                }
            }
        }catch(Exception ex) { 
            ex.printStackTrace();
        }
    }
}
```

- _**client qui etablire un connection avec server, envoiyer un code et recevoire un liste des etudiants envoiye par le serveur**_

```
public class Client {
    private Socket sc;
    private PrintWriter pw;
    private ObjectInputStream in;

    public Client(String IP, int PORT) {
        try {
            this.sc = new Socket(IP, PORT);
            this.in = new ObjectInputStream(sc.getInputStream());
            this.pw = new PrintWriter(sc.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Etudiant> getListeEtudiants(int numEq) {
        ArrayList<Etudiant> etudiants  = new ArrayList<>();
        try {
            pw.write(numEq);
            Etudiant etd;
            etd = (Etudiant) in.readObject();
            
            while (etd != null){
                etudiants.add(etd);
                etd = (Etudiant) in.readObject();
            }
        }catch (Exception e){
          e.printStackTrace();
        }
        return etudiants;
    }
}
```