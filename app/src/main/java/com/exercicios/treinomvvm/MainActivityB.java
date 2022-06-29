package com.exercicios.treinomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exercicios.treinomvvm.vm.VMA;
import com.exercicios.treinomvvm.vm.VMB;

public class MainActivityB extends AppCompatActivity {

    VMB VMB;
    private Button buttonB;
    private TextView aqui;
    private TextView mostrar_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        aqui = findViewById(R.id.B);
        mostrar_nome = findViewById(R.id.mostrar_nome);

        VMB = new ViewModelProvider(this).get(VMB.class);

        Log.d("nomeUser", String.valueOf(mostrar_nome));

        aqui.setText(VMB.teste);

        Log.d("Teste", String.valueOf(mostrar_nome));

        buttonB = findViewById(R.id.button_b);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityB.this, MainActivityC.class);
                startActivity(intent);
            }
        });
    }
}