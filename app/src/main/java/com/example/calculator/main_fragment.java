package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.mariuszgromada.math.mxparser.Expression;


public class main_fragment extends Fragment {
    String result="";
    int temps =0;
    private main_fragmentListener listener;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, sum, diff, div, mul, sqr, sqrroot, eql, b0, b00, clear, del, brac, dot,sin,cos;
    boolean check = false, bracecheck = false;

    public interface main_fragmentListener {
        void onInputSENT(CharSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        b1 = view.findViewById(R.id.b1);
        b2 = view.findViewById(R.id.b2);
        b3 = view.findViewById(R.id.b3);
        b4 = view.findViewById(R.id.b4);
        b5 = view.findViewById(R.id.b5);
        b6 = view.findViewById(R.id.b6);
        b7 = view.findViewById(R.id.b7);
        b8 = view.findViewById(R.id.b8);
        b9 = view.findViewById(R.id.b9);
        b0 = view.findViewById(R.id.b);
        b00 = view.findViewById(R.id.b00);
        sum = view.findViewById(R.id.Sum);
        diff = view.findViewById(R.id.difference);
        div = view.findViewById(R.id.Divide);
        mul = view.findViewById(R.id.mul);
        sqr = view.findViewById(R.id.square2);
        sqrroot = view.findViewById(R.id.root);
        clear = view.findViewById(R.id.clear);
        eql = view.findViewById(R.id.equal);
        del = view.findViewById(R.id.delete);
        brac = view.findViewById(R.id.brac);
        dot = view.findViewById(R.id.bdot);
        sin= view.findViewById(R.id.sin);
        cos = view.findViewById(R.id.cos);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun(".");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("9");
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("sum");
            }
        });
        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("diff");
            }
        });
        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression expression = new Expression(result);
                if (check && expression.checkLexSyntax()) {
                    CharSequence input = result;
                    listener.onInputSENT(input);
               //     MainActivity.string = result.getText().toString();
                } else {
                    Toast.makeText(getContext(), "Invalid Expression!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("mul");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("div");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result="";
                listener.onInputSENT(result);
                check = false;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = result;
                if (temp.length() > 0) {
                    if (temp.endsWith(")")) {
                        bracecheck = true;
                    }
                    if (temp.endsWith("(")) {
                        bracecheck = false;
                    }
                    if (temp.endsWith("+") || temp.endsWith("-") || temp.endsWith("/") || temp.endsWith("*")) {
                        check = true;
                    }
                    temp = temp.substring(0, temp.length() - 1);
                    Log.d("vipull", temp);
                    result = (temp);
                    Log.d("vipulll",result);
                    listener.onInputSENT(result);
                    if(result.length()<=1) {
                        temps++;
                    }
                    if(temps==2)
                    {
                        result="";
                        listener.onInputSENT(result);
                        temps=0;
                    }

                }
            }
        });
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("00");
            }
        });
        brac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("brac");
            }
        });
        sqrroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("sqrt(");
                bracecheck = true;
            }
        });
        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("sqr");
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("sin");
                bracecheck = true;
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun("cos");
                bracecheck = true;
            }
        });
        return view;
    }

    void fun(String s) {
        if (result.length() < 16) {
            String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "00", "."};
            for (int i = 0; i < 12; i++) {
                if (s.equals(str[i])) {
                  result=  result.concat(str[i]);
                    listener.onInputSENT(result);
                    check = true;
                }
            }
            if (s.equals("brac")) {
                if (!bracecheck) {
                    result=result.concat("(");
                    listener.onInputSENT(result);
                    bracecheck = true;
                } else {
                    bracecheck = false;
                  result= result.concat(")");
                    listener.onInputSENT(result);
                }
            }
            if (s.equals("sqrt(")) {
              result=  result.concat("sqrt(");
                listener.onInputSENT(result);
            }
            if (s.equals("sin")) {
                result=  result.concat("sin(");
                listener.onInputSENT(result);
            }
            if (s.equals("cos")) {
                result=  result.concat("cos(");
                listener.onInputSENT(result);
            }
            if (s.equals("sqr")) {
                result=result.concat("^2");
                listener.onInputSENT(result);
            }
            if (s.equals("sum")) {
                if (check) {
                  result= result.concat("+");
                    listener.onInputSENT(result);
                    check = false;
                } else
                    Toast.makeText(getContext(), "Invalid Expression!", Toast.LENGTH_SHORT).show();
            }
            if (s.equals("diff")) {
                if (check) {
                  result= result.concat("-");
                    listener.onInputSENT(result);
                    check = false;
                } else
                    Toast.makeText(getContext(), "Invalid Expression!", Toast.LENGTH_SHORT).show();
            }
            if (s.equals("mul")) {
                if (check) {
                  result =  result.concat("*");
                    listener.onInputSENT(result);
                    check = false;
                } else
                    Toast.makeText(getContext(), "Invalid Expression!", Toast.LENGTH_SHORT).show();
            }
            if (s.equals("div")) {
                if (check) {
                   result= result.concat("/");
                    listener.onInputSENT(result);
                    check = false;
                } else
                    Toast.makeText(getContext(), "Invalid Expression!", Toast.LENGTH_SHORT).show();
            }
        } else Toast.makeText(getContext(), "Limit Exceeded!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof main_fragmentListener) {
            listener = (main_fragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()+"issue");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
