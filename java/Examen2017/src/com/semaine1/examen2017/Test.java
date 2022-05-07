package com.semaine1.examen2017;

import com.semaine1.examen2017.Exeptions.ErreurPrix;

import java.util.ArrayList;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Feliere feliere =
                new Feliere("Feliere", "Taounate", "JAVA", new Date());

        try {
            Service solution = new Service("AS61", 318.2, "Java", 5);
            feliere.addSolution(solution);
            feliere.addSolution(new Service("GHT2", 512.2, "PHP", 7));
            feliere.addSolution(new Service("AS61", 299.5, "VB.NET", 3));
            feliere.addSolution(new Outil("CDO15", 422, "EXCEPTION", 12));
            feliere.addSolution(new Outil("GFA32", 172, "FILE", 11));
            feliere.addSolution(new Outil("CDR45", 515.6, "FLUX", 20));

            System.out.println( "the index of solution is: " + feliere.searchSolution(solution));
            
            System.out.println("Avant la Modification: ");
            System.out.println(feliere.toString());
            feliere.delSolution(1);
            feliere.delSolution(new Outil("CDR45", 515.6, "FLUX", 20));
            System.out.println("Apres la Suppression de deux Objects: ");
            System.out.println(feliere.toString());
            
            feliere.saveData("solution");
//            feliere.loadData("solution");
            System.out.println("Using Charger Data");
            ArrayList<Solution> list = feliere.chargerSolutions("solution.txt");
            for (Solution s: list) {
                System.out.println(s.toString());
            }
//            System.out.println();
//            System.out.println();
//            System.out.println("Apres le chargement des donner\n");
//            System.out.println(feliere.toString());
        }catch (ErreurPrix err) {
            err.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
