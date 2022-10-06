package com.example.coursework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVMedicineAdapter extends RecyclerView.Adapter<RVMedicineAdapter.MedicineViewHolder>{

    private List<Medicine> medicines;

    RVMedicineAdapter(List<Medicine> persons){
        this.medicines = persons;
    }

    public static class MedicineViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView date;
        TextView count;
        ImageView delete;

        MedicineViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.name_medicine_card);
            date = (TextView)itemView.findViewById(R.id.date_medicine_card);
            count = (TextView)itemView.findViewById(R.id.count_medicine_card);
            delete = (ImageView) itemView.findViewById(R.id.delete_medicine_card);
        }
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card, parent, false);
        MedicineViewHolder mvh = new MedicineViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int i) {
        holder.name.setText(medicines.get(i).name);
        holder.date.setText(medicines.get(i).date);
        holder.count.setText(medicines.get(i).count.toString());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicines.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), medicines.size());
            }
        });
    }


    @Override
    public int getItemCount() {
        return medicines.size();
    }

}