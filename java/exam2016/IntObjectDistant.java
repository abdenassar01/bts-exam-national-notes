package com.rmi.exam2016;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IntObjectDistant extends Remote {
    
    ArrayList<Vehicule> vehDisponible() throws RemoteException;
    ArrayList<Document> invalidDocs() throws RemoteException;
}
