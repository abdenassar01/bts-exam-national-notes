package com.collections.tp2;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Commande commande = new Commande(1, new Date(), "Alami");
        Commande cmd = new Commande(2, new Date(), "Alaoui");
        
        
        Client client = new Client("CR112", "AbdeNassar", "Taounate");
        Client clientFedil = new ClientFidel("CF143", "AbdaLah", "Fes", "FED15", (float) 20.4);
        
        client.enregistrerCommandes(commande);
        client.enregistrerCommandes(cmd);
        System.out.println(client.toString());
        clientFedil.enregistrerCommandes(commande);
        clientFedil.enregistrerCommandes(cmd);
        System.out.println("Avant La Suppression");
        System.out.println(clientFedil.toString());
        clientFedil.supprimerCommande(0);
        System.out.println("Apres La Suppression");
        System.out.println(clientFedil.toString());
    }
}
