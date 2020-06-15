package com.example.neo.Model;

public class ModelKurs {
    private String matauang;
    private double h_beli;
    private double h_jual;

    public ModelKurs(String matauang, double h_beli, double h_jual) {
        this.matauang = matauang;
        this.h_beli = h_beli;
        this.h_jual = h_jual;
    }

    public String getMatauang() {
        return matauang;
    }

    public void setMatauang(String matauang) {
        this.matauang = matauang;
    }

    public double getH_beli() {
        return h_beli;
    }

    public void setH_beli(double h_beli) {
        this.h_beli = h_beli;
    }

    public double getH_jual() {
        return h_jual;
    }

    public void setH_jual(double h_jual) {
        this.h_jual = h_jual;
    }
}
