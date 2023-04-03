package com.example.pathofgun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AccesoiresAdapter {
    private ArrayList<Accesoires> objet;
    private LayoutInflater mInflater;

    public AccesoiresAdapter(ArrayList<Accesoires> objet, Context context) {
        this.objet = objet;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objet.size();
    }

    @Override
    public Object getObjet(int i) {
        return null;
    }

    @Override
    public long getObjetId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;
        //(1) : Réutilisation des layouts
        layoutItem = convertView == null ? mInflater.inflate(R.layout.accesoires_layout, parent, false) : convertView;

        //(2) : Récupération des TextView de notre layout
        TextView textView = layoutItem.findViewById(R.id.textViewIngredient);

        //(3) : Renseignement des valeurs
        System.out.println("getView : "+position+" : ");
        System.out.println(objet.get(position).getObjet().getName() + " : " + objet.get(position).getDefaultQuantity() + " " + objet.get(position).getUnity());

        textView.setText(items.get(position).getItem().getName() + " : " + objet.get(position).getDefaultQuantity() + " " + objet.get(position).getUnity());


        textView.setTag(position);



        return layoutItem;
    }
}
