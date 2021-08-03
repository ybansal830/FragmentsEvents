package com.myfirst.fragmentsevents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ClickListener{

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment();
    }

    private void setFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.container,eventDetailsFragment,"Event").commit();
    }

    @Override
    public void onClick(Bundle bundle) {
        String fragmentType = bundle.getString("FragmentType");
        if(fragmentType.equals("Event")){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
            timeAndDateFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.container,timeAndDateFragment,"Time").commit();
        }
        else if(fragmentType.equals("Time")){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
            priceDetailsFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.container,priceDetailsFragment,"Price").commit();
        }
    }
}