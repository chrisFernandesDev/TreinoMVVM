package com.exercicios.treinomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.exercicios.treinomvvm.vm.VMA;

public class MainActivityA extends AppCompatActivity {

    VMA VMA;
    private Button buttonA;
    private TextView aqui;
    private EditText textNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);
        aqui = findViewById(R.id.A);
        textNome = findViewById(R.id.nome);

        VMA = new ViewModelProvider(this).get(VMA.class);

        aqui.setText(VMA.teste);

        buttonA = findViewById(R.id.button_a);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityA.this, MainActivityB.class);
                String dadosDigtUser = textNome.getText().toString();
                VMA.nome = dadosDigtUser;
                Log.d("Teste1", VMA.nome);
                startActivity(intent);
            }
        });
    }

}