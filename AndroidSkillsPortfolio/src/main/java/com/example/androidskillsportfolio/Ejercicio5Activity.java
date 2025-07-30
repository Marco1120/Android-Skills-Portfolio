package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio5Activity extends AppCompatActivity {

    private ListView lstCiudades;
    private Button btnMostrar, btnVolver;
    private TextView lblMensaje, tvDescripcion6;
    private String[] ciudades = {
            "Ciudad de México",
            "Guadalajara",
            "Monterrey",
            "Cancún",
            "Tijuana"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5);

        lstCiudades = findViewById(R.id.lstCiudades);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnVolver = findViewById(R.id.btnVolver);
        lblMensaje = findViewById(R.id.lblMensaje);
        tvDescripcion6 = findViewById(R.id.tvDescripcion6);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                ciudades
        );
        lstCiudades.setAdapter(adapter);
        lstCiudades.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnMostrar.setOnClickListener(v -> {
            int pos = lstCiudades.getCheckedItemPosition();
            if (pos != ListView.INVALID_POSITION) {
                lblMensaje.setText("Seleccionaste: " + ciudades[pos]);
            } else {
                lblMensaje.setText("No se seleccionó ninguna ciudad.");
            }
        });

        btnVolver.setOnClickListener(v -> finish());
    }
}