package com.example.coursework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddWriteFragment extends Fragment {

    public AddWriteFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_write_fragment, container, false);

        Button button = view.findViewById(R.id.button);
        EditText name = view.findViewById(R.id.editTextMedicineName);
        EditText count = view.findViewById(R.id.editTextCount);
        EditText date = view.findViewById(R.id.editTextMedicineDate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countNumber;
                try {
                    countNumber = Integer.parseInt(count.getText().toString());

                } catch(NumberFormatException e){
                    countNumber = 0;
                }
                if(!name.getText().toString().equals("") && !date.getText().toString().equals("")){
                    Medicine med = new Medicine(name.getText().toString(),
                            date.getText().toString(), countNumber);
                    HomeFragment.medicines.add(med);
                }
                AddFragment addFragment = new AddFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, addFragment).commit();
            }
        });
        return view;
    }

}