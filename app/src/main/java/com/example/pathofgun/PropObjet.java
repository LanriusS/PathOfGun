package com.example.pathofgun;

import java.util.ArrayList;
import java.util.List;

public class PropObjet {

    private String nom;
    private String description;
    private double prix;
    private String img;

    public PropObjet(String nom, String description, double prix, String img) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
