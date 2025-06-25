package com.example.myapplicationcalculatetips;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button calculate_tip;
    Button exit;
    EditText sum_value;
    EditText tip_value;
    TextView result_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sum_value = findViewById(R.id.sum_value);
        tip_value = findViewById(R.id.tip_value);
        result_value = findViewById(R.id.result_value);
        calculate_tip = findViewById(R.id.calc_tip);
        exit = findViewById(R.id.exit);
        calculate_tip.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String sum_valueStr = sum_value.getText().toString();
                String tip_valueSrt = tip_value.getText().toString();
                if (!sum_valueStr.isEmpty() && !tip_valueSrt.isEmpty()){
                    Double sum = Double.parseDouble(sum_valueStr);
                    Double tip = Double.parseDouble(tip_valueSrt);

                    Double amount = sum * (1 + tip/100);

                    String result = String.format("Сумма заказа: %.2f\nСумма чаевых: %.2f\nИтого: %.2f", sum, tip, amount );


                    result_value.setText(result);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}