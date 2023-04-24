package com.example.lab6_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menu_item_1:
                Toast.makeText(this, "Menu Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_2:
                Toast.makeText(this, "Menu Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_3:
                Toast.makeText(this, "Menu Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}