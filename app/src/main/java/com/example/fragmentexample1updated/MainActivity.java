package com.example.fragmentexample1updated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private boolean display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display){
                    displayFragment();
                }
                else{
                    closeFragment();
                }
            }
        });

    }

    private void closeFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        DynamicFragment dynamicFragment = (DynamicFragment) fragmentManager.findFragmentById(R.id.dynamicf);

        if (dynamicFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(dynamicFragment).commit();

        }

    }

    private void displayFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = DynamicFragment().newInstance();

        fragmentTransaction.add(R.id.dynamicf, dynamicFragment).addToBackStack(null).commit();

        display = true;
        btn1.setText(R.string.close);
    }
}