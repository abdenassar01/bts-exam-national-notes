package com.examen2021.rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {
    private Service ob;
    
    public Client() throws Exception {
        Remote remote = Naming.lookup("rmi://192.168.1.20/OBJ");
        
       if (remote instanceof Serveur){
           ob = (Service) remote;
       }
       
    }
    
    public ArrayList<Etudiant> get(int numEq) throws RemoteException { 
        return ob.getListeEtudiants(numEq);
    }
}
