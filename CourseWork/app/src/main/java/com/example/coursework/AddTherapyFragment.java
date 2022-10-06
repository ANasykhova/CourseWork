package com.example.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class AddTherapyFragment extends Fragment {

    public AddTherapyFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_therapy_fragment, container, false);

        Button button = view.findViewById(R.id.button_therapy);
        EditText medicineName = view.findViewById(R.id.editTextMedicineNameTherapy);
        EditText personName = view.findViewById(R.id.editTextPersonNameTherapy);
        EditText count = view.findViewById(R.id.editTextCountTherapy);
        EditText date = view.findViewById(R.id.editTextDateTherapy);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    int countNumber;
                    try {
                        countNumber = Integer.parseInt(count.getText().toString());

                    } catch(NumberFormatException e){
                        countNumber = 0;
                    }
                    if(!medicineName.getText().toString().equals("") && !personName.getText().toString().equals("")
                            && !date.getText().toString().equals("")) {
                        Therapy therapy = new Therapy(medicineName.getText().toString(), personName.getText().toString(),
                                date.getText().toString(), countNumber);
                        NotificationsFragment.therapies.add(therapy);
                    }

                AddFragment addFragment = new AddFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, addFragment).commit();
            }
        });
        return view;
    }

}