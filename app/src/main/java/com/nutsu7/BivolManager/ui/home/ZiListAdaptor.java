package com.nutsu7.BivolManager.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriRepo;
import com.nutsu7.BivolManager.db.zi.Zi;
import com.nutsu7.BivolManager.db.zi.ZiRepo;


import java.util.List;
import java.util.Objects;

public class ZiListAdaptor extends RecyclerView.Adapter<ZiListAdaptor.ZiViewHolder>{
    private List<Zi> ziList;
    private Context context;
    private ZiRepo ziRepo;
    private StruguriRepo struguriRepo;

    public ZiListAdaptor(Context context){
        this.context=context;
        this.ziRepo= new ZiRepo(context);
        this.struguriRepo = new StruguriRepo(context);
        updateList();
    }

    public void updateList(){
        ziList=ziRepo.getAll();
    }

    @NonNull
    @Override
    public ZiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zi,parent,false);

        return new ZiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZiViewHolder holder, int position) {

        ZiViewHolder vh= (ZiViewHolder) holder;
        Zi zi = ziList.get(vh.getAdapterPosition());
        vh.ziListTextView.setText(zi.getDay() + " " + zi.getMonth()+" "+zi.getYear());

        vh.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle arg = new Bundle();
                arg.putInt("ziID", zi.getId());
                navController.navigate(R.id.action_navigation_zi_to_navigation_ziStats, arg);
            }
        });

        vh.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zi zi1 = ziRepo.getByID(vh.getAdapterPosition());
                if(Objects.equals(zi1.getWork(), "Struguri")){
                    Struguri struguri = struguriRepo.get();
                    struguri.decDaysWorked(1);
                    struguri.decQuantityCurrent(zi1.getQuantity());
                    struguri.decQuantityHarvested(zi1.getQuantity());
                    struguriRepo.update(struguri);
                }
                ziRepo.delete(zi1);
                updateList();

                notifyItemRemoved(vh.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ziList.size();
    }

    public static class ZiViewHolder extends RecyclerView.ViewHolder{
        private final TextView ziListTextView;
        private final ImageButton imageButton;
        public ZiViewHolder(@NonNull View itemView) {
            super(itemView);
            ziListTextView = itemView.findViewById(R.id.ziListTextView);
            imageButton = itemView.findViewById(R.id.ziDeleteBtn);
        }

    }
}
