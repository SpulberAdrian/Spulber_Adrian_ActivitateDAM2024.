package com.example.seminar_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("Activitate", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activitate", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Activitate", "onResume");
        Toast.makeText(this,"Activitatea activa",Toast.LENGTH_LONG).show();
        Toast.makeText(this,R.string.mesaj,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activitate", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activitate", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void deschidere(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity3.class);

    }
}