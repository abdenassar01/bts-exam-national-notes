package com.semaine1.examen2017;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Feliere {
    
    private String nom;
    private String localite;
    private String specialite;
    private Date dateCreation = null;
    private ArrayList<Solution> listeSolutions;

    public Feliere(String nom, String localite, String specialite, Date dateCreation) {
        this.nom = nom;
        this.localite = localite;
        this.specialite = specialite;
        this.dateCreation = dateCreation;
        this.listeSolutions = new ArrayList<>();
    }
    
    public boolean addSolution(Solution solution){
        return listeSolutions.add(solution);
    }
    
    public Solution delSolution(int index){
        if(index < 0 || index > listeSolutions.size()) {
            return null;
        }
        return listeSolutions.remove(index);
    } 
    
    public boolean delSolution(Object obj){
        Solution solution = (Solution) obj;
        
        return listeSolutions.remove(solution);
    }
    
    public int searchSolution(Solution s){
        return listeSolutions.indexOf(s);
    }
    
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String str = "Nom: " + this.nom + ", Date de creation: " 
                + simpleDateFormat.format(this.dateCreation);
        for(Solution solution : listeSolutions) {
            str += "\n" + solution.toString();
        }
        return str;
    }
    
    public void saveData(String nomFile) throws Exception {
        ObjectOutputStream objectOutputStream = 
                new ObjectOutputStream(
                        new FileOutputStream(
                                new File(String.format("%s.txt", nomFile)
                                )));
        for(Solution solution : listeSolutions) {
            if(solution.getPrix() > 300)
                objectOutputStream.writeObject(solution);
        }
        objectOutputStream.close();
    }

    public void saveSolutions(String nomFile) throws Exception {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(
                        new FileOutputStream(
                                new File(String.format("%s.txt", nomFile)
                                )));
        for(Solution solution : listeSolutions) {
            if(solution.getPrix() > 300)
                objectOutputStream.writeObject(solution);
        }
        objectOutputStream.close();
    }
    
    public void loadData(String nomFile) throws Exception {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new FileInputStream(
                                String.format("%s.txt", nomFile)
                                ));
        listeSolutions.clear();
        while(true) {
            try{
                listeSolutions.add((Solution) objectInputStream.readObject()); 
            }catch (Exception exception){
               break; 
            }
        }
        objectInputStream.close();
    }
    
    public ArrayList<Solution> chargerSolutions(String fineName) {
        ArrayList<Solution> liste = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fineName));
            liste = new ArrayList<>();
            Solution solution = (Solution) in.readObject();
            while(true) {
                liste.add(solution);
                solution = (Solution) in.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
}
