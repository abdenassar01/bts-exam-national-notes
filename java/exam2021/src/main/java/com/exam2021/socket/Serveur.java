package com.exam2021.socket;

import com.examen2021.rmi.Etudiant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
    
    public ArrayList<Etudiant> getEtudiants(int numEq) {
            // Le code source de la méthode getEtudiants est non demandé
        return new ArrayList<>();
    }
}

