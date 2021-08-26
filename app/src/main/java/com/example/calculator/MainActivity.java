package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements main_fragment.main_fragmentListener,Second_fragment.Second_fragmentListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new main_fragment()).commit();
    }


    @Override
    public void onInput2SENT(CharSequence input) {

    }

    @Override
    public void onInputSENT(CharSequence input) {
        Second_fragment.edittext(input);
    }
}