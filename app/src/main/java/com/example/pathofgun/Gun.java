package com.example.pathofgun;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Gun {
    private String nom;
    private double prix;
    private int img;
    private List<String> accessoires;

    public Gun(String nom, double prix, int img, List<String> accessoires) {
        this.nom = nom;
        this.prix = prix;
        this.img = img;
        this.accessoires = accessoires;
    }

    public Gun() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public List<String> getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(List<String> accessoires) {
        this.accessoires = accessoires;
    }

    public List<String> getAccessories() {
        return accessoires;
    }

    public void setSelected(boolean checked) {
    }

    public boolean isSelected() {
        return false;
    }
}
