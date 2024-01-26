package com.enricob.rosasquadre;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class RosaActivity extends AppCompatActivity {

    private EditText EtxNome, EtxCognome;
    private Button BtnInserisciGiocatore;
    private ListView LsvGiocatori;
    private ArrayAdapter giocatoriAdapter;
    private Squadra squadra;
    private Giocatore giocatore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosa);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findById();
        setListeners();
        getIntentData();
        popolaListView();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d("prova", squadra.toString());
        Intent intent = new Intent(RosaActivity.this, MainActivity.class);
        intent.putExtra("SquadraAggiornata", squadra);
        setResult(RESULT_OK, intent);
        finish();
        return true;

    }

    private void findById(){
        EtxNome = findViewById(R.id.EtxNomeGiocatore);
        EtxCognome = findViewById(R.id.EtxCognome);
        LsvGiocatori = findViewById(R.id.LsvGiocatori);
        BtnInserisciGiocatore = findViewById(R.id.BtnInserisciGiocatore);
    }

    private void reset(){
        EtxNome.setText("");
        EtxCognome.setText("");
    }

    private void popolaListView(){
        giocatoriAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, squadra.getGiocatori());
        LsvGiocatori.setAdapter(giocatoriAdapter);
    }

    private void getIntentData(){
        Intent intent = getIntent();
        squadra = (Squadra) intent.getSerializableExtra("Squadra");
        Toast.makeText(this, squadra.getGiocatori().toString(), Toast.LENGTH_SHORT).show();
    }

    private void setListeners(){
        BtnInserisciGiocatore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeGiocatore = EtxNome.getText().toString();
                String cognomeGiocatore = EtxCognome.getText().toString();

                if(!nomeGiocatore.isEmpty() && !cognomeGiocatore.isEmpty()){
                    giocatore = new Giocatore(nomeGiocatore, cognomeGiocatore);
                    squadra.addGiocatore(giocatore);
                    popolaListView();
                }

                reset();
            }
        });

        LsvGiocatori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Giocatore giocatoreCliccato = (Giocatore) adapterView.getItemAtPosition(i);
                Toast.makeText(RosaActivity.this, giocatoreCliccato.toString(), Toast.LENGTH_SHORT).show();
                EtxCognome.setText(giocatoreCliccato.getCognome());
                EtxNome.setText(giocatoreCliccato.getNome());
            }
        });
    }
}