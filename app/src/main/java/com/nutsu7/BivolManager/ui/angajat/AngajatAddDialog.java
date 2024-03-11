package com.nutsu7.BivolManager.ui.angajat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.nutsu7.BivolManager.R;

public class AngajatAddDialog extends AppCompatDialogFragment {
    private EditText angajatInputSurname;
    private EditText angajatInputName;
    private EditText angajatInputHR;
    private EditText angajatInputSalary;
    private EditText angajatInputDebt;
    private EditText angajatInputOre;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_angajat_add, null);

        builder.setView(view)
                .setTitle("Adauga Angajat")
                .setNegativeButton("Anulare", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Adauga", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        angajatInputSurname = view.findViewById(R.id.angajatInputSurname);
        angajatInputName = view.findViewById(R.id.angajatInputName);
        angajatInputHR = view.findViewById(R.id.angajatInputHR);
        angajatInputSalary = view.findViewById(R.id.angajatInputSalary);
        angajatInputDebt = view.findViewById(R.id.angajatInputDebt);
        angajatInputOre = view.findViewById(R.id.angajatInputOre);

        return builder.create();
    }

    public interface AnagajatAddListener{
        void saveText(String surname, String name, int hourlyRate, int salary, int debt, int hours);
    }
}
