package com.nutsu7.BivolManager.ui.angajat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.angajat.Angajat;

import java.util.ArrayList;

public class AdaptorAngajatList extends RecyclerView.Adapter<AdaptorAngajatList.MuncitorViewHolder>{
    private ArrayList<Angajat> angajatList;
    private Context context;

    public AdaptorAngajatList(ArrayList<Angajat> angajatList, Context context) {
        this.angajatList = angajatList;
        this.context = context;
    }

    @NonNull
    @Override
    public MuncitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.angajat_item,parent,false);
        return new MuncitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuncitorViewHolder holder, int position) {
        Angajat angajat = angajatList.get(position);
        MuncitorViewHolder vh= (MuncitorViewHolder) holder;
        vh.muncitoriListTextView.setText(angajat.getName() + " " + angajat.getSurname());
    }

    @Override
    public int getItemCount() {
        return angajatList.size();
    }

    public static class MuncitorViewHolder extends RecyclerView.ViewHolder{
        private TextView muncitoriListTextView;
        public MuncitorViewHolder(@NonNull View itemView) {
            super(itemView);
            muncitoriListTextView=itemView.findViewById(R.id.angajatListTextView);
        }
    }
}
