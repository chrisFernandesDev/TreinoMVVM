package com.exercicios.treinomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exercicios.treinomvvm.vm.VMC;

public class MainActivityC extends AppCompatActivity {

    VMC VMC;
    private Button buttonC;
    private TextView textLetraC;
    private TextView nomeUser;
    private TextView dataNascimentoUser;
    private TextView idadeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_c);

        getView();

        VMC = new ViewModelProvider(this).get(VMC.class);

        setText();


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivityA.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void getView(){
        textLetraC = findViewById(R.id.C);
        nomeUser = findViewById(R.id.nome_user);
        dataNascimentoUser = findViewById(R.id.data_nascimento_user);
        idadeUser = findViewById(R.id.idade_user);
        buttonC = findViewById(R.id.button_c);
    }

    public void setText(){

        Intent intent = getIntent();
        String dadosRecebidosNome = intent.getStringExtra("nome");
        String dadosRecebidoNascimento = intent.getStringExtra("dataNascimento");
        String dadosRecebidoIdade = intent.getStringExtra("idade");

        VMC.dataNascimentoUserVM = dadosRecebidoNascimento;
        textLetraC.setText(VMC.textLetraC);
        nomeUser.setText(dadosRecebidosNome);
        dataNascimentoUser.setText(dadosRecebidoNascimento);
        idadeUser.setText(dadosRecebidoIdade + " anos");
    }
}