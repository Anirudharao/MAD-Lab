package com.example.lab7_contextual_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    private Button contextualMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextualMenuButton = findViewById(R.id.contextual_menu_button);
        contextualMenuButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                showContextMenu(v);
                return true;
            }
        });

    }

        private void showContextMenu(View v) {
            PopupMenu popupMenu = new PopupMenu(this, v);
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.contextual_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {


                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_item_1:
                            Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                            startActivity(intent);
                            return true;
                        case R.id.menu_item_2:
                            // Handle menu item 2 click
                            return true;
                        case R.id.menu_item_3:
                            // Handle menu item 3 click
                            return true;
                        default:
                            return false;
                    }
                }
            });
            popupMenu.show();
        }


}