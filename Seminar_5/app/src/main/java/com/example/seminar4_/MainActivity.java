package com.example.seminar4_;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Autocar> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Adaugare_Autocar.class);
                startActivityForResult(it, 400);
            }
        });

        Button listBtn = findViewById(R.id.AfisareButon);
        listBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    Intent it = new Intent(getApplicationContext(), Afisare_Autocare.class);
                    it.putParcelableArrayListExtra("Autocare", (ArrayList<? extends Parcelable>) lista);
                    startActivity(it);
            }
        });
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 400) {
            if(resultCode == RESULT_OK){
                 Autocar autocar = data.getParcelableExtra("autocar");
                lista.add(autocar);
            }
        }
    }
}





