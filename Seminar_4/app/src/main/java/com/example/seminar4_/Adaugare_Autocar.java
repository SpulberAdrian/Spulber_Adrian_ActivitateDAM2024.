package com.example.seminar4_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adaugare_Autocar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_autocar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.submitButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Loc = findViewById(R.id.Locuri);
                String locuriStr = Loc.getText().toString();
                Integer locuri = Integer.parseInt(locuriStr);

                EditText Lit = findViewById(R.id.litri);
                String LitriStr = Lit.getText().toString();
                Double Litri = Double.parseDouble(LitriStr);

                EditText nume = findViewById(R.id.Nume);
                String Nume = nume.getText().toString();

                EditText cai = findViewById(R.id.Cai);
                String Cai = cai.getText().toString();
                Integer Caluti = Integer.parseInt(Cai);
            }
        });
    }
}