package com.rmi.exam2016;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ObjetDistant extends UnicastRemoteObject implements IntObjectDistant {
    
    private Connection conn;
    
    public ObjetDistant() throws RemoteException{
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://PC_Demande:1433");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Vehicule> vehDisponible() throws RemoteException {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT  * FROM VEHICULE;");
            ResultSet resultSet = stmt.executeQuery();
            ArrayList<Vehicule> vehicules = new ArrayList<>();
            Vehicule vehicule;
            while (resultSet.next()){
                vehicule = new Vehicule(
                        resultSet.getInt("idVeh"),
                        resultSet.getString("Matricule"),
                        resultSet.getDate(3)
                );
                vehicules.add(vehicule);
            }
            return vehicules;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ArrayList<Document> invalidDocs() throws RemoteException {
        try {
            PreparedStatement statement = 
                    conn.prepareStatement("SELECT * from DEMANDE ;");
            ArrayList<Document> documents = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            Date date = new Date();
            while (rs.next()){
                if (rs.getDate("finValidite").getTime() < date.getTime() + (7*24*60*60*1000)){
                    documents.add(
                            new Document(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDate(4),
                                    rs.getInt(5)
                            )
                    );
                }
            }
            return documents;
        }catch (Exception e){
            return null;
        }
    }
}
