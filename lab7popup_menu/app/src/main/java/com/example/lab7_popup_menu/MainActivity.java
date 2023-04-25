package com.example.lab7_popup_menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_item_1:
                                handleMenuItemClick(1);
                                return true;
                            case R.id.menu_item_2:
                                handleMenuItemClick(2);
                                return true;
                            case R.id.menu_item_3:
                                handleMenuItemClick(3);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popup.show();
                return true;
            }
        });
    }

    private void handleMenuItemClick(int itemId) {
        // Handle menu item click based on ID
        switch (itemId) {
            case 1:
                // Handle menu item 1 click
                Toast.makeText(this, "Selected item1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                // Handle menu item 2 click
                Toast.makeText(this, "Selected item2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                // Handle menu item 3 click
                Toast.makeText(this, "Selected item3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
