package com.example.fragmentexample1updated;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


public class DynamicFragment extends Fragment {

    public DynamicFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View mFragmentView = inflater.inflate(R.layout.fragment_dynamic, container, false);
        RadioGroup rg1 = mFragmentView.findViewById(R.id.rGroup1);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View option = rg1.findViewById(i);
                int index = rg1.indexOfChild(option);
                TextView tv1 = mFragmentView.findViewById(R.id.fHeader);
                switch (index){
                    case 0:
                        tv1.setText(R.string.yes_message);
                        break;
                    case 1:
                        tv1.setText(R.string.no_message);
                }
            }
        });

        return mFragmentView;
    }
}