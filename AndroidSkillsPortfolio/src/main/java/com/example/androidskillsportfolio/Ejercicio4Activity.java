package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio4Activity extends AppCompatActivity {

    RadioGroup groupPagos;
    RadioButton rbtnEfectivo, rbtnTarjeta, rbtnTransferencia;
    Button btnConfirmar;
    Button btnVolver; // ← Botón agregado
    TextView lblSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        groupPagos = findViewById(R.id.groupPagos);
        rbtnEfectivo = findViewById(R.id.rbtnEfectivo);
        rbtnTarjeta = findViewById(R.id.rbtnTarjeta);
        rbtnTransferencia = findViewById(R.id.rbtnTransferencia);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        lblSeleccion = findViewById(R.id.lblSeleccion);
        btnVolver = findViewById(R.id.btnVolver); // ← Referencia agregada

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtnEfectivo.isChecked()) {
                    lblSeleccion.setText("Seleccionaste: Efectivo");
                } else if (rbtnTarjeta.isChecked()) {
                    lblSeleccion.setText("Seleccionaste: Tarjeta");
                } else if (rbtnTransferencia.isChecked()) {
                    lblSeleccion.setText("Seleccionaste: Transferencia");
                } else {
                    lblSeleccion.setText("No se seleccionó ningún método de pago");
                }
            }
        });

        btnVolver.setOnClickListener(v -> finish()); // ← Acción para regresar al menú
    }
}
