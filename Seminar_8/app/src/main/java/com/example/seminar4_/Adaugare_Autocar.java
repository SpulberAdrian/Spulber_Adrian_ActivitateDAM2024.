package com.example.seminar4_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


            Intent it = getIntent();
             if(it.hasExtra("autocar")) {
                 Autocar autocar = it.getParcelableExtra("autocar");
                 EditText Loc = findViewById(R.id.Locuri);
                 EditText Lit = findViewById(R.id.litri);
                 EditText nume = findViewById(R.id.Nume);
                 EditText cai = findViewById(R.id.Cai);

                Loc.setText(String.valueOf(autocar.getNrLocuri()));
                Lit.setText(String.valueOf(autocar.getRezervorCapacitate()));
                nume.setText(autocar.getNumeSofer());
                cai.setText(String.valueOf(autocar.getCaiPutere()));
             }
            return insets;
        });

        Button btn = findViewById(R.id.submitButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Loc = findViewById(R.id.Locuri);
                String locuriStr = Loc.getText().toString();
                int Locuri = Integer.parseInt(locuriStr);

                EditText Lit = findViewById(R.id.litri);
                String LitriStr = Lit.getText().toString();
                double Litri = Double.parseDouble(LitriStr);

                EditText nume = findViewById(R.id.Nume);
                String Nume = nume.getText().toString();

                EditText cai = findViewById(R.id.Cai);
                String Cai = cai.getText().toString();
                int Caluti = Integer.parseInt(Cai);

                Autocar A = new Autocar();
                A.setNrLocuri(Locuri);
                A.setRezervorCapacitate(Litri);
                A.setNumeSofer(Nume);
                A.setCaiPutere(Caluti);


                Intent intentA = new Intent();
                intentA.putExtra("autocar",A);
                //startActivityForResult(intentA,103);
                setResult(RESULT_OK,intentA);
                finish();
                Toast.makeText(getApplicationContext(),A.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    protected void onStart() {
        super.onStart();
    }

}