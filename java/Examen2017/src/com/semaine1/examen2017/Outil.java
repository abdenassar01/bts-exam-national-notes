package com.semaine1.examen2017;

import com.semaine1.examen2017.Exeptions.ErreurPrix;

public class Outil extends Solution{
    private String libelle;
    private int nbrLiecence;

    public Outil(String code, double prix, String libelle, int nbrLiecence) throws ErreurPrix {
        super(code, prix);
        this.libelle = libelle;
        this.nbrLiecence = nbrLiecence;
    }

    @Override
    public double montant() {
        double montant = this.getPrix() * this.nbrLiecence;
        if(this.nbrLiecence >= 10 ) {
            montant *= 0.9;
        }
        return montant;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Libelle: " + this.libelle
                + ", Nombre De Licence: " + this.nbrLiecence;
    }
}
