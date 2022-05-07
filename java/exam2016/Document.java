package com.rmi.exam2016;

import java.util.Date;

public class Document {
    private int idPapier;
    private String refPapier;
    private String typePapier;
    private Date finValidite;
    private int idVeh;

    public Document(int idPapier, String refPapier, String typePapier, Date finValidite, int idVeh) {
        this.idPapier = idPapier;
        this.refPapier = refPapier;
        this.typePapier = typePapier;
        this.finValidite = finValidite;
        this.idVeh = idVeh;
    }
}
