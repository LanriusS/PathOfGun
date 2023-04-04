package com.example.pathofgun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class GunDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accessoires_layout);

        // Récupérer l'arme sélectionnée depuis l'Intent
        Gun selectedGun = getIntent().getParcelableExtra("selectedGun");

        // Récupérer les vues du layout
        ImageView imageView = findViewById(R.id.gun_image);
        TextView nomTextView = findViewById(R.id.gun_name);
        ListView accessoiresListView = findViewById(R.id.accessory_list);

        // Mettre à jour les vues avec les données de l'arme
        imageView.setImageResource(selectedGun.getImg());
        nomTextView.setText(selectedGun.getNom());

        // Créer l'adaptateur pour la liste des accessoires
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedGun.getAccessoires());

        // Afficher la liste des accessoires
        accessoiresListView.setAdapter(adapter);
    }
}