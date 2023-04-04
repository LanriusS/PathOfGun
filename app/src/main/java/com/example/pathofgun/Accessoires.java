package com.example.pathofgun;

import android.os.Parcel;

public class Accessoires {
    private Objet objet;

    public Accessoires(Objet objet) {
        this.objet = objet;
    }

    protected Accessoires(Parcel in) {
        objet = objet.valueOf(in.readString());
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    @Override
    public String toString() {
        return "Accessoires{" +
                ", objet=" + objet + '\'' +
                '}';
    }
}
