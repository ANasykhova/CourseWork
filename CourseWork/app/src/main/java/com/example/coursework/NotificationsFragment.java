package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment(){
        // require a empty public constructor
    }

    public static List<Therapy> therapies = new ArrayList<Therapy>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv_therapy);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);

        RVTherapyAdapter adapter = new RVTherapyAdapter(therapies);
        rv.setAdapter(adapter);

        return view;
    }
}