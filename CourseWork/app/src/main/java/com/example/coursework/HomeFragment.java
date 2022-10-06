package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public HomeFragment(){
        // require a empty public constructor
    }

    public static List<Medicine> medicines = new ArrayList<Medicine>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);

        RVMedicineAdapter adapter = new RVMedicineAdapter(medicines);
        rv.setAdapter(adapter);

        return view;
    }
}