package com.semaine1.examen2017.Exeptions;

public class ErreurPrix extends Exception{
    
    public ErreurPrix(String msg){
        System.out.println(msg);
    }
}
