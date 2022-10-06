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

public class RVTherapyAdapter extends RecyclerView.Adapter<RVTherapyAdapter.TherapyViewHolder>{

    private List<Therapy> therapies;

    RVTherapyAdapter(List<Therapy> therapies){
        this.therapies = therapies;
    }

    public static class TherapyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView medicineName;
        TextView personName;
        TextView date;
        TextView count;
        ImageView delete;

        TherapyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_therapy);
            medicineName = (TextView)itemView.findViewById(R.id.name_medicine_therapy_card);
            personName = (TextView)itemView.findViewById(R.id.name_person_therapy_card);
            date = (TextView)itemView.findViewById(R.id.date_therapy_card);
            count = (TextView)itemView.findViewById(R.id.count_therapy_card);
            delete = (ImageView) itemView.findViewById(R.id.delete_therapy_card);
        }
    }

    @NonNull
    @Override
    public TherapyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.therapy_card, parent, false);
        TherapyViewHolder tvh = new TherapyViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TherapyViewHolder holder, int i) {
        holder.medicineName.setText(therapies.get(i).medicineName);
        holder.personName.setText(therapies.get(i).personName);
        holder.date.setText(therapies.get(i).date);
        holder.count.setText(therapies.get(i).count.toString());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                therapies.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), therapies.size());
            }
        });
    }


    @Override
    public int getItemCount() {
        return therapies.size();
    }

}