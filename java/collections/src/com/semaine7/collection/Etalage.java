package com.semaine7.collection;

import com.semaine7.collection.exceptions.ErreurDimensionException;

public class Etalage extends Emplacement{
    
    private double langeur ;
    private double largeur ;
    private double profondeur ;

    public Etalage(String adresse, String nom, double langeur
             , double largeur, double profondeur)throws ErreurDimensionException{
        
        super(adresse, nom);
        if(langeur <= 0 || largeur <= 0 || profondeur <= 0 )
            throw new ErreurDimensionException(langeur, largeur, profondeur);
        else {
            this.langeur = langeur;
            this.largeur = largeur;
            this.profondeur = profondeur;
        }
    }

    @Override
    public String toString() {
        
        return "Etalage: \n\t" + super.toString() +
                " : " + langeur +
                " : " + largeur +
                " : " + profondeur + 
                " : " + this.occupation();
    }

    @Override
    public double occupation() {
        return (this.largeur * this.langeur * this.profondeur);
    }
}
