package com.nutsu7.BivolManager.ui.home;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiAngajatListAdaptor extends RecyclerView.Adapter<ZiAngajatListAdaptor.ZiAngajatViewHolder> {
    private List<Angajat> angajatList;
    private Context context;
    private AngajatRepo angajatRepo;
    private static List<List<Integer>> angajatListChecked;
    private static Integer hours=0;
    List<ZiAngajatViewHolder> viewHolders = new ArrayList<>();


    public ZiAngajatListAdaptor(Context context) {

        this.context = context;
        this.angajatRepo = new AngajatRepo(context);
        angajatListChecked = new ArrayList<>();
        updateList();
    }
    public void updateList(){

        angajatList=angajatRepo.getAll();
        for(int i=0; i<angajatList.size(); i++){
            angajatListChecked.add(Arrays.asList(angajatList.get(i).getId(),0,0));
        }

    }
    @NonNull
    @Override
    public ZiAngajatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zi_add_angajat,parent,false);

        return new ZiAngajatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZiAngajatViewHolder holder, int position) {

        ZiAngajatViewHolder vh= holder;
        viewHolders.add(holder);
        Angajat angajat = angajatList.get(vh.getAdapterPosition());
        vh.ziAngListTextView.setText(angajat.getSurname() + " " + angajat.getName());
        vh.ziAngInputHours.getEditText().setImeOptions(EditorInfo.IME_ACTION_DONE);
        vh.ziAngInputHours.setVisibility(View.INVISIBLE);

        vh.checkBox.addOnCheckedStateChangedListener(new MaterialCheckBox.OnCheckedStateChangedListener() {
            @Override
            public void onCheckedStateChangedListener(@NonNull MaterialCheckBox checkBox, int state) {
                if(state==1){

                    vh.ziAngInputHours.setVisibility(View.VISIBLE);
                    //List<Integer> temp = angajatListChecked.get(vh.getAdapterPosition());
                    angajatListChecked.set(vh.getAdapterPosition(), Arrays.asList(vh.getAdapterPosition(), hours, 1));
                    vh.ziAngInputHours.getEditText().setText(String.valueOf(hours));
                }
                else {
                    vh.ziAngInputHours.setVisibility(View.INVISIBLE);
                    List<Integer> temp = angajatListChecked.get(vh.getAdapterPosition());
                    angajatListChecked.set(vh.getAdapterPosition(), Arrays.asList(temp.get(0), 0, 0));
                }
            }
        });

        vh.ziAngInputHours.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                Integer temp=0;
                if(vh.ziAngInputHours.getEditText().length()!=0) temp=Integer.parseInt(vh.ziAngInputHours.getEditText().getText().toString().trim());
                if(temp>0 && temp!=hours){
                    List<Integer> tempList = angajatListChecked.get(vh.getAdapterPosition());
                    angajatListChecked.set(vh.getAdapterPosition(), Arrays.asList(tempList.get(0), temp, tempList.get(2)));
                    System.out.println(temp);
                }
            }
        });
    }

    public List<List<Integer>> getAngajatList(){
        return angajatListChecked;
    }

    public void updateHours(Integer hours1){
        for (List<Integer> integers : angajatListChecked) {
            if(integers.get(2)==1 && integers.get(1)==hours){
                angajatListChecked.set(integers.get(0), Arrays.asList(integers.get(0), hours1, 1));
                viewHolders.get(integers.get(0)).ziAngInputHours.getEditText().setText(String.valueOf(hours1));
            }
        }
        this.hours=hours1;
    }

    @Override
    public void onViewRecycled(@NonNull ZiAngajatViewHolder holder) {
        super.onViewRecycled(holder);
        viewHolders.remove(holder);
    }

    @Override
    public int getItemCount() {
        return angajatList.size();
    }



    public static class ZiAngajatViewHolder extends RecyclerView.ViewHolder{
        private TextView ziAngListTextView;
        private TextInputLayout ziAngInputHours;
        private MaterialCheckBox checkBox;
        public ZiAngajatViewHolder(@NonNull View itemView) {
            super(itemView);
            ziAngListTextView = itemView.findViewById(R.id.ziAngListTextView);
            checkBox = itemView.findViewById(R.id.ziAngCheckBox);
            ziAngInputHours = itemView.findViewById(R.id.ziAngInputHours);
        }

    }



}
