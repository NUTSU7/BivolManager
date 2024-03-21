package com.nutsu7.BivolManager.ui.angajat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

import java.util.List;

public class AngajatListAdaptor extends RecyclerView.Adapter<AngajatListAdaptor.AngajatViewHolder>{
    private List<Angajat> angajatList;
    private Context context;
    private AngajatRepo angajatRepo;

    public AngajatListAdaptor(Context context) {

        this.context = context;
        this.angajatRepo = new AngajatRepo(context);
        updateList();
    }
    public void updateList(){
        angajatList=angajatRepo.getAll();
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
        vh.angajatListTextView.setText(angajat.getSurname() + " " + angajat.getName());

        vh.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_navigation_angajat_to_navigation_angajatStats);
            }
        });

        vh.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angajatRepo.delete(angajat);
                updateList();

                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return angajatList.size();
    }



    public static class AngajatViewHolder extends RecyclerView.ViewHolder{
        private TextView angajatListTextView;
        private ImageButton imageButton;
        public AngajatViewHolder(@NonNull View itemView) {
            super(itemView);
            angajatListTextView = itemView.findViewById(R.id.angajatListTextView);
            imageButton = itemView.findViewById(R.id.angajatDeleteBtn);
        }

    }

}
