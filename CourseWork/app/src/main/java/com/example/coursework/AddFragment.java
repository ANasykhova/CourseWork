package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment {

    public AddFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_fragment, container, false);

        Button buttonWrite = view.findViewById(R.id.add_write_button_main);
        Button buttonCode = view.findViewById(R.id.add_code_button_main);
        Button buttonTherapy = view.findViewById(R.id.add_therapy_button_main);

        buttonTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTherapyFragment addTherapyFragment = new AddTherapyFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, addTherapyFragment).commit();
            }
        });

        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddWriteFragment addWriteFragment = new AddWriteFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, addWriteFragment).commit();
            }
        });

        buttonCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCodeFragment addCodeFragment = new AddCodeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, addCodeFragment).commit();
            }
        });


        return view;
    }

}