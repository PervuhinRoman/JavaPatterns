package com.example.calcapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnMul;
    Button btnSubtr;
    Button btnDivide;

    EditText argument1;
    EditText argument2;

    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.add);
        btnMul = (Button) findViewById(R.id.mul);
        btnSubtr = (Button) findViewById(R.id.subtr);
        btnDivide = (Button) findViewById(R.id.divide);

        argument1 = (EditText) findViewById(R.id.arg1);
        argument2 = (EditText) findViewById(R.id.arg2);

        answer = (TextView) findViewById(R.id.answer);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arg1 = Integer.parseInt(argument1.getText().toString());
                int arg2 = Integer.parseInt(argument2.getText().toString());
                answer.setText(Integer.toString(arg1 + arg2));

                // TODO add try-catch in all method onClick
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arg1 = Integer.parseInt(argument1.getText().toString());
                int arg2 = Integer.parseInt(argument2.getText().toString());
                answer.setText(Integer.toString(arg1*arg2));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arg1 = Integer.parseInt(argument1.getText().toString());
                int arg2 = Integer.parseInt(argument2.getText().toString());
                answer.setText(Integer.toString(arg1 / arg2));
            }
        });

        btnSubtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arg1 = Integer.parseInt(argument1.getText().toString());
                int arg2 = Integer.parseInt(argument2.getText().toString());
                answer.setText(Integer.toString(arg1 - arg2));
            }
        });
    }
}
