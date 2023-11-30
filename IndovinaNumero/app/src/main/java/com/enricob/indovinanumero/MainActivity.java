package com.enricob.indovinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int randomNumber;
    private Button BTN_submit;
    private EditText ETX_inserimento;
    private TextView TXV_hint;
    private ConstraintLayout CLYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //default light mode
        setContentView(R.layout.activity_main);

        generateRandomNumber();

        BTN_submit = findViewById(R.id.BTN_submit);

        BTN_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroInserito = Integer.parseInt(ETX_inserimento.getText().toString());
                
                if(randomNumber == numeroInserito){
                    Toast.makeText(MainActivity.this, "Hai indovinato", Toast.LENGTH_SHORT).show();
                    CLYT.setBackground(getDrawable(R.drawable.trophy));
                    generateRandomNumber();
                    TXV_hint.setText("Inserisci un numero da 1 a 10");

                } else {
                    if(randomNumber > numeroInserito)
                        TXV_hint.setText("Il numero è più grande");
                    else
                        TXV_hint.setText("Il numero è più piccolo");
                }
            }
        });

        TXV_hint = findViewById(R.id.TXV_hint);
        ETX_inserimento = findViewById(R.id.ETX_inserimento);
        CLYT = findViewById(R.id.CLYT);
    }

    private static void generateRandomNumber(){
        Random random = new Random();

        randomNumber = random.nextInt(10) + 1;
    }
}