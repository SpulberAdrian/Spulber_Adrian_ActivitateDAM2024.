package com.example.seminar4_;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Afisare_Favorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_favorite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lw = findViewById(R.id.ListViewFavorite);
        List<String> listaFavorite = new ArrayList<>();

        SharedPreferences sh = getSharedPreferences("AutocarelePreferate", MODE_PRIVATE);
        Set<String> favoriteSet = sh.getStringSet("Autocar_favorit", new HashSet<>());

        for(String autocarString : favoriteSet){
            listaFavorite.add(autocarString);
        }

        ArrayAdapter<String> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaFavorite);
        lw.setAdapter(adaptor);
    }
}