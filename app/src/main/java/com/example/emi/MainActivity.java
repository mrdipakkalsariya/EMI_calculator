package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText principal,rate,time;
    Button submit,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.tinme);
        result = findViewById(R.id.result);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float p = Float.valueOf(principal.getText().toString());
                Float r = Float.valueOf(rate.getText().toString());
                Float n = Float.valueOf(time.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                result.setText("Your Payable Amount With Intrest : "+(f_ans+p)+"\n\n"+"Your Intrest is : "+f_ans);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principal.setText("");
                rate.setText("");
                time.setText("");
//                result.setText("");
            }
        });

    }
}