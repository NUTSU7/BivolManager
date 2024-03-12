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

import java.util.List;

public class AdaptorAngajatList extends RecyclerView.Adapter<AdaptorAngajatList.AngajatViewHolder>{
    private List<Angajat> angajatList;
    private Context context;

    public AdaptorAngajatList(List<Angajat> angajatList, Context context) {
        this.angajatList = angajatList;
        this.context = context;
    }

    @NonNull
    @Override
    public AngajatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.angajat_item,parent,false);
        return new AngajatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AngajatViewHolder holder, int position) {
        Angajat angajat = angajatList.get(position);
        AngajatViewHolder vh= (AngajatViewHolder) holder;
        vh.angajatListTextView.setText(angajat.id+" "+angajat.getName() + " " + angajat.getSurname());

    }

    @Override
    public int getItemCount() {
        return angajatList.size();
    }

    public static class AngajatViewHolder extends RecyclerView.ViewHolder{
        private TextView angajatListTextView;
        public AngajatViewHolder(@NonNull View itemView) {
            super(itemView);
            angajatListTextView =itemView.findViewById(R.id.angajatListTextView);
        }
    }
}
