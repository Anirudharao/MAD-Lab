package com.example.lab5_spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView nameLabel = findViewById(R.id.textView2);
        nameLabel.setText(name);

        Toast.makeText(this, "Received text: " + name, Toast.LENGTH_SHORT).show();
    }
}