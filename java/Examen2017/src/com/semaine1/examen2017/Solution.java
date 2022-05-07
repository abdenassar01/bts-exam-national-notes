package com.semaine1.examen2017;

import com.semaine1.examen2017.Exeptions.ErreurPrix;

import java.io.Serializable;

public abstract class Solution implements Serializable, Comparable {
    private String code;
    private double prix;
    
    public Solution(String code, double prix)throws ErreurPrix {
        if( prix < 0 ) {
            throw new ErreurPrix("Erreur de prix de la solution");
        }else{
            this.code = code;
            this.prix = prix;   
        }
    }
    
    public double getPrix(){
        return this.prix;
    }
    
    @Override
    public String toString(){
        return "Code: " + this.code + ", Prix: " + this.prix;
    }

    @Override
    public int compareTo(Object obj){
        if(obj instanceof Solution) {
            Solution solution = (Solution) obj;
            if(solution.getPrix() < this.getPrix()) {
                return 1;
            } else if(solution.getPrix() == this.getPrix()) {
                return 0;
            } else {
                return -1;
            }
        }
        return -1;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Solution) {
            Solution solution = (Solution) obj;
            
            return this.code.equals(solution.code);
        }
        return false;
    }
    
    public abstract double montant();
}
