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
    private TextView aqui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_c);

        aqui = findViewById(R.id.C);

        VMC = new ViewModelProvider(this).get(VMC.class);

        aqui.setText(VMC.teste);

        buttonC = findViewById(R.id.button_c);

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

}