package com.semaine1.examen2017;

import com.semaine1.examen2017.Exeptions.ErreurPrix;

public class Service extends Solution{
    
    private String disgnation;
    private int durreAnnee;

    public Service(String code, double prix, String designation, int durreAnnee) throws ErreurPrix {
        super(code, prix);
        this.disgnation = designation;
        this.durreAnnee = durreAnnee;
    }

    @Override
    public double montant() {
        double montant = this.getPrix() * this.durreAnnee;
        if(this.durreAnnee >= 3 ) {
            montant *= 0.8;
        }
        return montant;
    }

    @Override
    public String toString() {
        return super.toString() 
                + ", Designation: " + this.disgnation 
                + ", Durre (annee): " + this.durreAnnee;
    }
}
