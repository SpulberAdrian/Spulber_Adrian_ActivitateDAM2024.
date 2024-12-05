package com.example.seminar4_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Afisare_Autocare extends AppCompatActivity {

    private List<Autocar> autocare = null;
    private int idMofificat= 0;
    private AutocarAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_autocare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it =  getIntent();
        List<Autocar> listaAuto = it.getParcelableArrayListExtra("Autocare");
        autocare = listaAuto;

        ListView lw = findViewById(R.id.ListAutocar);
//        ArrayAdapter<Autocar> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaAuto);
//        lw.setAdapter(adaptor);

        adapter = new AutocarAdapter(autocare,getApplicationContext(),R.layout.row_item);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentModifica = new Intent(getApplicationContext(),Adaugare_Autocar.class);
                intentModifica.putExtra("autocar",autocare.get(i));
                idMofificat = i;
                startActivityForResult(intentModifica,209);
                Toast.makeText(getApplicationContext(),listaAuto.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

//
//        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                listaAuto.remove(i);
//                adaptor.notifyDataSetChanged();
//                return false;
//            }
//        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 209){
                autocare.set(idMofificat, data.getParcelableExtra("autocar"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}