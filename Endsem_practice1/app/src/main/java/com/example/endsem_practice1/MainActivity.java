package com.example.endsem_practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private RadioButton radio1, radio2;
    private ImageView image1, image2;
    private ToggleButton toggleButton;
    private ImageButton imageButton;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        textView2 = (TextView) findViewById(R.id.textView2);

        String c = getIntent().getStringExtra("course");



        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("n", "Hello69");
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HEllo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("n", "Hello69420");
                startActivity(intent);
            }
        });

        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText(c);
            }
        });
    }
}