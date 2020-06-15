package com.example.neo.Model;

public class ModelAddContact {
    private String name;
    private String bank;
    private String currency;
    private String gender;

    public ModelAddContact(String name, String bank, String currency, String gender) {
        this.name = name;
        this.bank = bank;
        this.currency = currency;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
