package com.nutsu7.BivolManager.ui.rosii;

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
import com.nutsu7.BivolManager.db.rosii.Rosii;
import com.nutsu7.BivolManager.db.rosii.RosiiRepo;
import com.nutsu7.BivolManager.db.rosii.RosiiTransaction;
import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class RosiiTransactionListAdaptor extends RecyclerView.Adapter<RosiiTransactionListAdaptor.RosiiTransactionViewHolder>{

    private List<RosiiTransaction> rosiiTransactionList;
    private Context context;
    private RosiiRepo rosiiRepo;

    public RosiiTransactionListAdaptor(Context context){
        this.context=context;
        this.rosiiRepo = new RosiiRepo(context);
        updateList();
    }

    public void updateList(){rosiiTransactionList=rosiiRepo.getAllTransaction();}

    @NonNull
    @Override
    public RosiiTransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rosii_transaction,parent,false);

        return new RosiiTransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RosiiTransactionViewHolder holder, int position) {
        RosiiTransactionViewHolder vh= (RosiiTransactionViewHolder) holder;
        RosiiTransaction rosiiTransaction = rosiiTransactionList.get(vh.getAdapterPosition());

        vh.rosiiTranListTextView.setText(rosiiTransaction.getDay() + " " + rosiiTransaction.getMonth());

        vh.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle arg = new Bundle();
                arg.putInt("transactionID", rosiiTransaction.getId());
                navController.navigate(R.id.action_navigation_rosiiTransaction_to_navigation_rosiiTransactionStats, arg);
            }
        });

        vh.rosiiTranListImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rosii rosii = rosiiRepo.get();
                RosiiTransaction rosiiTransaction1 = rosiiRepo.getTransactionByID(vh.getAdapterPosition());

                Double temp1 = rosiiTransaction1.getQuantity1List().stream().mapToDouble(Double::doubleValue).sum(),
                        temp2 = rosiiTransaction1.getQuantity2List().stream().mapToDouble(Double::doubleValue).sum();
                //System.out.println(rosiiTransaction1.getQuantity1() + " " + rosiiTransaction1.getQuantity2());

                rosii.decQuantitySold1(temp1);
                rosii.decQuantitySold2(temp2);

                rosii.addBoxCurrent1(rosiiTransaction1.getBoxNr1());
                rosii.addBoxCurrent2(rosiiTransaction1.getBoxNr2());

                rosii.decBoxSold1(rosiiTransaction1.getBoxNr1());
                rosii.decBoxSold2(rosiiTransaction1.getBoxNr2());

                rosii.decMoneyTotal1(temp1, rosiiTransaction1.getPrice1());
                rosii.decMoneyTotal2(temp2, rosiiTransaction1.getPrice2());

                rosiiRepo.update(rosii);
                rosiiRepo.deleteTransaction(rosiiTransaction1);
                updateList();

                notifyItemRemoved(vh.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return rosiiTransactionList.size();
    }

    public static class RosiiTransactionViewHolder extends RecyclerView.ViewHolder{
        private final TextView rosiiTranListTextView;
        private final ImageButton rosiiTranListImageButton;
        public RosiiTransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            rosiiTranListTextView = itemView.findViewById(R.id.rosiiTranListTextView);
            rosiiTranListImageButton = itemView.findViewById(R.id.rosiiTranDeleteBtn);
        }
    }
}

