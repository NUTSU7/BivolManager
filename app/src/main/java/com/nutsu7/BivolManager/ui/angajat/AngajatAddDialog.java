package com.nutsu7.BivolManager.ui.angajat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

import org.w3c.dom.Text;

import java.util.Objects;

public class AngajatAddDialog extends DialogFragment {
    private TextInputLayout angajatInputSurname;
    private TextInputLayout angajatInputName;
    private TextInputLayout angajatInputSalary;
    private TextInputLayout angajatInputDebt;

    private AngajatRepo angajatRepo;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());

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
        if(dialog!=null){
            Button positiveButton = (Button) dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleData(dialog);
                }
            });
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
    private void handleData(AlertDialog dialog){
        angajatRepo=new AngajatRepo(getContext());

        angajatInputSurname = dialog.findViewById(R.id.angajatInputSurname);
        angajatInputName = dialog.findViewById(R.id.angajatInputName);
        angajatInputSalary = dialog.findViewById(R.id.angajatInputSalary);
        angajatInputDebt = dialog.findViewById(R.id.angajatInputDebt);

        String surname=null,  name=null;
        Integer hr=0, salary=0, debt=0;

        angajatInputSurname.setError(null);
        angajatInputName.setError(null);
        if(angajatInputSurname.getEditText().length()!=0) surname=extractStr(angajatInputSurname);
        if(angajatInputName.getEditText().length()!=0) name=extractStr(angajatInputName);
        if(angajatInputSalary.getEditText().length()!=0) salary=Integer.parseInt(extractStr(angajatInputSalary));
        if(angajatInputDebt.getEditText().length()!=0) debt=Integer.parseInt(extractStr(angajatInputDebt));

        if(checkInput(surname, name, hr)){
            Angajat angajat = new Angajat(angajatRepo.getAll().size(), surname, name, salary, debt);
            angajatRepo.insert(angajat);

            dialog.dismiss();
            RecyclerView rv = getActivity().findViewById(R.id.angajatListRV);
            AngajatListAdaptor adaptor = (AngajatListAdaptor) rv.getAdapter();
            adaptor.updateList();
            adaptor.notifyItemInserted(angajat.getId());
            Toast.makeText(getContext(),angajat.getSurname()+" "+angajat.getName()+" a fost adaugat", Toast.LENGTH_SHORT).show();
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


        return ans;
    }

    private String extractStr(TextInputLayout textInputLayout){
        return textInputLayout.getEditText().getText().toString().trim();
    }
}
