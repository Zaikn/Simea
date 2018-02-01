package com.example.simea.simea;

/**
 * Created by SIMEA on 01/02/2018.
 */

public class Travaux {
    private int action;
    private int fourniture;

    public Travaux(int action, int fourniture) {
        this.action = action;
        this.fourniture = fourniture;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getFourniture() {
        return fourniture;
    }

    public void setFourniture(int fourniture) {
        this.fourniture = fourniture;
    }
}
