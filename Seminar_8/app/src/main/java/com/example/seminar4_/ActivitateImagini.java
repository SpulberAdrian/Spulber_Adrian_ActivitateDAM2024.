package com.example.seminar4_;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ActivitateImagini extends AppCompatActivity {
    private List<Imagine> lista = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_imagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        List<Bitmap> imagini = new ArrayList<>();
        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://autocarepremium.ro/web2019/wp-content/uploads/2019/07/MTravego4-2048x1024.jpg");
        linkuriImagini.add("https://tourex.ro/wp-content/uploads/2015/10/autocar-tourex.png");
        linkuriImagini.add("https://zum.md/wp-content/uploads/2024/05/75988674-ca92-48ee-b372-0d9e6d0ff29a.png");
        linkuriImagini.add("https://thumbor.unica.ro/unsafe/580x387/smart/filters:format(webp):contrast(8):quality(75)/https://www.auto-bild.ro/wp-content/uploads/2015/08/11870884_424628877746667_8228826071820772425_n.jpg");
        linkuriImagini.add("https://media-cdn2.romaniatv.net/unsafe/1150x647/smart/filters:contrast(5):format(webp):quality(80)/https://romaniatv.net/wp-content/uploads/2015/05/autocar_10611200.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(String link:linkuriImagini){
                    HttpURLConnection con = null;
                    try{
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                            lista = new ArrayList<>();
                            lista.add(new Imagine("Autocar Mercedes", imagini.get(0), "https://autocarepremium.ro/autocar-mercedes-travego/"));
                            lista.add(new Imagine("Autocar Mercedes2", imagini.get(1), "https://tourex.ro/bilete-de-autocar/"));
                            lista.add(new Imagine("Autocar Mercedes3", imagini.get(2), "https://www.infotrucker.ro/noile-reguli-privind-timpii-de-odihna-pentru-soferii-de-autocar-se-aplica-de-la-22-mai/"));
                            lista.add(new Imagine("Autocar Mercedes4", imagini.get(3), "https://www.4tuning.ro/old-school-cars/un-autocar-mercedes-benz-cu-care-mergeai-in-excursie-pe-vremea-lui-ceausescu-e-de-vanzare-la-un-pret-33500.html"));
                            lista.add(new Imagine("Autocar Mercedes5", imagini.get(4), "https://www.marmara.ro/portfolio/inchiriere-autocar-30-locuri/"));

                            ListView lv = findViewById(R.id.imagini);
                            ImagineAdapter adapter = new ImagineAdapter(lista,getApplicationContext(), R.layout.image_item);
                            lv.setAdapter(adapter);

                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent it = new Intent(getApplicationContext(),WebViewActivity.class);
                                    it.putExtra("link",lista.get(i).getLink());
                                    startActivity(it);
                                }
                            });
                    }
                });

            }
        });





    }
}