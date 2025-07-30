package com.example.androidskillsportfolio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio9Activity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView lblValor, tvDescripcion9;
    private Button btnVolver;

    // SeekBar va de 0 a 100, pero el valor real es de 50 a 150
    private final int MIN = 50, MAX = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio9);

        seekBar = findViewById(R.id.seekBar);
        lblValor = findViewById(R.id.lblValor);
        tvDescripcion9 = findViewById(R.id.tvDescripcion9);
        btnVolver = findViewById(R.id.btnVolver);

        seekBar.setMax(MAX - MIN);
        seekBar.setProgress(0);
        lblValor.setText("El valor es: " + MIN);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valor = MIN + progress;
                lblValor.setText("El valor es: " + valor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnVolver.setOnClickListener(v -> finish());
    }
}