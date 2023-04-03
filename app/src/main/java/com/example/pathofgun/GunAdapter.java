package com.example.pathofgun;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class GunAdapter extends BaseAdapter {
    private ListGun gun;
    private LayoutInflater mInflater;
    private ClickableActivity activity;
    private int selected = -1;

    public GunAdapter(ClickableActivity activity, ListGun gun) {
        this.activity = activity;
        this.gun = gun;
        mInflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return gun.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public Object getgun(int position) {
        return gun.get(position);
    }

    public long getgunId(int position) {
        return position;
    }

    public ListGun getgun() {
        return gun;
    }

    public void setgun(ListGun gun) {
        this.gun = gun;
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
        nom.setText(gun.get(position).getNom());
        prix.setText(gun.get(position).getPrix()+"€");
        image.setImageResource(gun.get(position).getImg());
        prix.setTextColor(( Float.parseFloat(""+gun.get(position).getPrix())> 5.0)? Color.RED : Color.parseColor("#7A7A7A"));

        nom.setTag(position);
        image.setTag(position);
        prix.setTag(position);

        nom.setOnClickListener(v -> {
            gun.changeSelected(position);
            activity.onClickNom(position);
            nom.setTextSize(30);
        });

        if (!(gun.get(position).isSelected())) {
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