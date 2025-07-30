package com.example.androidskillsportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3Activity extends AppCompatActivity {

    private CheckBox chkFutbol, chkBasquetbol, chkNatacion;
    private Button btnMostrar, btnVolver;
    private TextView lblSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        chkFutbol = findViewById(R.id.chkFutbol);
        chkBasquetbol = findViewById(R.id.chkBasquetbol);
        chkNatacion = findViewById(R.id.chkNatacion);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnVolver = findViewById(R.id.btnVolver);
        lblSeleccion = findViewById(R.id.lblSeleccion);

        btnMostrar.setOnClickListener(v -> {
            StringBuilder seleccion = new StringBuilder();

            if (chkFutbol.isChecked()) seleccion.append("Fútbol ");
            if (chkBasquetbol.isChecked()) seleccion.append("Básquetbol ");
            if (chkNatacion.isChecked()) seleccion.append("Natación ");

            if (seleccion.length() == 0) {
                lblSeleccion.setText("No se seleccionó ningún deporte.");
            } else {
                lblSeleccion.setText("Seleccionado: " + seleccion.toString().trim());
            }
        });

        btnVolver.setOnClickListener(v ->
                startActivity(new Intent(Ejercicio3Activity.this, MainActivity.class))
        );
    }
}
