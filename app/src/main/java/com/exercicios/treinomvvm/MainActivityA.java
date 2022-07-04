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
import android.widget.Toast;

import com.exercicios.treinomvvm.vm.VMA;

public class MainActivityA extends AppCompatActivity {

    VMA VMA;
    private Button buttonA;
    private TextView textLetraA;
    private EditText textNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);

        getView();

        VMA = new ViewModelProvider(this).get(VMA.class);

        textLetraA.setText(VMA.textLetraA);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validador();
            }
        });
    }

    public void getView(){
        textLetraA = findViewById(R.id.A);
        textNome = findViewById(R.id.nome);
        buttonA = findViewById(R.id.button_a);
    }


    public void validador(){
        if (!textNome.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivityA.this, MainActivityB.class);
            String dadosDigtUser = textNome.getText().toString();
            VMA.nome = dadosDigtUser;

            intent.putExtra("resultado", dadosDigtUser);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivityA.this, getString(R.string.mensagemNome), Toast.LENGTH_SHORT).show();
        }
    }

}