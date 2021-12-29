package com.example.calcapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Main_Activity";

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
        Log.d(LOG_TAG, "Creating view..");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "View created!");

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
                try {
                    answer.setText(Integer.toString(Integer.parseInt(argument1.getText().toString()) + Integer.parseInt(argument2.getText().toString())));
                } catch (NumberFormatException e){
                    answer.setText("Input Error");
                    Log.d(LOG_TAG, e.getMessage());
                    Log.d(LOG_TAG, e.toString());
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(Integer.toString(Integer.parseInt(argument1.getText().toString()) * Integer.parseInt(argument2.getText().toString())));
                } catch (NumberFormatException e){
                    answer.setText("Input Error");
                    Log.d(LOG_TAG, e.getMessage());
                    Log.d(LOG_TAG, e.toString());
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(Integer.toString(Integer.parseInt(argument1.getText().toString()) / Integer.parseInt(argument2.getText().toString())));
                } catch (ArithmeticException e){
                    answer.setText("Div by zero");
                    Log.d(LOG_TAG, e.getMessage());
                    Log.d(LOG_TAG, e.toString());
                } catch (NumberFormatException e){
                    answer.setText("Input Error");
                    Log.d(LOG_TAG, e.getMessage());
                    Log.d(LOG_TAG, e.toString());
                }
            }
        });

        btnSubtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(Integer.toString(Integer.parseInt(argument1.getText().toString()) - Integer.parseInt(argument2.getText().toString())));
                } catch (NumberFormatException e){
                    answer.setText("Input Error");
                    Log.d(LOG_TAG, e.getMessage());
                    Log.d(LOG_TAG, e.toString());
                }
            }
        });
    }
}
