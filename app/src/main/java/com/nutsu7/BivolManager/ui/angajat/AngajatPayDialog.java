package com.nutsu7.BivolManager.ui.angajat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

public class AngajatPayDialog extends DialogFragment {
    private TextInputLayout angajatInput;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_angajat_pay, null);
        //View view = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.dialog_angajat_pay, null);


        builder.setView(view)
                .setTitle("Plateste Angajat")
                .setNegativeButton("Anulare", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Plateste", null);

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
        Angajat angajat = angajatRepo.getByID(getArguments().getInt("arg"));
        angajatInput = dialog.findViewById(R.id.angajatInputPay);
        Boolean checked = ((SwitchMaterial)dialog.findViewById(R.id.paySwitch)).isChecked();

        angajatInput.setError(null);

        if(angajatInput.getEditText().length()!=0) sum=Integer.parseInt(angajatInput.getEditText().getText().toString().trim());

        if(checkInput(sum, angajat, checked)){
            if(!checked){
                angajat.decreaseSalary(sum);
            }
            else{
                if(sum>angajat.getDebt()){
                    int temp = (angajat.getDebt()-sum)*(-1);
                    angajat.setDebt(0);
                    angajat.decreaseSalary(temp);
                }
                else angajat.decreaseDebt(sum);

            }
            angajatRepo.update(angajat);

            dialog.dismiss();
            Toast.makeText(getContext(),"Plata efectuata", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkInput(Integer sum, Angajat angajat, Boolean checked) {
        if(sum == null || sum == 0){
            angajatInput.setError("Suma invalida");
            return false;
        }
        if(!checked){
            if(sum>angajat.getSalary()){
                angajatInput.setError("Suma depaseste salariul curent");
                return false;
            }
            return true;
        }

        if (sum>angajat.getSalary()+ angajat.getDebt()) {
            angajatInput.setError("Suma depaseste datoria si salariul");
            return false;
        }

        return true;
    }
}
