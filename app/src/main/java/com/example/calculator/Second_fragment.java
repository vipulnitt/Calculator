package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class Second_fragment extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_second, container, false);
        Expression expression = new Expression(MainActivity.string);
        textView = view.findViewById(R.id.textView2);
        textView.setText("Answer of "+MainActivity.string+" is "+ expression.calculate());



   return  view;
    }
}
