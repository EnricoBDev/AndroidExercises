package com.example.btncolorilisteners;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TXV_1, TXV_2, TXV_3;
    Button BTN_1, BTN_2, BTN_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TXV_1 = findViewById(R.id.textView1);
        TXV_2 = findViewById(R.id.textView2);
        TXV_3 = findViewById(R.id.textView3);
        BTN_1 = findViewById(R.id.button1);
        BTN_2 = findViewById(R.id.button2);
        BTN_3 = findViewById(R.id.button3);

        BTN_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TXV_2.setText(String.valueOf(TXV_2.getId()));
                TXV_2.setBackgroundColor(Color.GREEN);
            }
        });

        BTN_3.setOnClickListener(this);

    }

    public void pigiami(View view){
        TXV_1.setText(String.valueOf(TXV_1.getId()));
        TXV_1.setBackgroundColor(Color.RED);
    }

    @Override
    public void onClick(View view) {
        TXV_3.setText(String.valueOf(TXV_3.getId()));
        TXV_3.setBackgroundColor(Color.BLUE);
    }
}