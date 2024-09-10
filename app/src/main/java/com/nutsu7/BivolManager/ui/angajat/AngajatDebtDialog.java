package com.nutsu7.BivolManager.ui.angajat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputLayout;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

public class AngajatDebtDialog extends DialogFragment {
    private TextInputLayout angajatInput;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_angajat_debt, null);


        builder.setView(view)
                .setTitle("Adauga Datorie")
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
        Integer sum=0;
        AngajatRepo angajatRepo = new AngajatRepo(getContext());

        angajatInput = dialog.findViewById(R.id.angajatInputDebt);
        angajatInput.setError(null);

        if(angajatInput.getEditText().length()!=0) sum=Integer.parseInt(angajatInput.getEditText().getText().toString().trim());

        if(checkInput(sum)){
            Angajat angajat = angajatRepo.getByID(getArguments().getInt("arg"));
            angajat.addDebt(sum);
            angajatRepo.update(angajat);

            dialog.dismiss();
            Toast.makeText(getContext(),"Datorie adaugata", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkInput(Integer sum) {
        if (sum == null || sum == 0) {
            angajatInput.setError("Suma invalida");
            return false;
        }

        return true;
    }
}
