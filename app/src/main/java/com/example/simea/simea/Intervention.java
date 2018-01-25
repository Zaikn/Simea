package com.example.simea.simea;

import java.util.Date;

/**
 * Created by SIMEA on 25/01/2018.
 */

public class Intervention {

    private String Batiment;
    private String Appareil;
    private String type;
    private Date date;
    private boolean facturation;
    private int tempsPasse;
    private String desc;

    public Intervention(String bat, String Apar, String typ, Date dat, boolean boo, int tmps, String Desck)
    {
        this.Appareil = Apar;
        this.Batiment = bat;
        this.type = typ;
        this.date = dat;
        this.facturation = boo;
        this.tempsPasse = tmps;
        this.desc = Desck;
    }
}
