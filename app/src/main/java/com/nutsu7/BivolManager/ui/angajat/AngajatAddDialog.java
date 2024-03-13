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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;

import org.w3c.dom.Text;

import java.util.Objects;

public class AngajatAddDialog extends AppCompatDialogFragment {
    private TextInputLayout angajatInputSurname;
    private TextInputLayout angajatInputName;
    private TextInputLayout angajatInputHR;
    private TextInputLayout angajatInputSalary;
    private TextInputLayout angajatInputDebt;
    private TextInputLayout angajatInputHours;


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

                    angajatInputSurname.setError(null);
                    angajatInputName.setError(null);
                    angajatInputHR.setError(null);
                    if(angajatInputSurname.getEditText().length()!=0) surname=extractStr(angajatInputSurname);
                    if(angajatInputName.getEditText().length()!=0) name=extractStr(angajatInputName);
                    if(angajatInputHR.getEditText().length()!=0)hr=Integer.parseInt(extractStr(angajatInputHR));
                    if(angajatInputSalary.getEditText().length()!=0) salary=Integer.parseInt(extractStr(angajatInputSalary));
                    if(angajatInputDebt.getEditText().length()!=0) debt=Integer.parseInt(extractStr(angajatInputDebt));
                    if(angajatInputHours.getEditText().length()!=0) hours=Integer.parseInt(extractStr(angajatInputHours));

                    if(checkInput(surname, name, hr)){
                        Angajat angajat=new Angajat(surname, name, hr, salary, debt, hours);
                        AppDB.getAppDB(getContext()).angajatDao().insert(angajat);
                        AngajatFragment.angajatList1.add(
                                AppDB.getAppDB(getContext()).angajatDao().getByID(AngajatFragment.angajatList1.size()+1)
                        );
                        RecyclerView rv = getActivity().findViewById(R.id.angajatListRV);
                        rv.getAdapter().notifyDataSetChanged();
                        dialog.dismiss();
                        Toast.makeText(getContext(),"Adaugat cu succes", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private boolean checkInput(String surname, String name, Integer hr) {
        boolean ans=true;
        if (surname == null) {
            angajatInputSurname.setError("Numele este necesar");
            ans=false;
        }

        if (name == null) {
            angajatInputName.setError("Prenumele este necesar");
            ans=false;
        }

        if (hr <= 0) {
            angajatInputHR.setError("Plata per ora este necesara");
            ans=false;
        }

        return ans;
    }

    private String extractStr(TextInputLayout textInputLayout){
        return textInputLayout.getEditText().getText().toString().trim();
    }
}
