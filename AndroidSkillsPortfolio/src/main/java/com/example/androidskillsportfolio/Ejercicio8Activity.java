package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio8Activity extends AppCompatActivity {

    private EditText txtPrecioBase;
    private ToggleButton tbtnInstalacion, tbtnFormacion, tbtnAlimentacionBD;
    private TextView lblPrecioInstalacion, lblPrecioFormacion, lblPrecioAlimentacionBD, lblTotal, tvDescripcion8;
    private Button btnCalcular, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio8);

        txtPrecioBase = findViewById(R.id.txtPrecioBase);
        tbtnInstalacion = findViewById(R.id.tbtnInstalacion);
        tbtnFormacion = findViewById(R.id.tbtnFormacion);
        tbtnAlimentacionBD = findViewById(R.id.tbtnAlimentacionBD);
        lblPrecioInstalacion = findViewById(R.id.lblPrecioInstalacion);
        lblPrecioFormacion = findViewById(R.id.lblPrecioFormacion);
        lblPrecioAlimentacionBD = findViewById(R.id.lblPrecioAlimentacionBD);
        lblTotal = findViewById(R.id.lblTotal);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolver = findViewById(R.id.btnVolver);
        tvDescripcion8 = findViewById(R.id.tvDescripcion8);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularTotal();
            }
        });

        btnVolver.setOnClickListener(view -> finish());
    }

    private void calcularTotal() {
        String sPrecioBase = txtPrecioBase.getText().toString().trim();
        double precioTotal = 0.0;
        try {
            double precioBase = Double.parseDouble(sPrecioBase);
            precioTotal = precioBase;

            if (tbtnInstalacion.isChecked()) {
                precioTotal += Double.parseDouble(lblPrecioInstalacion.getText().toString());
            }
            if (tbtnFormacion.isChecked()) {
                precioTotal += Double.parseDouble(lblPrecioFormacion.getText().toString());
            }
            if (tbtnAlimentacionBD.isChecked()) {
                precioTotal += Double.parseDouble(lblPrecioAlimentacionBD.getText().toString());
            }
            lblTotal.setText("Total: " + precioTotal + " $");
            lblTotal.setTextColor(Color.parseColor("#2E7D32"));
        } catch (NumberFormatException e) {
            lblTotal.setText("Total: Valor base inválido");
            lblTotal.setTextColor(Color.RED);
        }
    }
}