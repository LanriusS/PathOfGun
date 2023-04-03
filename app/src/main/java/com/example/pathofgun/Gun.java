package com.example.pathofgun;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.HashMap;

public class Gun {
    private boolean selected = false;
    private final String nom;
    private final int img;
    private String prix;
    private final double prixBase;
    ArrayList<Accesoires> listAccesoires = new ArrayList<>();
    ArrayList<Accesoires> listExtraAccesoires = new ArrayList<>();
    private final HashMap<Accesoires, Integer> AccesoiresQuantites = new HashMap<>();
    private final HashMap<Accesoires, Integer> AccesoiresPrix = new HashMap<>();

    public Pizza(String name, int price, int picture, ArrayList<Accesoires> listAccesoires) {
        this.nom = name;
        this.img = picture;
        this.prix = ""+price;
        this.prixBase = Float.valueOf(price);
        this.listAccesoires = listAccesoires;
        Accesoires fromage = new Accesoires(Item.FROMAGE, 50, "g");
        Accesoires olives = new Accesoires(Item.OLIVES, 3, "g");
        Accesoires champignons = new Accesoires(Item.CHAMPIGNONS, 80, "g");
        listExtraAccesoires.add(fromage);
        listExtraAccesoires.add(olives);
        listExtraAccesoires.add(champignons);


        this.AccesoiresQuantites.put(fromage, 50);
        this.AccesoiresQuantites.put(olives, 3);
        this.AccesoiresQuantites.put(champignons, 80);
        this.AccesoiresPrix.put(fromage, 0);
        this.AccesoiresPrix.put(olives, 0);
        this.AccesoiresPrix.put(champignons, 0);
    }


    protected Gun(Parcel in) {
        selected = in.readByte() != 0;
        nom = in.readString();
        img = in.readInt();
        prix = in.readString();
        prixBase = in.readDouble();
        listAccesoires = in.readArrayList(Accesoires.class.getClassLoader());
    }

    public String getNom() {
        return nom;
    }

    public int getImg() {
        return img;
    }

    public float getPrix() {
        return Float.valueOf(prix);
    }

    public int getQuantity(String Accesoires) {
        int i = 0;
        while (i < listExtraAccesoires.size()) {
            if (listExtraAccesoires.get(i).getItem().getName().equals(Accesoires)) {
                return AccesoiresQuantites.get(listExtraAccesoires.get(i));
            }
            i++;
        }
        return -1;
    }

    public void setQuantity(String Accesoires, int quantity) {
        int i = 0;
        while (i < listExtraAccesoires.size()) {
            Accesoires extraAccesoires = listExtraAccesoires.get(i);
            if (extraAccesoires.getItem().getName().equals(Accesoires)) {
                AccesoiresQuantites.put(extraAccesoires, quantity);
            }
            i++;
        }
    }

    public void setPrix(String price) {
        this.prix = price;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }


    @Override
    public String toString() {
        return "Gun{" +
                "selected=" + selected +
                ", name='" + nom + '\'' +
                ", picture=" + img +
                ", price='" + prix + '\'' +
                ", basePrice=" + prixBase +
                ", listIngredient=" + listAccesoires +
                ", listExtraIngredient=" + listExtraAccesoires +
                ", ingredientsQuantites=" + AccesoiresQuantites +
                ", ingredientsPrix=" + AccesoiresPrix +
                '}';
    }

    public HashMap<Accesoires, Integer> getAccesoiresQuantites() {
        return AccesoiresQuantites;
    }

    public HashMap<Accesoires, Integer> getAccesoiresPrix() {
        return AccesoiresPrix;
    }

    public ArrayList<Accesoires> getListAccesoires() {
        return listAccesoires;
    }

    public void setListAccesoires(ArrayList<Accesoires> listAccesoires) {
        this.listAccesoires = listAccesoires;
    }

    public ArrayList<Accesoires> getListExtraIngredient() {
        return listExtraAccesoires;
    }

    public void setListExtraAccesoires(ArrayList<Accesoires> listExtraAccesoires) {
        this.listExtraAccesoires = listExtraAccesoires;

    }
