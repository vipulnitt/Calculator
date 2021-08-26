package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class Second_fragment extends Fragment {
    public static String string="";
    static TextView textView,textView1;
    public Second_fragment.Second_fragmentListener listeners;
    public interface Second_fragmentListener {
        void onInput2SENT(CharSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.textView2);
      //  textView.setText("Answer of "+MainActivity.string+" is "+ expression.calculate());
        textView1= view.findViewById(R.id.textView3);
   return  view;
    }
    public static void edittext(CharSequence data)
    {
        string=data.toString();
     //   textView.setText(string);
        textView1.setText(string);
        Expression expression = new Expression(string);
        if( expression.checkLexSyntax())
            textView.setText(""+ expression.calculate());
        if(string=="")
            textView.setText("");

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Second_fragment.Second_fragmentListener) {
            listeners = (Second_fragment.Second_fragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()+"issue");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listeners=null;
    }
}
