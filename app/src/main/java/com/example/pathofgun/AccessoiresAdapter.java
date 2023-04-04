package com.example.pathofgun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AccessoiresAdapter extends BaseAdapter {
    private ArrayList<Accessoires> objet;
    private LayoutInflater mInflater;

    public AccessoiresAdapter(ArrayList<Accessoires> objet, Context context) {
        this.objet = objet;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objet.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;
        //(1) : Réutilisation des layouts
        layoutItem = convertView == null ? mInflater.inflate(R.layout.accessoires_layout, parent, false) : convertView;

        //(2) : Récupération des TextView de notre layout
        TextView textView = layoutItem.findViewById(R.id.textViewAccessoires);

        //(3) : Renseignement des valeurs
        System.out.println("getView : "+position+" : ");
        System.out.println(objet.get(position).getObjet().getName() + " : " + objet.get(position));

        textView.setText(objet.get(position).getObjet().getName() + " : " + objet.get(position));


        textView.setTag(position);



        return layoutItem;
    }
}
