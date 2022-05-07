package com.semaine7.collection.exceptions;

public class ErreurSurfaceException extends Exception{
    
    public ErreurSurfaceException(double surface){
        System.out.println("erreur de surface de terrasse: " + surface);
    }
}
