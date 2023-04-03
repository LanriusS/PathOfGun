package com.example.pathofgun;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ListGun extends ArrayList<Gun> {

    static ArrayList<Accesoires> listAccessoires1 = new ArrayList<>();
    static ArrayList<Accesoires> listAccessoires2 = new ArrayList<>();
    static ArrayList<Accesoires> listAccessoires3 = new ArrayList<>();
    static ArrayList<Accesoires> listAccessoires4 = new ArrayList<>();


    private static ListGun instance=null;

    public static ListGun getInstance(){
        if (instance==null) {
            instance = new ListGun();
        }
        return instance;
    }

    public ListGun() {
        listAccessoires1.add(new Accesoires(Objet.ACOG));
        listAccessoires1.add(new Accesoires(Objet.MAG));
        listAccessoires1.add(new Accesoires(Objet.CROSSE));
        listAccessoires1.add(new Accesoires(Objet.POIGNEE));
        listAccessoires1.add(new Accesoires(Objet.OTAN));

        listAccessoires2.add(new Accesoires(Objet.RED));
        listAccessoires2.add(new Accesoires(Objet.SILENCIEUX));
        listAccessoires2.add(new Accesoires(Objet.C9));
        listAccessoires2.add(new Accesoires(Objet.MAG));

        listAccessoires3.add(new Accesoires(Objet.SCOPE));
        listAccessoires3.add(new Accesoires(Objet.SILENCIEUX));
        listAccessoires3.add(new Accesoires(Objet.CROSSE));
        listAccessoires3.add(new Accesoires(Objet.POIGNEE));
        listAccessoires3.add(new Accesoires(Objet.C50));

        listAccessoires4.add(new Accesoires(Objet.RED));
        listAccessoires4.add(new Accesoires(Objet.COMPENSATEUR));
        listAccessoires4.add(new Accesoires(Objet.MAG));
        listAccessoires4.add(new Accesoires(Objet.OTAN));
        listAccessoires4.add(new Accesoires(Objet.POIGNEE));

        add(new Gun("AK47", 9.99, R.drawable.ak, listAccessoires1));
        add(new Gun("M4A1", 19.99, R.drawable.m4, listAccessoires4));
        add(new Gun("FSS", 29.99, R.drawable.fss, listAccessoires1));
        add(new Gun("Basilisk", 39.99, R.drawable.basilisk, listAccessoires2));
        add(new Gun("P890", 49.99, R.drawable.p890, listAccessoires2));
        add(new Gun("STB", 59.99, R.drawable.stb, listAccessoires4));
        add(new Gun("TAQ", 59.99, R.drawable.taq, listAccessoires4));
        add(new Gun("Victus", 59.99, R.drawable.victus, listAccessoires3));

    }

    public void changeSelected(int selected){
        for (Gun gun : this) {
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

    static public String floatToCurrency(float amount) {
        Locale locale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }
}
