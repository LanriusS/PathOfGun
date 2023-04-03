package com.example.pathofgun;

import android.os.Parcel;

public class Accesoires {
    private Objet objet;

    public Accesoires(Objet objet) {
        this.objet = objet;
    }

    protected Accesoires(Parcel in) {
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
