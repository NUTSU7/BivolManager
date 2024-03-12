package com.nutsu7.BivolManager.ui.angajat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;

import java.util.Objects;

public class AngajatAddDialog extends AppCompatDialogFragment {
    private EditText angajatInputSurname;
    private EditText angajatInputName;
    private EditText angajatInputHR;
    private EditText angajatInputSalary;
    private EditText angajatInputDebt;
    private EditText angajatInputHours;


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
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Adauga", null);

        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        AlertDialog dialog = (AlertDialog) getDialog();
        View view = getView();
        //angajatInputSurname = dialog.findViewById()
        angajatInputSurname = dialog.findViewById(R.id.angajatInputSurname);
        angajatInputName = dialog.findViewById(R.id.angajatInputName);
        angajatInputHR = dialog.findViewById(R.id.angajatInputHR);
        angajatInputSalary = dialog.findViewById(R.id.angajatInputSalary);
        angajatInputDebt = dialog.findViewById(R.id.angajatInputDebt);
        angajatInputHours = dialog.findViewById(R.id.angajatInputHours);
        if(dialog!=null){
            Button positiveButton = (Button) dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String surname=null,  name=null;
                    Integer hr=0, salary=0, debt=0, hours=0;
                    if(angajatInputSurname.length()!=0) surname=angajatInputSurname.getText().toString().trim();
                    if(angajatInputName.length()!=0) name=angajatInputName.getText().toString().trim();
                    if(angajatInputHR.length()!=0)hr=Integer.parseInt(angajatInputHR.getText().toString().trim());
                    if(angajatInputSalary.length()!=0) salary=Integer.parseInt(angajatInputSalary.getText().toString().trim());
                    if(angajatInputDebt.length()!=0) debt=Integer.parseInt(angajatInputDebt.getText().toString().trim());
                    if(angajatInputHours.length()!=0) hours=Integer.parseInt(angajatInputHours.getText().toString().trim());

                    if(checkInput(surname, name, hr)){
                        Angajat angajat=new Angajat(surname, name, hr, salary, debt, hours);
                        AppDB.getAppDB(getContext()).angajatDao().insert(angajat);
                        AngajatFragment.angajatList1.add(
                                AppDB.getAppDB(getContext()).angajatDao().getByID(AngajatFragment.angajatList1.size()+1)
                        );
                        dialog.cancel();
                    }
                }
            });
        }
    }

    private boolean checkInput(String surname, String name, Integer hr) {
        if (angajatInputSurname.length() == 0) {
            angajatInputSurname.setError("Numele este necesar");
            return false;
        }

        if (angajatInputName.length() == 0) {
            angajatInputName.setError("Prenumele este necesar");
            return false;
        }

        if (angajatInputHR.length()==0) {
            angajatInputHR.setError("Plata per ora este necesara");
            return false;
        }

        return true;
    }
}
