package com.semaine7.collection;

import com.semaine7.collection.exceptions.ErreurSurfaceException;

public class Terrasse extends Emplacement{
    private double surface;
    
    public Terrasse(String adress, String nomDemandeur, double surface) throws ErreurSurfaceException {
        super(adress, nomDemandeur);
        if( surface <= 0 ) throw new ErreurSurfaceException(surface);
        else this.surface = surface;
    }

    @Override
    public String toString() {
        return "Terrasse: \n\t" + super.toString() + " : " + surface ;
    }

    @Override
    public double occupation() {
        return this.surface;
    }
}
