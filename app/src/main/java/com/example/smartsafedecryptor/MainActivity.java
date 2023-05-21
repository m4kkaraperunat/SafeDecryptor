package com.example.smartsafedecryptor;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.Scriptable;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv, solutionTv;
    MaterialButton buttonC, buttonD;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        assignId(buttonD, R.id.button_Decrypt);
        assignId(buttonC, R.id.button_c);
        assignId(button0, R.id.button_0);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);

    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Context context = getApplicationContext();
        CharSequence warning = "Key must be 6 numbers";

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String input = solutionTv.getText().toString();

        if (buttonText.equals("C")){
            if (input.length() == 0){
                return;
            }
            solutionTv.setText(input.substring(0,input.length() - 1));
        }
        else if (buttonText.equals("Decrypt")){
            if(input.length() != 6){
                return;
            }
            long value = Integer.parseInt(input);
            if(value == 0){ // prevents crash
                value = 1;
            }
            value = value * 314159;
            value = value % 1000000;
            String ret = String.valueOf((int) value);
            resultTv.setText(ret);
        }
        else if (input.length() < 6){
            solutionTv.append(buttonText);
        }
    }

}