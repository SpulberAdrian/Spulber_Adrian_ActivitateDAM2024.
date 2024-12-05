package com.example.seminar4_;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Adaugare_Autocar extends AppCompatActivity {

    private AutocareDatabase autocareDB;
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

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                super.onDestructiveMigration(db);
            }
        };
        autocareDB = Room.databaseBuilder(getApplicationContext(), AutocareDatabase.class,
                "AutocareDatabase.db").addCallback(myCallBack).build();

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

                inserareAutocarBackround(A);


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

    public void inserareAutocarBackround(Autocar autocar){
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                //backround task
                autocareDB.autocareDao().inserareAutocar(autocar);

                //on finishing task
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      Toast.makeText(getApplicationContext(), "Autocar adaugat la baza de date", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}