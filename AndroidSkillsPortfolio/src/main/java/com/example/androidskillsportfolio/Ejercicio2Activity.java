package com.example.androidskillsportfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2Activity extends AppCompatActivity {

    private Button btnCambiarColor;
    private Button btnVolver;
    private LinearLayout mainLayout; // Referencia al layout principal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        // Referencias a los elementos del layout
        btnCambiarColor = findViewById(R.id.btnCambiarColor);
        btnVolver = findViewById(R.id.btnVolver);
        mainLayout = findViewById(R.id.mainLayout); // ID del LinearLayout

        // Cambiar el color de fondo al presionar el botón
        btnCambiarColor.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.CYAN)
        );

        // Botón para volver al menú principal
        btnVolver.setOnClickListener(v -> finish());
    }
}
