package com.android.issou.orm;

import com.orm.SugarRecord;

public class Contact extends SugarRecord {

    int telephone;
    String prenom;
    String nom;

    public Contact() {
    }

    Contact(int telephone, String prenom, String nom) {
        this.telephone = telephone;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
