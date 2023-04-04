package com.example.pathofgun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class GunAdapter extends BaseAdapter {
    private ListGun listGun;
    private Context context;

    public GunAdapter(Context context, ListGun listGun) {
        this.context = context;
        this.listGun = listGun;
    }

    @Override
    public int getCount() {
        return listGun.size();
    }

    @Override
    public Object getItem(int position) {
        return listGun;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.gun_layout, parent, false);
        } else {
            view = convertView;
        }

        TextView nomTextView = view.findViewById(R.id.name);
        nomTextView.setText(listGun.getGun(position).getNom());

        ImageView imageView = view.findViewById(R.id.picture);
        imageView.setImageResource(listGun.getGun(position).getImg());

        TextView priceTextView = view.findViewById(R.id.price);
        priceTextView.setText(String.valueOf(listGun.getGun(position).getPrix()));

        return view;
    }
}