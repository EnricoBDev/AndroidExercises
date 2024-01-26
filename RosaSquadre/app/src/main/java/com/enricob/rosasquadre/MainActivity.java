package com.enricob.rosasquadre;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button BtnInserisciSquadra;
    private EditText EtxNome;
    private ListView LsvSquadre;
    private ArrayList<Squadra> arraySquadre = new ArrayList<>();
    private ArrayAdapter<Squadra> squadreAdapter;
    private Squadra squadraCorrente;
    private boolean eInizio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerForActivityResult()
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        findById();
        setListeners();
    }


    private void findById(){
        BtnInserisciSquadra = findViewById(R.id.BtnInserisciSquadra);
        EtxNome = findViewById(R.id.EtxNome);
        LsvSquadre = findViewById(R.id.LsvSquadre);
    }

    private void popolaListView(){
        squadreAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arraySquadre);
        LsvSquadre.setAdapter(squadreAdapter);
    }

    private void reset(){
        EtxNome.setText("");
    }

    private void cambiaSchermata(int idxArraySquadre){
        Intent intent = new Intent(MainActivity.this, RosaActivity.class);
        intent.putExtra("Squadra", arraySquadre.get(idxArraySquadre));
        startActivity(intent);
    }

    private void setListeners(){
        BtnInserisciSquadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeSquadra = EtxNome.getText().toString();
                reset();

                ArrayList<String> listaNomiSquadre = new ArrayList<>();
                for (Squadra s : arraySquadre){
                    listaNomiSquadre.add(s.getNome());
                }

                if (!nomeSquadra.isEmpty() && !listaNomiSquadre.contains(nomeSquadra)){
                    squadraCorrente = new Squadra(nomeSquadra);
                    arraySquadre.add(squadraCorrente);
                    popolaListView();
                    // cambia schermata
                    cambiaSchermata(arraySquadre.size() - 1);
                    // inviamo l'ultimo elemento della lista ovvero quello corrente
                    eInizio = false;
                }
            }
        });

        LsvSquadre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cambiaSchermata(i);
            }
        });
    }
}