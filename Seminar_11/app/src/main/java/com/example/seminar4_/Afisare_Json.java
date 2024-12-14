package com.example.seminar4_;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Afisare_Json extends AppCompatActivity {

    List<ParsareJson> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_json);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection con = null;
                try {
                    URL url = new URL("https://pdm.ase.ro/situatii.json");
                    con = (HttpURLConnection) url.openConnection();
                    InputStream is = con.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }

                    JSONObject jsonObject = new JSONObject(builder.toString());
                    JSONArray vector = jsonObject.getJSONArray("situatii");

                    for (int i = 0; i < vector.length(); i++){
                        JSONObject situatie = vector.getJSONObject(i);
                        String disciplina = situatie.getString("disciplina");
                        String activitate = situatie.getString("activitate");
                        int valoare =situatie.getInt("valoare");
                        double pondere = situatie.getDouble("pondere");
                        String data = situatie.getString("data");
                        String descriere = situatie.getString("descriere");

                        ParsareJson af = new ParsareJson(disciplina,activitate,valoare,pondere,data,descriere);
                        lista.add(af);
                    }
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView lw = findViewById(R.id.listaJson);
                        ArrayAdapter<ParsareJson> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);
                        lw.setAdapter(adaptor);
                    }
                });
            }
        });






    }
}