package com.exercicios.treinomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.exercicios.treinomvvm.vm.VMB;

public class MainActivityB extends AppCompatActivity {

    VMB VMB;
    private Button buttonB;
    private TextView textLetraB;
    private EditText dataNascimento;

    String nomeUser;
    String idadeUser;
    String dataNascimentoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        getView();
        getVM();

        textLetraB.setText(VMB.textLetraB);

        buttonB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getRespostas();

                Intent intent = new Intent(MainActivityB.this, MainActivityC.class);
                intent.putExtra("dataNascimento", dataNascimentoUser);
                intent.putExtra("nome", nomeUser);
                intent.putExtra("idade", idadeUser);

                startActivity(intent);
            }
        });
    }

    public void getView(){
        textLetraB = findViewById(R.id.B);
        dataNascimento = findViewById(R.id.data_nascimento);
        buttonB = findViewById(R.id.button_b);
    }

    public void getVM(){
        VMB = new ViewModelProvider(this).get(VMB.class);
    }

    public void getRespostas(){
        Intent intent = getIntent();
        String dadosRecebidos = intent.getStringExtra("resultado");

        dataNascimentoUser = dataNascimento.getText().toString();

        VMB.nomeUser = dadosRecebidos;
        VMB.dataNascimentoUserVM = dataNascimentoUser;

        nomeUser = VMB.nomeUser;
        idadeUser = String.valueOf(VMB.getDateTime());
    }

}