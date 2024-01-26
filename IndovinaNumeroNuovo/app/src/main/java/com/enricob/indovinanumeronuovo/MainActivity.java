package com.enricob.indovinanumeronuovo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button button;
    private EditText editText;

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        layout = findViewById(R.id.layout);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int valoreScritto = Integer.parseInt(editText.getText().toString());

        if(valoreScritto == 1){
            layout.setBackground(getDrawable(R.drawable.sfondo1));
            textView.setText("ciao");
            editText.setText("");
        } else {
            StyleableToast.makeText(MainActivity.this, "Jennifer sposami pls", Toast.LENGTH_LONG, R.style.mytoast).show();
        }
    }
}