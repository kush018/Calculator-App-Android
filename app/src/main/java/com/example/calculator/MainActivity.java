package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView operation;
    private EditText newNumber;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.operation);
        newNumber = findViewById(R.id.newNumber);
        result = findViewById(R.id.result);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonDot = findViewById(R.id.buttonDot);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        View.OnClickListener numListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.getText().toString().equals("=")) {
                    operation.setText("");
                    result.setText("");
                    newNumber.setText("");
                }
                Button btn = (Button) view;
                String buttonText = btn.getText().toString();
                newNumber.append(buttonText);
            }
        };

        View.OnClickListener dotListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newNumber.getText().toString().length() > 0) {
                    newNumber.append(".");
                }
            }
        };

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String buttonText = btn.getText().toString();
                performOperation(buttonText);
            }
        };

        button0.setOnClickListener(numListener);
        button1.setOnClickListener(numListener);
        button2.setOnClickListener(numListener);
        button3.setOnClickListener(numListener);
        button4.setOnClickListener(numListener);
        button5.setOnClickListener(numListener);
        button6.setOnClickListener(numListener);
        button7.setOnClickListener(numListener);
        button8.setOnClickListener(numListener);
        button9.setOnClickListener(numListener);

        buttonDot.setOnClickListener(dotListener);

        buttonPlus.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonEquals.setOnClickListener(opListener);
    }

    private void performOperation(String buttonText) {
        if (result.getText().toString().equals("")) {
            if (!newNumber.getText().toString().equals("")) {
                result.setText(newNumber.getText().toString());
                newNumber.setText("");
                operation.setText(buttonText);
            }
        } else {
            if (newNumber.getText().toString().equals("")) {
                if (!buttonText.equals("=")) {
                    operation.setText(buttonText);
                }
            } else {
                double n1 = Double.parseDouble(result.getText().toString());
                double n2 = Double.parseDouble(newNumber.getText().toString());
                double ans;
                switch (operation.getText().toString()) {
                    case "+":
                        ans = n1 + n2;
                        break;
                    case "-":
                        ans = n1 - n2;
                        break;
                    case "*":
                        ans = n1 * n2;
                        break;
                    case "/":
                        ans = n1 / n2;
                        break;
                    default:
                        ans = n2;
                }
                result.setText(Double.toString(ans));
                newNumber.setText("");
                operation.setText(buttonText);
            }
        }
    }
}