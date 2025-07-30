package com.example.androidskillsportfolio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etUsername, etPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    private static final String REQUIRED_EMAIL = "tap2025@example.com";
    private static final String REQUIRED_PASSWORD = "tap*2025";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        if (isUserLoggedIn()) {
            redirectToMain();
            return;
        }

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void setupClickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        String email = "";
        String password = "";

        if (etUsername.getText() != null) {
            email = etUsername.getText().toString().trim();
        }

        if (etPassword.getText() != null) {
            password = etPassword.getText().toString().trim();
        }

        if (email.isEmpty()) {
            etUsername.setError("El correo es requerido");
            etUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("La contraseña es requerida");
            etPassword.requestFocus();
            return;
        }

        if (validateCredentials(email, password)) {
            saveLoginState(email);
            Toast.makeText(this, "Acceso autorizado", Toast.LENGTH_SHORT).show();
            redirectToMain();
        } else {
            Toast.makeText(this, "Credenciales incorrectas. Acceso denegado.", Toast.LENGTH_LONG).show();
            etPassword.setText("");
            etUsername.requestFocus();
        }
    }

    private boolean validateCredentials(String email, String password) {
        return email.equals(REQUIRED_EMAIL) && password.equals(REQUIRED_PASSWORD);
    }

    private void saveLoginState(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("userEmail", email);
        editor.apply();
    }

    private boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    private void redirectToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public static void logout(AppCompatActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(activity, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
}