package com.example.pathofgun;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListGun {

    private List<Gun> guns = new ArrayList<>();

    public void addGun(Gun gun) {
        guns.add(gun);
    }
    
    ArrayList<Gun> list;

    static ListGun Instance = null;

    ListGun(){
        list = new ArrayList<Gun>();
    }

    public int size(){
        return list.size();
    }

    public Gun get(int i){
        return list.get(i);
    }

    public static ListGun getInstance(){
        if(Instance == null){
            Instance = new ListGun();
        }
        return Instance;
    }

    public ArrayList<Gun> construcList (Context context){
        try {
            JSONArray jsonGun = new JSONArray(getJSONFromAssetGun(context));

            for (int i = 0; i < jsonGun.length(); i++) {
                list.add(GunFromJson(jsonGun.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void  NewListGun (Context context){
        list.clear();
        try{
            JSONArray jsonGun = new JSONArray(getJSONFromAssetGun(context));
            Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();

            for (int i = 0; i < jsonGun.length(); i++) {
                Toast.makeText(context,"length list" + i,Toast.LENGTH_LONG);
                list.add(GunFromJson(jsonGun.getJSONObject(i),context));
                Toast.makeText(context, "length list" + list.size(), Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private Gun GunFromJson(JSONObject jsonObject, Context context) throws JSONException{

        String nom = jsonObject.getString("nom");
        double prix = jsonObject.getDouble("prix");
        int img = context.getResources().getIdentifier(jsonObject.getString("img"), "drawable", context.getPackageName());
        ArrayList<String> accessoires = new ArrayList<String>();
        JSONArray jsonAccessoires = jsonObject.getJSONArray("accessoires");
        for (int i = 0; i < jsonAccessoires.length(); i++) {
            accessoires.add(jsonAccessoires.getString(i));
        }

        return new Gun(nom,prix,img,accessoires);
    }

    private String getJSONFromAssetGun(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("gun.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<Gun> getGun(Context context){
        try {
            JSONArray jsonGun = new JSONArray(getJSONFromAssetGun(context));

            for (int i = 0; i < jsonGun.length(); i++) {
                list.add(GunFromJson(jsonGun.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Gun getGun(int position) {
        return list.get(position);
    }

    public void setListGun(List<Gun> guns) {
        this.guns = guns;
    }

    public void addAll(List<Gun> guns) {
        this.guns.addAll(guns);
    }

    public void add(Gun gun) {
        this.guns.add(gun);
    }

    public void changeSelected(int position) {
        Gun gun = list.get(position);
        gun.setSelected(!gun.isSelected());
        list.set(position, gun);
    }
}