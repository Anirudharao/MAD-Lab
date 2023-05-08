package com.example.endsem_practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textView;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button1 = (Button) findViewById(R.id.button1);

        String text = getIntent().getExtras().getString("n");
        String temp = getIntent().getStringExtra("n");

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(temp);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextSize(50);
                textView.setBackgroundColor(Color.BLACK);
                textView.setTextColor(Color.YELLOW);
            }
        });
    }
}