package com.semaine7.collection.exceptions;

public class ErreurDimensionException extends Exception{
    
    public ErreurDimensionException(double langeur, double larguer, double profonduer){
        System.out.println("erreur de dimension de l’étalage : " + langeur 
                                    + " : " + larguer + " : " + profonduer);
    }
}
