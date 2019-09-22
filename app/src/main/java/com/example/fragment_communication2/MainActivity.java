package com.example.fragment_communication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FragmentListenerA,     SecondFragment.SecondFragmentlistenerB {

    private FirstFragment fragmentA;
    private SecondFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA=new FirstFragment();
        fragmentB=new SecondFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.first_container,fragmentA).replace(R.id.second_container,fragmentB).commit();


    }

    @Override
    public void Inputasent(CharSequence input) {
        fragmentB.UpdateEdittext(input);
    }

    @Override
    public void Inputbsent(CharSequence input) {

        fragmentA.UpdateEdittext(input);

    }
}
