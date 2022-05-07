package com.exam2021.socket;

import com.examen2021.rmi.Etudiant;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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
