package com.examen2021.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Service extends Remote{
    ArrayList<Etudiant> getListeEtudiants(int numEq) throws RemoteException;
}
