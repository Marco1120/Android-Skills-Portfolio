package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2Activity extends AppCompatActivity {

    private EditText etTexto;
    private TextView tvTexto;
    private Button btnVaciar, btnRegresar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        etTexto = findViewById(R.id.etTexto);
        tvTexto = findViewById(R.id.tvTexto);
        btnVaciar = findViewById(R.id.btnVaciar);
        btnRegresar2 = findViewById(R.id.btnRegresar2);

        // Mostrar el texto en tiempo real
        etTexto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvTexto.setText(s);
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        // Vaciar ambos campos
        btnVaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTexto.setText("");
                tvTexto.setText("");
            }
        });

        // Volver al menú
        btnRegresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}