package com.example.calculadoradeimc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);




    }
    public void calcularImc(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double imc = peso / (altura * altura);

        if (imc >= 18.5 && imc <= 24.99) {
            textResultado.setText("Peso Normal = " + imc);
        } else if (imc >= 25 && imc <= 29.99) {
            textResultado.setText("Acima do Peso  = " + imc);

        } else if (imc >= 30 && imc <= 34.99) {
            textResultado.setText("Obsidade 1  = " + imc);

        } else if (imc >= 35 && imc <= 39.99) {
            textResultado.setText("Obsidade 2  = " + imc);

        } else if (imc > 40) {
            textResultado.setText("Obsidade 3  = " + imc);


        }


    }  }