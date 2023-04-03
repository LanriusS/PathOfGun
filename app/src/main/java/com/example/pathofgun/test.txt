package com.example.pathofgun;

import java.util.ArrayList;
import java.util.List;

public class ListGun {
    public static List<PropObjet> getListeObjets() {
        List<PropObjet> objets = new ArrayList<>();

        objets.add(new PropObjet("AK47", "Description de l'objet 1", 9.99, "drawable/ak.png"));
        objets.add(new PropObjet("M4A1", "Description de l'objet 2", 19.99, "drawable/m4.png"));
        objets.add(new PropObjet("FSS", "Description de l'objet 3", 29.99, "drawable/fss.png"));
        objets.add(new PropObjet("Basilisk", "Description de l'objet 4", 39.99, "drawable/basilisk.png"));
        objets.add(new PropObjet("P890", "Description de l'objet 5", 49.99, "drawable/p890.png"));
        objets.add(new PropObjet("STB", "Description de l'objet 6", 59.99, "drawable/stb.png"));
        objets.add(new PropObjet("TAQ", "Description de l'objet 6", 59.99, "drawable/taq.png"));
        objets.add(new PropObjet("Victus", "Description de l'objet 6", 59.99, "drawable/victus.png"));

        return objets;
    }
    public void changeSelected(int selected){
        for (PropObjet gun : this) {
            gun.setSelected(false);
        }
        this.get(selected).setSelected(true);
    }

    public int isOneSelected(){
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).isSelected()){
                return i;
            }
        }
        return -1;
    }

}
