package com.example.simea.simea;

import android.media.Image;
import android.support.v7.widget.RecyclerView;

import java.util.Date;

/**
 * Created by youness on 26/01/2018.
 */

public class Solution{

    private String id;
    private String site;
    private String Appareil;
    private String description;
    private Date date;
    private Image proof;

    public Solution(String site, String appareil, String description) {
        this.id = site;
        this.Appareil = appareil;
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAppareil() {
        return Appareil;
    }

    public void setAppareil(String appareil) {
        Appareil = appareil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Image getProof() {
        return proof;
    }

    public void setProof(Image proof) {
        this.proof = proof;
    }



}
