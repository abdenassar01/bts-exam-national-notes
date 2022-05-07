package com.rmi.exam2016;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

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
