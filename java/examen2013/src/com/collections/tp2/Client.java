package com.collections.tp2;

import java.util.Vector;

public class Client {
    
    private String codeClient; 
    private String nomClient; 
    private String adrClient; 
    private String telClient; 
    private Vector<Commande> listeCommandes;

    public Client(String codeClient, String nomClient, String adrClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adrClient = adrClient;
        listeCommandes = new Vector<>();
    }
    
    
    public boolean enregistrerCommandes(Commande cmd){
        return listeCommandes.add(cmd);
    }
    
    public boolean supprimerCommande(int index){
        return listeCommandes.remove(listeCommandes.get(index));
//        if(index > 0 && index < listeCommandes.size()){
//            listeCommandes.remove(index);
//            return true;
//        }
//        return false;
    }
    
    String str = "";
    @Override
    public String toString() {
        for(Commande cmd : listeCommandes){
            str += cmd.toString() + " \n";
        }
        return str;
    }
}
