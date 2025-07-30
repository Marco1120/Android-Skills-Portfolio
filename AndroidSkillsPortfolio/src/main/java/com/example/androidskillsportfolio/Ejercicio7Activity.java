package com.example.androidskillsportfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio7Activity extends AppCompatActivity {

    private EditText txtNumero1, txtNumero2;
    private TextView lblSuma, lblResta, lblMultiplicacion, lblDivision, tvDescripcion7;
    private Button btnCalcular, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio7);

        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        lblSuma = findViewById(R.id.lblSuma);
        lblResta = findViewById(R.id.lblResta);
        lblMultiplicacion = findViewById(R.id.lblMultiplicacion);
        lblDivision = findViewById(R.id.lblDivision);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolver = findViewById(R.id.btnVolver);
        tvDescripcion7 = findViewById(R.id.tvDescripcion7);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOperaciones();
            }
        });

        btnVolver.setOnClickListener(v -> finish());
    }

    private void calcularOperaciones() {
        String s1 = txtNumero1.getText().toString().trim();
        String s2 = txtNumero2.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            lblSuma.setText("Suma: ");
            lblResta.setText("Resta: ");
            lblMultiplicacion.setText("Multiplicación: ");
            lblDivision.setText("División: Ingresa ambos números");
            lblDivision.setTextColor(Color.RED);
            return;
        }

        try {
            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);

            lblSuma.setText("Suma: " + (n1 + n2));
            lblResta.setText("Resta: " + (n1 - n2));
            lblMultiplicacion.setText("Multiplicación: " + (n1 * n2));
            lblDivision.setTextColor(Color.parseColor("#6A1B9A"));

            if (n2 == 0) {
                lblDivision.setText("División: Error (división por cero)");
                lblDivision.setTextColor(Color.RED);
            } else {
                lblDivision.setText("División: " + (n1 / n2));
            }
        } catch (NumberFormatException e) {
            lblSuma.setText("Suma: ");
            lblResta.setText("Resta: ");
            lblMultiplicacion.setText("Multiplicación: ");
            lblDivision.setText("División: Números inválidos");
            lblDivision.setTextColor(Color.RED);
        }
    }
}