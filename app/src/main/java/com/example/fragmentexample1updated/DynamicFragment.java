package com.example.fragmentexample1updated;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

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