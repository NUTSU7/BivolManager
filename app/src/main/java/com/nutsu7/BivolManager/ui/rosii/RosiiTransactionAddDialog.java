package com.nutsu7.BivolManager.ui.rosii;

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
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.rosii.Rosii;
import com.nutsu7.BivolManager.db.rosii.RosiiRepo;
import com.nutsu7.BivolManager.db.rosii.RosiiTransaction;
import com.nutsu7.BivolManager.ui.struguri.StruguriTransactionListAdaptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RosiiTransactionAddDialog extends DialogFragment {
    private MaterialTextView rosiiTranDateTextView;
    private TextInputLayout rosiiTranQuantity1Input1;
    private TextInputLayout rosiiTranQuantity1Input2;
    private TextInputLayout rosiiTranQuantity2Input1;
    private TextInputLayout rosiiTranQuantity2Input2;
    private TextInputLayout rosiiTranQuantity3Input1;
    private TextInputLayout rosiiTranQuantity3Input2;
    private TextInputLayout rosiiTranBoxNr1Input;
    private TextInputLayout rosiiTranBoxNr2Input;
    private TextInputLayout rosiiTranPriceInput1;
    private TextInputLayout rosiiTranPriceInput2;
    private MaterialButton rosiiTranDateChangeButton;

    private RosiiRepo rosiiRepo;
    private LocalDate date;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String dateStr, month;
    private Integer day, year;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_rosii_tran_add, null);


        builder.setView(view)
                .setTitle("Adauga tranzactie")
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
            rosiiRepo = new RosiiRepo(getContext());

            rosiiTranDateTextView = dialog.findViewById(R.id.rosiiTranDateTextView);
            rosiiTranQuantity1Input1 = dialog.findViewById(R.id.rosiiTranQuantity1Input1);
            rosiiTranQuantity1Input2 = dialog.findViewById(R.id.rosiiTranQuantity1Input2);
            rosiiTranQuantity2Input1 = dialog.findViewById(R.id.rosiiTranQuantity2Input1);
            rosiiTranQuantity2Input2 = dialog.findViewById(R.id.rosiiTranQuantity2Input2);
            rosiiTranQuantity3Input1 = dialog.findViewById(R.id.rosiiTranQuantity3Input1);
            rosiiTranQuantity3Input2 = dialog.findViewById(R.id.rosiiTranQuantity3Input2);
            rosiiTranBoxNr1Input = dialog.findViewById(R.id.rosiiTranBoxNrInput1);
            rosiiTranBoxNr2Input = dialog.findViewById(R.id.rosiiTranBoxNrInput2);
            rosiiTranPriceInput1 = dialog.findViewById(R.id.rosiiTranPriceInput1);
            rosiiTranPriceInput2 = dialog.findViewById(R.id.rosiiTranPriceInput2);
            rosiiTranDateChangeButton = dialog.findViewById(R.id.rosiiTranDateChangeButton);

            date = LocalDate.now();
            dateStr = date.format(formatters);
            rosiiTranDateTextView.setText(dateStr);

            String[] strings = dateStr.split("-");
            day = Integer.parseInt(strings[0]);
            String temp = Month.of(Integer.parseInt(strings[1])).getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
            month = temp.substring(0, 1).toUpperCase() + temp.substring(1);
            year = Integer.parseInt(strings[2]);

            Button positiveButton = (Button) dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleData(dialog);
                }
            });

            rosiiTranDateChangeButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker
                            .Builder
                            .datePicker()
                            .setTitleText("Alege Data")
                            .setPositiveButtonText("Ok")
                            .setNegativeButtonText("Anulare")
                            .build();
                    materialDatePicker.show(getChildFragmentManager(), "DATE_PICKER");

                    materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                        @Override
                        public void onPositiveButtonClick(Long selection) {
                            dateStr = dateFormat.format(selection);
                            rosiiTranDateTextView.setText(dateStr);
                            String[] strings = dateStr.split("-");
                            day = Integer.parseInt(strings[0]);
                            String temp = Month.of(Integer.parseInt(strings[1])).getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
                            month = temp.substring(0, 1).toUpperCase() + temp.substring(1);
                            year = Integer.parseInt(strings[2]);
                        }
                    });
                }
            });
        }

    }

    private void handleData(AlertDialog dialog){

        Integer  boxNr1=0, boxNr2=0;
        Double price1=0.0, price2=0.0;
        List<Double> quantity1 = Arrays.asList(0.0, 0.0, 0.0);
        List<Double> quantity2 = Arrays.asList(0.0, 0.0, 0.0);

        rosiiTranQuantity1Input1.setError(null);
        rosiiTranQuantity1Input2.setError(null);
        rosiiTranQuantity2Input1.setError(null);
        rosiiTranQuantity2Input2.setError(null);
        rosiiTranQuantity3Input1.setError(null);
        rosiiTranQuantity3Input2.setError(null);
        rosiiTranBoxNr1Input.setError(null);
        rosiiTranBoxNr2Input.setError(null);
        rosiiTranPriceInput1.setError(null);
        rosiiTranPriceInput2.setError(null);

        if(rosiiTranQuantity1Input1.getEditText().length()!=0) quantity1.set(0, Double.parseDouble(rosiiTranQuantity1Input1.getEditText().getText().toString()));
        if(rosiiTranQuantity1Input2.getEditText().length()!=0) quantity2.set(0, Double.parseDouble(rosiiTranQuantity1Input2.getEditText().getText().toString()));


        if(rosiiTranQuantity2Input1.getEditText().length()!=0) quantity1.set(1, Double.parseDouble(rosiiTranQuantity2Input1.getEditText().getText().toString()));
        if(rosiiTranQuantity2Input2.getEditText().length()!=0) quantity2.set(1, Double.parseDouble(rosiiTranQuantity2Input2.getEditText().getText().toString()));

        if(rosiiTranQuantity3Input1.getEditText().length()!=0) quantity1.set(2, Double.parseDouble(rosiiTranQuantity3Input1.getEditText().getText().toString()));
        if(rosiiTranQuantity3Input2.getEditText().length()!=0) quantity2.set(2, Double.parseDouble(rosiiTranQuantity3Input2.getEditText().getText().toString()));


        if(rosiiTranBoxNr1Input.getEditText().length()!=0) boxNr1 = Integer.parseInt(rosiiTranBoxNr1Input.getEditText().getText().toString());
        if(rosiiTranBoxNr2Input.getEditText().length()!=0) boxNr2 = Integer.parseInt(rosiiTranBoxNr2Input.getEditText().getText().toString());

        if(rosiiTranPriceInput1.getEditText().length()!=0) price1 = Double.parseDouble(rosiiTranPriceInput1.getEditText().getText().toString());
        if(rosiiTranPriceInput2.getEditText().length()!=0) price2 = Double.parseDouble(rosiiTranPriceInput2.getEditText().getText().toString());

        if(checkInput(quantity1,quantity2,boxNr1,boxNr2,price1,price2)){
            RosiiTransaction rosiiTransaction = new RosiiTransaction(rosiiRepo.getAllTransaction().size(),
                    quantity1,
                    quantity2,
                    boxNr1,
                    boxNr2,
                    price1,
                    price2,
                    day,
                    month,
                    year);

            rosiiRepo.insert(rosiiTransaction);

            Rosii rosii = rosiiRepo.get();
            Double temp1=quantity1.get(0)+quantity1.get(1)+quantity1.get(2),
                temp2=quantity2.get(0)+quantity2.get(1)+quantity2.get(2);
            rosii.addQuantitySold1(temp1);
            rosii.addQuantitySold2(temp2);

            rosii.decBoxCurrent1(boxNr1);
            rosii.decBoxCurrent2(boxNr2);

            rosii.addBoxSold1(boxNr1);
            rosii.addBoxSold2(boxNr2);

            rosii.addMoneyTotal1(temp1, price1);
            rosii.addMoneyTotal2(temp2, price2);

            rosiiRepo.update(rosii);

            dialog.dismiss();
            RecyclerView rv = getActivity().findViewById(R.id.rosiiTranListRV);
            RosiiTransactionListAdaptor adaptor = (RosiiTransactionListAdaptor) rv.getAdapter();
            adaptor.updateList();
            adaptor.notifyItemInserted(rosiiTransaction.getId());
            Toast.makeText(getContext(),"Transactie adaugata", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean checkInput(List<Double> quantity1, List<Double> quantity2, Integer boxNr1, Integer boxNr2, Double price1, Double price2){
        boolean ans = true;

        if(quantity1.get(0)==0 && quantity1.get(1)==0 && quantity1.get(2)==0 &&
                quantity2.get(0)==0 && quantity2.get(1)==0 && quantity2.get(2)==0){
            ans=false;
            Toast.makeText(getContext(),"Adauga informatie", Toast.LENGTH_SHORT).show();
        }

        if(quantity1.get(0)==null && quantity1.get(1)==null && quantity1.get(2)==null &&
                quantity2.get(0)==null && quantity2.get(1)==null && quantity2.get(2)==null){
            ans=false;
            Toast.makeText(getContext(),"Adauga informatie", Toast.LENGTH_SHORT).show();
        }

        if((boxNr1==0 || boxNr1==null) && (boxNr2==0 || boxNr2==null)){
            ans=false;
            rosiiTranBoxNr1Input.setError("Incomplet");
            rosiiTranBoxNr2Input.setError("Incomplet");
        }

        if((price1==0 || price1==null) && (price2==0 || price2==null)){
            ans=false;
            rosiiTranPriceInput1.setError("Incomplet");
            rosiiTranPriceInput2.setError("Incomplet");
        }

        return ans;
    }
}
