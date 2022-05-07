package com.semaine7.collection;

import com.semaine7.collection.exceptions.ErreurDimensionException;
import com.semaine7.collection.exceptions.ErreurSurfaceException;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try{
            
            Emplacement terrasse1 = new Terrasse("Taounate",
                    "Abde Nassar", 10.5);
            Emplacement terrasse2 = new Terrasse("Fes",
                                "Solayman", 9.5);
            Emplacement etalage1 = new Etalage("Casblanca",
                                "AbdeLah", 6.5, 3.4, 9.20);
            
            ServiceEmplacements serviceEmplacements = new ServiceEmplacements();
            
            serviceEmplacements.ajouter(terrasse1);
            serviceEmplacements.ajouter(terrasse2);
            serviceEmplacements.ajouter(etalage1);

            List<Emplacement> emplacements = new ArrayList<Emplacement>();
            
            emplacements = serviceEmplacements.toutLesEmplacement();
            
            for(Emplacement emplacement : emplacements) {
                System.out.println(emplacement.toString());
            }
            
        }catch(ErreurDimensionException exDim) {
            System.out.println(exDim.getMessage());
        }catch (ErreurSurfaceException exSur){
            System.out.println(exSur.getMessage());
        }
    }
}
