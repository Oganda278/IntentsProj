package com.example.intentsproj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {



    private Button add;
    private  Button sub;
    private Button mul;
    private Button div;
    private TextView info;
    private  TextView result;
    private  double val1=Double.NaN;
    private  final String ADDITION ="+";
    private  final String SUBTRACTION="-";
    private  final String MULTIPLICATION="*";
    private  final String DIVISION="/";
    private  final String EQU ="0";
    private double val2;
    private String ACTION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("My Application ");

        Intent intent=getIntent();
        String number1=intent.getStringExtra( "Number 1");
        String number2=intent.getStringExtra( "Number 2");

        TextView mResults=findViewById(R.id.n1);
        TextView mResults2=findViewById(R.id.n2);

        mResults.setText(""+number1);
        mResults2.setText(""+number2);


        setupUIViews();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ADDITION;
                result.setText(String.valueOf(val1)+"+");
                result.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                result.setText(null);
            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=MULTIPLICATION;
                result.setText(String.valueOf(val1)+"*");
                result.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=DIVISION;
                result.setText(String.valueOf(val1)+"/");
                result.setText(null);
            }
        });

    }
    private void setupUIViews( ) {
        add=(Button)findViewById(R.id.btnadd);
        sub=(Button)findViewById(R.id.btnsub);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndivide);

        result=(TextView)findViewById(R.id.tvResult);
    }
    private  void  compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(info.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1= val1+val2;
                    break;

                case SUBTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(result.getText().toString());
        }
    }
}
