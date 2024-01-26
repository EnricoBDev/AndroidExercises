package com.enricob.indovinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int randomNumber, guessCounter;
    private Button BTN_submit, BTN_submit_classifica;
    private EditText ETX_inserimento, ETX_nome;
    private TextView TXV_hint;
    private ConstraintLayout CLYT;
    private ListView LSV_classifica;
    private ArrayList<Giocatore> list_classifica = new ArrayList();
    private ArrayAdapter<Giocatore> adapter;
    private boolean classificaCliccato = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //default light mode
        setContentView(R.layout.activity_main);

        generateRandomNumber();

        BTN_submit = findViewById(R.id.BTN_submit);
        BTN_submit_classifica = findViewById(R.id.BTN_submit_classifica);
        TXV_hint = findViewById(R.id.TXV_hint);
        ETX_inserimento = findViewById(R.id.ETX_inserimento);
        CLYT = findViewById(R.id.CLYT);
        ETX_nome = findViewById(R.id.ETX_nome);
        LSV_classifica = findViewById(R.id.LSV_classifica);



        BTN_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroInserito = Integer.parseInt(ETX_inserimento.getText().toString());
                
                if(randomNumber == numeroInserito){
                    Toast.makeText(MainActivity.this, "Hai indovinato", Toast.LENGTH_SHORT).show();
                    CLYT.setBackground(getDrawable(R.drawable.trophy));
                    generateRandomNumber();
                    TXV_hint.setText("Inserisci un numero da 1 a 10");

                    ETX_nome.setVisibility(View.VISIBLE);
                    BTN_submit_classifica.setVisibility(View.VISIBLE);

                } else {
                    if(randomNumber > numeroInserito)
                        TXV_hint.setText("Il numero è più grande");
                    else
                        TXV_hint.setText("Il numero è più piccolo");

                }
                guessCounter+=1;
                ETX_inserimento.setText("");
            }
        });

        BTN_submit_classifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list_classifica.add(new Giocatore(String.valueOf(ETX_nome.getText()), guessCounter));
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list_classifica);
                LSV_classifica.setAdapter(adapter);
                LSV_classifica.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, list_classifica.toString(), Toast.LENGTH_SHORT).show();

                CLYT.setBackground(getDrawable(R.drawable.background));
                BTN_submit_classifica.setVisibility(View.INVISIBLE);
                ETX_nome.setVisibility(View.INVISIBLE);
                guessCounter = 0;
            }
        });


    }

    private static void generateRandomNumber(){
        Random random = new Random();

        randomNumber = random.nextInt(10) + 1;
    }
}