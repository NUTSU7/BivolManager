package com.nutsu7.BivolManager.ui.muncitori;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nutsu7.BivolManager.R;

import java.util.ArrayList;

public class AdaptorMuncitoriList extends RecyclerView.Adapter<AdaptorMuncitoriList.MuncitorViewHolder>{
    private ArrayList<Muncitor> muncitorList;
    private Context context;

    public AdaptorMuncitoriList(ArrayList<Muncitor> muncitorList, Context context) {
        this.muncitorList = muncitorList;
        this.context = context;
    }

    @NonNull
    @Override
    public MuncitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_muncitor_item,parent,false);
        return new MuncitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuncitorViewHolder holder, int position) {
        Muncitor muncitor = muncitorList.get(position);
        MuncitorViewHolder vh= (MuncitorViewHolder) holder;
        vh.muncitoriListTextView.setText(muncitor.getName());
    }

    @Override
    public int getItemCount() {
        return muncitorList.size();
    }

    public static class MuncitorViewHolder extends RecyclerView.ViewHolder{
        private TextView muncitoriListTextView;
        public MuncitorViewHolder(@NonNull View itemView) {
            super(itemView);
            muncitoriListTextView=itemView.findViewById(R.id.muncitoriListTextView);
        }
    }
}
