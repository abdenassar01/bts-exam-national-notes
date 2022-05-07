package com.examen2021.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Serveur extends UnicastRemoteObject implements Service {
    public Serveur() throws RemoteException {}
    
    @Override
    public ArrayList<Etudiant> getListeEtudiants(int numEq) throws RemoteException {
        return getEtudiants(numEq);
    }
    
        public ArrayList<Etudiant> getEtudiants(int numEq) { 
            return new ArrayList<>();
        }

        public static void main(String [] args) throws Exception{
            LocateRegistry.createRegistry(1099);
            Serveur obj = new Serveur();

            Naming.rebind("rmi://192.168.1.20/OBJ", obj);
        }
    }