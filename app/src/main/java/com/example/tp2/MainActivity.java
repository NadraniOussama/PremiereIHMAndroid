package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button quitButton,equalButton,resetButton;
    private RadioGroup radioGroup;
    private EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        quitButton = (Button) findViewById(R.id.button3);
        equalButton = (Button) findViewById(R.id.button2);
        resetButton = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editNumber1);
        editText2 = (EditText) findViewById(R.id.editNumber2);


        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editText.getText().toString());
                int num2 = Integer.parseInt(editText2.getText().toString());
                int chechedOp = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(chechedOp);
                String operationName = "";
                operationName =rb.getText().toString();
                double result = num2;
                if (operationName.equals("Plus") ) {
                    result = num1 + num2;
                    textView.setText(result+"");
                }
                else if (operationName.equals("Moins")) {
                    result = num1 - num2;
                    textView.setText(result+"");
                }
                else if (operationName.equals("Devise") )
                    if (num2!=0){
                        result = num1 /(double) num2;
                        textView.setText(result+"");
                    }
                    else
                        textView.setText("Impossible de deviser par 0 ");

                else if (operationName.equals("Multiplie")) {
                    result = num1 * num2;
                    textView.setText(operationName);
                }
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                textView.clearComposingText();
                editText.setText("");
                editText2.setText("");
//                TODO: editText clear pls
            }
        });
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }


}