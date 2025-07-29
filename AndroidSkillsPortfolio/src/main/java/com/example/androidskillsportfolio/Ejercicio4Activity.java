package com.example.androidskillsportfolio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio4Activity extends AppCompatActivity {

    private EditText txtRadio;
    private TextView tvArea, tvPerimetro, tvDescripcion4;
    private Button btnCalcular, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        txtRadio = findViewById(R.id.txtRadio);
        tvArea = findViewById(R.id.tvArea);
        tvPerimetro = findViewById(R.id.tvPerimetro);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolver = findViewById(R.id.btnVolver);
        tvDescripcion4 = findViewById(R.id.tvDescripcion4);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAreaYPerimetro();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra esta Activity y regresa al menú principal
                finish();
            }
        });
    }

    private void calcularAreaYPerimetro() {
        String radioStr = txtRadio.getText().toString().trim();

        if (radioStr.isEmpty()) {
            mostrarError("Introduce un valor");
            return;
        }

        try {
            double radio = Double.parseDouble(radioStr);
            if (radio < 0) {
                mostrarError("Error");
            } else {
                double area = Math.PI * radio * radio;
                double perimetro = 2 * Math.PI * radio;
                tvArea.setText("Área: " + area);
                tvPerimetro.setText("Perímetro: " + perimetro);
                tvArea.setTextColor(Color.parseColor("#2E7D32")); // Verde
                tvPerimetro.setTextColor(Color.parseColor("#6A1B9A")); // Morado
            }
        } catch (NumberFormatException e) {
            mostrarError("Error");
        }
    }

    private void mostrarError(String msg) {
        tvArea.setText(msg);
        tvPerimetro.setText(msg);
        tvArea.setTextColor(Color.RED);
        tvPerimetro.setTextColor(Color.RED);
    }
}