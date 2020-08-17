package com.example.intentsproj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {


    Button btn;
    EditText num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("My Application");

        btn=findViewById(R.id.btnok);
        num1=findViewById(R.id.no1);
        num2=findViewById(R.id.no2);


        Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {


                                       String number1=num1.getText().toString();
                                       String number2=num2.getText().toString();

                                       Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                                       intent.putExtra("Number 1",number1);
                                       intent.putExtra("Number 2",number2);
                                       startActivity(intent);
                                   }
                               }
        );
    }
}