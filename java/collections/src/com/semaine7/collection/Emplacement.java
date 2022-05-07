package com.semaine7.collection;

public abstract class Emplacement {
    
    private static int cptEmp = 0;
    private String nomDemandeur;
    private String code;
    private String adresse;
    
    public Emplacement(String adresse, String nomDemandeur){
        cptEmp++;
        this.nomDemandeur = nomDemandeur;
        this.adresse = adresse;
        this.code = cptEmp + this.nomDemandeur.substring(0, 3);
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return  this.code +
                " : " + this.nomDemandeur + 
                " : " + adresse ;
    }
    
    public abstract double occupation();
}
