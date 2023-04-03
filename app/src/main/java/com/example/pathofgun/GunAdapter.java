package com.example.pathofgun;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Locale;


public class GunAdapter extends BaseAdapter {
    private List<PropObjet> items;
    private LayoutInflater mInflater;
    private ClickableActivity activity;
    private int selected = -1;

    public GunAdapter(ClickableActivity activity, List<PropObjet> items) {
        this.activity = activity;
        this.items = items;
        mInflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public List<PropObjet> getItems() {
        return items;
    }

    public void setItems(List<PropObjet> items) {
        this.items = items;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View layoutItem;

        //(1) : Réutilisation des layouts
        if (convertView == null) {
            layoutItem = mInflater.inflate(R.layout.activity_shop, parent, false);
        } else {
            layoutItem = convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView nom = layoutItem.findViewById(R.id.name);
        TextView prix = layoutItem.findViewById(R.id.price);
        ImageView image = layoutItem.findViewById(R.id.picture);

        //(3) : Renseignement des valeurs
        nom.setText(items.get(position).getNom());
        prix.setText(items.get(position).getPrix()+"€");
        image.setImageResource(items.get(position).getImg());
        prix.setTextColor(( Float.parseFloat(""+items.get(position).getPrix())> 5.0)? Color.RED : Color.parseColor("#7A7A7A"));

        nom.setTag(position);
        image.setTag(position);
        prix.setTag(position);

        nom.setOnClickListener(v -> {
            items.changeSelected(position);
            activity.onClickNom(position);
            nom.setTextSize(30);
        });

        if (!(items.get(position).isSelected())) {
            nom.setTextSize(20);
        }

        return layoutItem; //On retourne l'item créé.
    }
}










/*
public class GunAdapter extends ArrayAdapter<PropObjet> {

    public GunAdapter(@NonNull Context context, int resource, @NonNull List<PropObjet> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // récupération de l'objet à afficher à partir de la position dans la liste
        PropObjet objet = getItem(position);

        // récupération de la vue de l'élément de la ListView
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listView, parent, false);
        }

        // chargement de l'image à partir de l'URL stockée dans l'objet
        ImageView image = convertView.findViewById(R.id.image);
        int resID = getContext().getResources().getIdentifier(objet.getImage(), "drawable", getContext().getPackageName());
        image.setImageResource(resID);

        // affichage des autres informations de l'objet dans les TextView de l'élément
        TextView nom = convertView.findViewById(R.id.nom);
        nom.setText(objet.getNom());

        TextView description = convertView.findViewById(R.id.description);
        description.setText(objet.getDescription());

        TextView prix = convertView.findViewById(R.id.prix);
        prix.setText(String.format(Locale.getDefault(), "%.2f €", objet.getPrix()));

        return convertView;
    }
}
*/