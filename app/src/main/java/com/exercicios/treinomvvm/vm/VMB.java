package com.exercicios.treinomvvm.vm;

import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VMB extends ViewModel {
    public String textLetraB = "B";
    public String nomeUser;
    public String dataNascimentoUserVM;

    public int getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String dataNascimentoUser = dataNascimentoUserVM;
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
