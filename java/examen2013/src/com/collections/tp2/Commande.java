package com.collections.tp2;

import java.util.Date;
import java.util.Objects;

public class Commande {
    
    private int numCommande;
    private Date dateCommande;
    private String nomFournisseur;

    public Commande(int numCommande, Date dateCommande, String nomFournisseur) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.nomFournisseur = nomFournisseur;
    }

    public int getNumCommande() {
        return this.numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return numCommande == commande.numCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "numCommande=" + numCommande +
                ", dateCommande=" + dateCommande +
                ", nomFournisseur='" + nomFournisseur + '\'' +
                '}';
    }
}
