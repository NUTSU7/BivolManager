package com.nutsu7.BivolManager.ui.struguri;

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
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;

import java.util.List;

public class StruguriTransactionListAdaptor extends RecyclerView.Adapter<StruguriTransactionListAdaptor.StruguriTransactionViewHolder> {
    private List<StruguriTransaction> struguriTransactionList;
    private Context context;
    private StruguriRepo struguriRepo;

    public StruguriTransactionListAdaptor(Context context){
        this.context=context;
        this.struguriRepo = new StruguriRepo(context);
        updateList();
    }

    public void updateList(){struguriTransactionList=struguriRepo.getAllTransaction();}

    @NonNull
    @Override
    public StruguriTransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_struguri_transaction,parent,false);

        return new StruguriTransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StruguriTransactionListAdaptor.StruguriTransactionViewHolder holder, int position) {
        StruguriTransactionViewHolder vh= (StruguriTransactionViewHolder) holder;
        StruguriTransaction struguriTransaction = struguriTransactionList.get(vh.getAdapterPosition());
        vh.struguriTranListTextView.setText(struguriTransaction.getDay() + " " + struguriTransaction.getMonth());
        vh.struguriTranListTextView2.setText(struguriTransaction.getBuyer());

        vh.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle arg = new Bundle();
                arg.putInt("transactionID", struguriTransaction.getId());
                navController.navigate(R.id.action_navigation_struguriTransaction_to_navigation_struguriTransactionStats, arg);
            }
        });

        vh.struguriTranListImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Struguri struguri = struguriRepo.get();
                struguri.addQuantityCurrent(struguriTransaction.getQuantity()+struguriTransaction.getQuantityNoReceipt());
                struguri.decQuantitySold(struguriTransaction.getQuantity()+struguriTransaction.getQuantityNoReceipt());
                struguri.decMoneyTotal(struguriTransaction.getQuantity()*struguriTransaction.getPrice());
                struguri.decMoneyNRTotal(struguriTransaction.getQuantityNoReceipt()*struguriTransaction.getPriceNoReceipt());
                struguriRepo.deleteTransaction(struguriRepo.getTransactionByID(vh.getAdapterPosition()));
                struguriRepo.update(struguri);
                updateList();

                notifyItemRemoved(vh.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return struguriTransactionList.size();
    }

    public static class StruguriTransactionViewHolder extends RecyclerView.ViewHolder{
        private final TextView struguriTranListTextView;
        private final TextView struguriTranListTextView2;
        private final ImageButton struguriTranListImageButton;
        public StruguriTransactionViewHolder(@NonNull View itemView){
            super(itemView);
            struguriTranListTextView = itemView.findViewById(R.id.struguriTranListTextView);
            struguriTranListTextView2 = itemView.findViewById(R.id.struguriTranListTextView2);
            struguriTranListImageButton = itemView.findViewById(R.id.struguriTranDeleteBtn);
        }
    }
}
