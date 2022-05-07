package com.collections.tp2;

public class ClientFidel extends Client{
    
    private String codeFidel;
    private float tauxReduction;

    public ClientFidel(String codeClient, String nomClient, String adrClient, String codeFidel, float tauxReduction) {
        super(codeClient, nomClient, adrClient);
        this.codeFidel = codeFidel;
        this.tauxReduction = tauxReduction;
    }

    @Override
    public String toString() {
        return "ClientFidel{" +
                "codeFidel='" + codeFidel + '\'' +
                ", tauxReduction=" + tauxReduction + "\n" + super.toString() + 
                '}';
    }
}
