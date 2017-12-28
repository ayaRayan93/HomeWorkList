package com.example.ayaali.homeworklist.models;

/**
 * Created by AyaAli on 28/12/2017.
 */

public class HomeWork {

    private  String  titel;
    private  String date;

    public HomeWork() {

    }
    public HomeWork(String titel, String date) {
        this.titel = titel;
        this.date = date;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
