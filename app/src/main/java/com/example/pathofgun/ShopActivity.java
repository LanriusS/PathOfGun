package com.example.pathofgun;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements ClickableActivity {

    private ListGun listGun;
    private GunAdapter gunAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fond_shop);

        listGun = new ListGun();
        gunAdapter = new GunAdapter(this, listGun);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(gunAdapter);

        List<Gun> guns = new ArrayList<>();

        try {
            InputStream inputStream = getAssets().open("Gun.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String nom = jsonObject.getString("nom");
                double prix = jsonObject.getDouble("prix");
                String img = jsonObject.getString("img");
                JSONArray accessoiresJsonArray = jsonObject.getJSONArray("accessoires");
                List<String> accessoires = new ArrayList<>();
                for (int j = 0; j < accessoiresJsonArray.length(); j++) {
                    accessoires.add(accessoiresJsonArray.getString(j));
                }

                Gun gun = new Gun();
                gun.setNom(nom);
                gun.setPrix(prix);
                gun.setImg(getResources().getIdentifier(img, "drawable", getPackageName()));                gun.setAccessoires(accessoires);
                gun.setAccessoires(accessoires);
                listGun.add(gun);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        listGun.setListGun(guns);
    }

    @Override
    public void onClickNom(int position) {
        gunAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
