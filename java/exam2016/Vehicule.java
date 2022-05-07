package com.rmi.exam2016;

import java.util.Date;

public class Vehicule {
    
    private int id;
    private String Matricule;
    private Date dateAchat;

    public Vehicule(int id, String matricule, Date dateAchat) {
        this.id = id;
        Matricule = matricule;
        this.dateAchat = dateAchat;
    }
}
