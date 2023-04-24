package com.example.lab5_spinners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.button);

        // Set up spinner adapter
        String[] items = new String[]{"Item 1", "Item 2", "Item 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        // Set up button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user's name from EditText
                String name = editText.getText().toString();

                // Get selected item from spinner
                String selectedItem = spinner.getSelectedItem().toString();

                // Show toast message with name and selected item
                //Toast.makeText(getApplicationContext(), "Hello, " + name + "! You selected " + selectedItem + ".", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("name", name);

                startActivity(intent);
            }
        });
    }
}
