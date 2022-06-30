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

import com.exercicios.treinomvvm.vm.VMB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivityB extends AppCompatActivity {

    VMB VMB;
    private Button buttonB;
    private TextView aqui;
    private EditText dataNascimento;

    String nomeUser;
    String idadeUser;
    String dataNascimentoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        aqui = findViewById(R.id.B);
        dataNascimento = findViewById(R.id.data_nascimento);

        Intent intent = getIntent();
        String dadosRecebidos = intent.getStringExtra("resultado");

        VMB = new ViewModelProvider(this).get(VMB.class);

        aqui.setText(VMB.teste);


        buttonB = findViewById(R.id.button_b);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataNascimentoUser = dataNascimento.getText().toString();

                VMB.nomeUser = dadosRecebidos;
                VMB.idadeUSer = String.valueOf(getDateTime());

                nomeUser = VMB.nomeUser;
                idadeUser = VMB.idadeUSer;

                Intent intent = new Intent(MainActivityB.this, MainActivityC.class);

                intent.putExtra("dataNascimento", dataNascimentoUser);
                intent.putExtra("nome", nomeUser);
                intent.putExtra("idade", idadeUser);

                startActivity(intent);
            }
        });
    }

    private int getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String dataNascimentoUser = dataNascimento.getText().toString();
            Date dataUser = dateFormat.parse(String.valueOf(dataNascimentoUser));
            int idadeUser = getIdade(dataUser);

            String respostaIdade = String.valueOf(idadeUser);

            return Integer.parseInt(respostaIdade);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getIdade(Date date) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        int age = 0;

        birthDate.setTime(date);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Erro");
        }

        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
                (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
            age--;

        } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH)) &&
                (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }
}