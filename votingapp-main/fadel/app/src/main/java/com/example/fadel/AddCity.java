package com.example.fadel;

public class AddCity {
    private int idc;
    private String cityn;
    private String gov;
    private int numer;

    public AddCity(int idc,String cityn,String gov,int numer) {
        this.idc = idc;
        this.cityn=cityn;
        this.gov=gov;
        this.numer=numer;
    }

    public AddCity() {
    }

    @Override
    public String toString() {
        return "AddCity{" +
                "idc=" + idc +
                ", cityn='" + cityn + '\'' +
                ", gov='" + gov + '\'' +
                ", numer=" + numer +
                '}';
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getCityn() {
        return cityn;
    }

    public void setCityn(String cityn) {
        this.cityn = cityn;
    }

    public String getGov() {
        return gov;
    }

    public void setGov(String gov) {
        this.gov = gov;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }
}
