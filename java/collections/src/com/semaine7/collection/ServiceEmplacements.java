package com.semaine7.collection;

import java.util.ArrayList;

public class ServiceEmplacements {
    ArrayList<Emplacement> emplacements;
    public ServiceEmplacements(){
        emplacements = new ArrayList<Emplacement>();
    }
    
    public boolean exist(String code){
        for(Emplacement emplacement : emplacements) {
           if( emplacement.getCode().equals(code)) return true;  
        }
        return false;
    }
    
    public Emplacement rechercher(String code){
        for(Emplacement emplacement : emplacements) {
            if( emplacement.getCode().equals(code)) return emplacement;
        }
        return null;
    }
    
    public void ajouter(Emplacement emplacement){
        emplacements.add(emplacement);
    }
    
    public void supremer(String code){
        for(Emplacement emplacement : emplacements) {
            if( emplacement.getCode().equals(code)){
                emplacements.remove(emplacement);
            }
        }
    }
    
    public ArrayList<Emplacement> toutLesEmplacement(){
        return emplacements;
    }
}
