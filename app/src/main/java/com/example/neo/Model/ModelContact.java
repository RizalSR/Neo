package com.example.neo.Model;

public class ModelContact {
    private String c_name;
    private int c_image;
    private String c_bank;
    private String c_currency;

    public ModelContact(String c_name, int c_image, String c_bank, String c_currency) {
        this.c_name = c_name;
        this.c_image = c_image;
        this.c_bank = c_bank;
        this.c_currency = c_currency;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_image() {
        return c_image;
    }

    public void setC_image(int c_image) {
        this.c_image = c_image;
    }

    public String getC_bank() {
        return c_bank;
    }

    public void setC_bank(String c_bank) {
        this.c_bank = c_bank;
    }

    public String getC_currency() {
        return c_currency;
    }

    public void setC_currency(String c_currency) {
        this.c_currency = c_currency;
    }
}
