package com.nutsu7.BivolManager.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;
import com.nutsu7.BivolManager.db.zi.ZiRepo;

import java.util.List;

public class ZiStatsListAdaptor extends RecyclerView.Adapter<ZiStatsListAdaptor.ZiStatsViewHolder> {
    private List<Angajat> angajatList;
    private Context context;
    private AngajatRepo angajatRepo;
    private ZiRepo ziRepo;
    private static int ziID;


    public ZiStatsListAdaptor(Context context, int ziID) {

        this.context = context;
        this.angajatRepo = new AngajatRepo(context);
        this.ziRepo = new ZiRepo(context);
        this.ziID=ziID;
        updateList();
    }
    public void updateList(){
        angajatList=ziRepo.getAngajati(ziID);
    }
    @NonNull
    @Override
    public ZiStatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zi_stats_angajat,parent,false);

        return new ZiStatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZiStatsViewHolder holder, int position) {
        Angajat angajat = angajatList.get(position);
        ZiStatsViewHolder vh= holder;
        System.out.println(ziID+" "+angajat.getId());
        vh.ziStatsListTextView.setText(angajat.getSurname() + " " + angajat.getName());
        vh.ziStatsListHours.setText(String.valueOf(angajatRepo.getHoursByZi(ziID, angajat.getId())));

    }


    @Override
    public int getItemCount() {
        return angajatList.size();
    }



    public static class ZiStatsViewHolder extends RecyclerView.ViewHolder{
        private TextView ziStatsListTextView;
        private TextView ziStatsListHours;
        private MaterialCheckBox checkBox;
        public ZiStatsViewHolder(@NonNull View itemView) {
            super(itemView);
            ziStatsListTextView = itemView.findViewById(R.id.ziStatsListTextView);
            ziStatsListHours = itemView.findViewById(R.id.ziStatsListHours);
        }

    }

}

