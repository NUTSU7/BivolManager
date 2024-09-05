package com.nutsu7.BivolManager.ui.home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;
import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriRepo;
import com.nutsu7.BivolManager.db.zi.Zi;
import com.nutsu7.BivolManager.db.zi.ZiRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ZiAddDialog extends DialogFragment {
    private TextInputLayout dateInputInfo;
    private TextInputLayout dateInputHours;
    private MaterialTextView dateTextView;
    private RecyclerView rv;
    private ZiAngajatListAdaptor ziAngajatListAdaptor;
    private MaterialButton dateChangeButton;
    private MaterialCheckBox rosiiCheckBox;
    private MaterialCheckBox struguriCheckBox;
    private TextInputLayout dateQuantity1Input;
    private TextInputLayout dateQuantity2Input;

    private ZiRepo ziRepo;
    private AngajatRepo angajatRepo;
    private StruguriRepo struguriRepo;
    private Integer hours;
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
        View view = inflater.inflate(R.layout.dialog_zi_add, null);


        builder.setView(view)
                .setTitle("Adauga Zi")
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
            ziRepo=new ZiRepo(getContext());
            angajatRepo= new AngajatRepo(getContext());
            struguriRepo = new StruguriRepo(getContext());

            rv = dialog.findViewById(R.id.dateAngListRV);
            dateInputInfo = dialog.findViewById(R.id.dateInputInfo);
            dateInputHours = dialog.findViewById(R.id.dateInputHours);
            dateChangeButton = dialog.findViewById(R.id.dateChangeButton);
            dateTextView = dialog.findViewById(R.id.dateTextView);
            rosiiCheckBox = dialog.findViewById(R.id.rosiiCheckBox);
            struguriCheckBox = dialog.findViewById(R.id.struguriCheckBox);
            dateQuantity1Input = dialog.findViewById(R.id.dateQuantity1Input);
            dateQuantity2Input = dialog.findViewById(R.id.dateQuantity2Input);

            dateInputHours.getEditText().setImeOptions(EditorInfo.IME_ACTION_DONE);
            date = LocalDate.now();
            dateStr = date.format(formatters);
            dateTextView.setText(dateStr);

            String[] strings = dateStr.split("-");
            day = Integer.parseInt(strings[0]);
            String temp = Month.of(Integer.parseInt(strings[1])).getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
            month = temp.substring(0, 1).toUpperCase() + temp.substring(1);
            year = Integer.parseInt(strings[2]);

            dateQuantity1Input.setEnabled(false);
            dateQuantity2Input.setEnabled(false);

            rv.setAdapter(new ZiAngajatListAdaptor(requireActivity()));
            ziAngajatListAdaptor= (ZiAngajatListAdaptor)rv.getAdapter();
            Button positiveButton = (Button) dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleData(dialog);
                }
            });


            dateInputHours.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    if(dateInputHours.getEditText().length()!=0) {
                        hours=Integer.parseInt(dateInputHours.getEditText().getText().toString().trim());
                        ziAngajatListAdaptor.updateHours(hours);
                    }
                }
            });

            dateChangeButton.setOnClickListener(new Button.OnClickListener() {
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
                            dateTextView.setText(dateStr);
                            String[] strings = dateStr.split("-");
                            day = Integer.parseInt(strings[0]);
                            String temp = Month.of(Integer.parseInt(strings[1])).getDisplayName(TextStyle.FULL, new Locale("ro", "RO"));
                            month = temp.substring(0, 1).toUpperCase() + temp.substring(1);
                            year = Integer.parseInt(strings[2]);
                        }
                    });
                }
            });

            rosiiCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked && struguriCheckBox.isChecked()){
                        rosiiCheckBox.setChecked(false);
                        Toast.makeText(getContext(),"Struguri este selectat", Toast.LENGTH_SHORT).show();
                    }
                    if(isChecked){
                        dateQuantity1Input.setEnabled(true);
                        dateQuantity2Input.setEnabled(true);
                    }
                    else{
                        dateQuantity1Input.setEnabled(false);
                        dateQuantity2Input.setEnabled(false);
                        if(dateQuantity1Input.getError()!=null) dateQuantity1Input.setError(null);
                        if(dateQuantity2Input.getError()!=null) dateQuantity2Input.setError(null);
                    }
                }
            });
            struguriCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked && rosiiCheckBox.isChecked()){
                        struguriCheckBox.setChecked(false);
                        Toast.makeText(getContext(),"Rosii este selectat", Toast.LENGTH_SHORT).show();
                    }
                    if(isChecked){
                        dateQuantity1Input.setEnabled(true);
                    }
                    else {
                        dateQuantity1Input.setEnabled(false);
                        if(dateQuantity1Input.getError()!=null) dateQuantity1Input.setError(null);
                    }
                }
            });
        }
    }
    private void handleData(AlertDialog dialog){

        dateInputHours.setError(null);
        dateQuantity1Input.setError(null);
        dateQuantity2Input.setError(null);
        dateInputInfo.setError(null);


        Integer hr=0, quantity1=0, quantity2=0;
        String info="", work="---";
        if(dateInputHours.getEditText().length()!=0) hr=Integer.parseInt(dateInputHours.getEditText().getText().toString().trim());
        if(dateInputInfo.getEditText().length()!=0) info=dateInputInfo.getEditText().getText().toString();
        if(dateQuantity1Input.isEnabled() && dateQuantity1Input.getEditText().length()!=0) quantity1=Integer.parseInt(dateQuantity1Input.getEditText().getText().toString().trim());
        if(dateQuantity2Input.isEnabled() && dateQuantity2Input.getEditText().length()!=0) quantity2=Integer.parseInt(dateQuantity2Input.getEditText().getText().toString().trim());
        if(dateQuantity1Input.isEnabled()){
            if(rosiiCheckBox.isChecked()){
                work="Rosii";
            }
            else if(struguriCheckBox.isChecked()){
                work="Struguri";
            }
        }

        if(checkInput(hr, info, work)){
            Zi zi = new Zi(ziRepo.getAll().size(), day, month, year, info, hr, work, quantity1, quantity2);
            ziRepo.insert(zi);

            if(work=="Struguri"){
                Struguri struguri=struguriRepo.get();
                struguri.addDaysWorked(1);
                struguri.addBoxHarvested(quantity1);
                struguri.addBoxCurrent(quantity1);
                struguriRepo.update(struguri);
            }

            List<List<Integer>> angajatRVList = ziAngajatListAdaptor.getAngajatList();
            List<Pair<Integer,Integer>> angajatList = new ArrayList<>();

            for(int i=0; i<angajatRVList.size(); i++){
                if(angajatRVList.get(i).get(2)==1) {
                    angajatList.add(new Pair<>(angajatRVList.get(i).get(0), angajatRVList.get(i).get(1)));
                }
            }
           ziRepo.insertAngajati(zi.getId(), angajatList);

            dialog.dismiss();
            RecyclerView rv1 = getActivity().findViewById(R.id.ziListRV);
            ZiListAdaptor adaptor1 = (ZiListAdaptor) rv1.getAdapter();
            adaptor1.updateList();
            adaptor1.notifyItemInserted(zi.getId());
            Toast.makeText(getContext(),"Zi adaugata", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean checkInput(Integer hr, String info, String work) {
        boolean ans=true;
        if (hr == 0) {
            dateInputHours.setError("Incomplet");
            ans=false;
        }

        if (hr >24) {
            dateInputHours.setError("Prea multe ore intr-o zi");
            ans=false;
        }

        if(info.length()>70) {
            dateInputInfo.setError("Prea multa informatie");
            ans=false;
        }

        if(work.equals("Struguri") && dateQuantity1Input.getEditText().length()==0){
            dateQuantity1Input.setError("Incomplet");
            ans=false;
        }

        if(work.equals("Rosii")){
            if(dateQuantity1Input.getEditText().length()==0) {
                dateQuantity1Input.setError("Incomplet");
                ans=false;
            }
            if(dateQuantity2Input.getEditText().length()==0) {
                dateQuantity2Input.setError("Incomplet");
                ans=false;
            }

        }



        return ans;
    }

}
