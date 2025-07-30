package com.example.androidskillsportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEjercicio1 = findViewById(R.id.btnEjercicio1);
        Button btnEjercicio2 = findViewById(R.id.btnEjercicio2);
        Button btnEjercicio3 = findViewById(R.id.btnEjercicio3);
        Button btnEjercicio4 = findViewById(R.id.btnEjercicio4);
        Button btnEjercicio5 = findViewById(R.id.btnEjercicio5);
        Button btnEjercicio6 = findViewById(R.id.btnEjercicio6);
        Button btnEjercicio7 = findViewById(R.id.btnEjercicio7);
        Button btnEjercicio8 = findViewById(R.id.btnEjercicio8);
        Button btnEjercicio9 = findViewById(R.id.btnEjercicio9);
        Button btnEjercicio10 = findViewById(R.id.btnEjercicio10);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnEjercicio1.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio1Activity.class)));
        btnEjercicio2.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio2Activity.class)));
        btnEjercicio3.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio3Activity.class)));
        btnEjercicio4.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio4Activity.class)));
        btnEjercicio5.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio5Activity.class)));
        btnEjercicio6.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio6Activity.class)));
        btnEjercicio7.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio7Activity.class)));
        btnEjercicio8.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio8Activity.class)));
        btnEjercicio9.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio9Activity.class)));
        btnEjercicio10.setOnClickListener(v -> startActivity(new Intent(this, Ejercicio10Activity.class)));

        // ✅ Corrección: cerrar sesión y redirigir correctamente
        btnLogout.setOnClickListener(v -> {
            LoginActivity.logout(MainActivity.this);
        });
    }
}
