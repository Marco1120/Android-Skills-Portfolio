package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio8Activity extends AppCompatActivity {

    private EditText etUnidades, etPrecio;
    private Button btnCalcular, btnRegresar;
    private TextView tvTotalSinIva, tvIva, tvTotalConIva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio8);

        etUnidades = findViewById(R.id.etUnidades);
        etPrecio = findViewById(R.id.etPrecio);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnRegresar = findViewById(R.id.btnRegresar); // ← Botón agregado
        tvTotalSinIva = findViewById(R.id.tvTotalSinIva);
        tvIva = findViewById(R.id.tvIva);
        tvTotalConIva = findViewById(R.id.tvTotalConIva);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // ← Acción para volver al menú
            }
        });
    }

    private void calcular() {
        String unidadesTexto = etUnidades.getText().toString().trim();
        String precioTexto = etPrecio.getText().toString().trim();

        if (TextUtils.isEmpty(unidadesTexto) || TextUtils.isEmpty(precioTexto)) {
            Toast.makeText(this, "Llena ambos campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int unidades = Integer.parseInt(unidadesTexto);
            double precio = Double.parseDouble(precioTexto);

            if (unidades <= 0 || precio <= 0) {
                Toast.makeText(this, "Las unidades y el precio deben ser mayores que cero.", Toast.LENGTH_SHORT).show();
                return;
            }

            double totalSinIva = unidades * precio;
            double iva = totalSinIva * 0.16;
            double totalConIva = totalSinIva + iva;

            tvTotalSinIva.setText(String.format("Total sin IVA: $%.2f", totalSinIva));
            tvIva.setText(String.format("IVA (16%%): $%.2f", iva));
            tvTotalConIva.setText(String.format("Total con IVA: $%.2f", totalConIva));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce valores numéricos válidos.", Toast.LENGTH_SHORT).show();
        }
    }
}
