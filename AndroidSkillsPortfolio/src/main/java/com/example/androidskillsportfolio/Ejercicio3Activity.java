package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3Activity extends AppCompatActivity {

    private EditText txtNombre, txtCiudad;
    private TextView lblFrase;
    private Button btnAceptar, btnDesactivar, btnActivar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        // Inicializar componentes
        txtNombre = findViewById(R.id.txtNombre);
        txtCiudad = findViewById(R.id.txtCiudad);
        lblFrase = findViewById(R.id.lblFrase);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnDesactivar = findViewById(R.id.btnDesactivar);
        btnActivar = findViewById(R.id.btnActivar);
        btnVolver = findViewById(R.id.btnVolver);

        // Configurar listeners
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptarActionPerformed();
            }
        });

        btnDesactivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDesactivarActionPerformed();
            }
        });

        btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivarActionPerformed();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y vuelve al MainActivity
            }
        });
    }

    private void btnAceptarActionPerformed() {
        String nombre = txtNombre.getText().toString().trim();
        String ciudad = txtCiudad.getText().toString().trim();

        // Validar que los campos no estén vacíos
        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(ciudad)) {
            Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_SHORT).show();
            lblFrase.setText("Complete todos los campos para ver el mensaje");
        } else {
            // Mostrar el mensaje personalizado
            lblFrase.setText("Usted se llama " + nombre + " y vive en " + ciudad);
        }
    }

    private void btnDesactivarActionPerformed() {
        // Verificar si los campos están habilitados antes de desactivar
        if (txtNombre.isEnabled() && txtCiudad.isEnabled()) {
            txtNombre.setEnabled(false);
            txtCiudad.setEnabled(false);

            // Cambiar la apariencia visual para indicar que están desactivados
            txtNombre.setAlpha(0.5f);
            txtCiudad.setAlpha(0.5f);

            Toast.makeText(this, "Campos desactivados", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Los campos ya están desactivados", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnActivarActionPerformed() {
        // Verificar si los campos están deshabilitados antes de activar
        if (!txtNombre.isEnabled() && !txtCiudad.isEnabled()) {
            txtNombre.setEnabled(true);
            txtCiudad.setEnabled(true);

            // Restaurar la apariencia visual normal
            txtNombre.setAlpha(1.0f);
            txtCiudad.setAlpha(1.0f);

            Toast.makeText(this, "Campos activados", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Los campos ya están activados", Toast.LENGTH_SHORT).show();
        }
    }
}