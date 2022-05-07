package com.rmi.exam2016;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.Remote;


public class Client {
    ObjetDistant obj;
    JList list;
    
    private void formWindowOpened(WindowEvent evt) throws Exception {
        Remote remote = Naming.lookup("rmi://NomServeur:1099/NOBJ");
        if (remote instanceof ObjetDistant){
            obj = (ObjetDistant) remote;
        }
    }
    
    private void GoActionPreformed(ActionEvent evt) {
        PrintWriter pw ;
        try {
            list.setListData(obj.vehDisponible().toArray());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}