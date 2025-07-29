package com.example.androidskillsportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnEjercicio1, btnEjercicio2, btnEjercicio3, btnEjercicio4, btnEjercicio5, btnEjercicio6, btnEjercicio7, btnEjercicio8, btnEjercicio9,  btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEjercicio1 = findViewById(R.id.btnEjercicio1);
        btnEjercicio2 = findViewById(R.id.btnEjercicio2);
        btnEjercicio3 = findViewById(R.id.btnEjercicio3);
        btnEjercicio4 = findViewById(R.id.btnEjercicio4);
        btnEjercicio5 = findViewById(R.id.btnEjercicio5);
        btnEjercicio6 = findViewById(R.id.btnEjercicio6);
        btnEjercicio7 = findViewById(R.id.btnEjercicio7);
        btnEjercicio8 = findViewById(R.id.btnEjercicio8);
        btnEjercicio9 = findViewById(R.id.btnEjercicio9);
        btnLogout = findViewById(R.id.btnLogout);

        btnEjercicio1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio1Activity.class)));
        btnEjercicio2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio2Activity.class)));
        btnEjercicio3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio3Activity.class)));
        btnEjercicio4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio4Activity.class)));
        btnEjercicio5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio5Activity.class)));
        btnEjercicio6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio6Activity.class)));
        btnEjercicio7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio7Activity.class)));
        btnEjercicio8.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio8Activity.class)));
        btnEjercicio9.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ejercicio9Activity.class)));
        btnLogout.setOnClickListener(v -> LoginActivity.logout(MainActivity.this));
    }
}