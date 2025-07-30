package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio1Activity extends AppCompatActivity {

    private Button btnActualizar;
    private Button btnVolver; // ← Botón agregado
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        btnActualizar = findViewById(R.id.btnActualizar);
        lblTexto = findViewById(R.id.lblTexto);
        btnVolver = findViewById(R.id.btnVolver); // ← Referencia al botón

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblTexto.setText("¡Texto actualizado correctamente!");
            }
        });

        btnVolver.setOnClickListener(v -> finish()); // ← Acción del botón
    }
}
