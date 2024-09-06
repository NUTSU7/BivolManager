package com.nutsu7.BivolManager.ui.struguri;

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
import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriRepo;
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class StruguriTransactionAddDialog extends DialogFragment {
    private MaterialTextView struguriTranDateTextView;
    private TextInputLayout struguriTranBuyerInput;
    private TextInputLayout struguriTranQuantityInput;
    private TextInputLayout struguriTranQuantityNRInput;
    private TextInputLayout struguriTranBoxNrInput;
    private TextInputLayout struguriTranBoxNRNrInput;
    private TextInputLayout struguriTranBoxWeightInput;
    private TextInputLayout struguriTranPriceInput;
    private TextInputLayout struguriTranPriceNoReceiptInput;
    private MaterialButton struguriTranDateChangeButton;

    private StruguriRepo struguriRepo;
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
        View view = inflater.inflate(R.layout.dialog_struguri_tran_add, null);


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

            struguriRepo= new StruguriRepo(getContext());

            struguriTranDateTextView = dialog.findViewById(R.id.struguriTranDateTextView);
            struguriTranBuyerInput = dialog.findViewById(R.id.struguriTranBuyerInput);
            struguriTranQuantityInput = dialog.findViewById(R.id.struguriTranQuantityInput);
            struguriTranQuantityNRInput = dialog.findViewById(R.id.struguriTranQuantityNRInput);
            struguriTranBoxNrInput = dialog.findViewById(R.id.struguriTranBoxNrInput);
            struguriTranBoxNRNrInput = dialog.findViewById(R.id.struguriTranBoxNRNrInput);
            struguriTranBoxWeightInput = dialog.findViewById(R.id.struguriTranBoxWeightInput);
            struguriTranPriceInput = dialog.findViewById(R.id.struguriTranPriceInput);
            struguriTranPriceNoReceiptInput = dialog.findViewById(R.id.struguriTranPriceNoReceiptInput);
            struguriTranDateChangeButton = dialog.findViewById(R.id.struguriTranDateChangeButton);

            date = LocalDate.now();
            dateStr = date.format(formatters);
            struguriTranDateTextView.setText(dateStr);

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

            struguriTranDateChangeButton.setOnClickListener(new Button.OnClickListener() {
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
                            struguriTranDateTextView.setText(dateStr);
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
        String buyer="";
        Integer  boxNr=0, boxNRNr=0;
        Double quantity=0.0, quantityNR=0.0 ,boxWeight=0.0, price=0.0, priceNoReceipt=0.0;

        struguriTranBuyerInput.setError(null);
        struguriTranQuantityInput.setError(null);
        struguriTranQuantityNRInput.setError(null);
        struguriTranBoxNrInput.setError(null);
        struguriTranBoxNRNrInput.setError(null);
        struguriTranBoxWeightInput.setError(null);
        struguriTranPriceInput.setError(null);
        struguriTranPriceNoReceiptInput.setError(null);

        if(struguriTranBuyerInput.getEditText().length()!=0) buyer=struguriTranBuyerInput.getEditText().getText().toString().trim();
        if(struguriTranQuantityInput.getEditText().length()!=0) quantity=Double.parseDouble(struguriTranQuantityInput.getEditText().getText().toString());
        if(struguriTranQuantityNRInput.getEditText().length()!=0) quantityNR=Double.parseDouble(struguriTranQuantityNRInput.getEditText().getText().toString());
        if(struguriTranBoxNrInput.getEditText().length()!=0) boxNr=Integer.parseInt(struguriTranBoxNrInput.getEditText().getText().toString());
        if(struguriTranBoxNRNrInput.getEditText().length()!=0) boxNRNr=Integer.parseInt(struguriTranBoxNRNrInput.getEditText().getText().toString());
        if(struguriTranBoxWeightInput.getEditText().length()!=0) boxWeight=Double.parseDouble(struguriTranBoxWeightInput.getEditText().getText().toString());
        if(struguriTranPriceInput.getEditText().length()!=0) price=Double.parseDouble(struguriTranPriceInput.getEditText().getText().toString());
        if(struguriTranPriceNoReceiptInput.getEditText().length()!=0) priceNoReceipt=Double.parseDouble(struguriTranPriceNoReceiptInput.getEditText().getText().toString());



        if(checkInput(buyer, quantity, quantityNR, boxNr, boxNRNr, boxWeight, price, priceNoReceipt)){
            StruguriTransaction struguriTransaction = new StruguriTransaction(struguriRepo.getAllTransaction().size(),
                    buyer,
                    quantity,
                    quantityNR,
                    boxNr,
                    boxNRNr,
                    boxWeight,
                    price,
                    priceNoReceipt,
                    day,
                    month,
                    year);
            struguriRepo.insert(struguriTransaction);

            //Add safety check to not exceed the current quantity and the harvested quantity
            //StruguriTransaction struguriTransaction1 = struguriRepo.getTransactionByID(struguriRepo.getAllTransaction().size()-1);
            Struguri struguri = struguriRepo.get();
            struguri.decBoxCurrent(boxNr+boxNRNr);
            struguri.addBoxSold(boxNr+boxNRNr);
            struguri.addQuantitySold(struguriTransaction.getQuantity()+struguriTransaction.getQuantityNoReceipt());
            struguri.addMoneyTotal(struguriTransaction.getQuantity()*price);
            struguri.addMoneyNRTotal(struguriTransaction.getQuantityNoReceipt()*priceNoReceipt);
            struguriRepo.update(struguri);


            dialog.dismiss();
            RecyclerView rv = getActivity().findViewById(R.id.struguriTranListRV);
            StruguriTransactionListAdaptor adaptor = (StruguriTransactionListAdaptor) rv.getAdapter();
            adaptor.updateList();
            adaptor.notifyItemInserted(struguriTransaction.getId());
            Toast.makeText(getContext(),"Transactie adaugata", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean checkInput(String buyer, Double quantity, Double quantityNR,  Integer boxNr, Integer boxNRNr, Double boxWeight, Double price, Double priceNoReceipt) {
        boolean ans=true, t=true;
        if (buyer == null || buyer.isEmpty()) {
            struguriTranBuyerInput.setError("Incomplet");
            ans=false;
        }

        if((quantity==0.0 && (boxNr!=0 || price!=0.0))){
            struguriTranQuantityInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((boxNr==0 && (quantity!=0.0 || price!=0.0))){
            struguriTranBoxNrInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((price==0.0 && (boxNr!=0 || quantity!=0.0))){
            struguriTranPriceInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((quantityNR==0.0 && (boxNRNr!=0 || priceNoReceipt!=0.0))){
            struguriTranQuantityNRInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((boxNRNr==0 && (quantityNR!=0.0 || priceNoReceipt!=0.0))){
            struguriTranBoxNRNrInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((priceNoReceipt==0.0 && (boxNRNr!=0 || quantityNR!=0.0))){
            struguriTranPriceNoReceiptInput.setError("Incomplet");
            ans=false;
            t=false;
        }

        if((boxNr!=0 || boxNRNr!=0) && boxWeight==0.0){
            struguriTranBoxWeightInput.setError("Incomplet");
            ans=false;
        }

        if (quantity==0.0 && quantityNR==0.0 && t) {
            struguriTranQuantityInput.setError("Incomplet");
            struguriTranQuantityNRInput.setError("Incomplet");
            ans=false;
        }

        return ans;
    }
}
