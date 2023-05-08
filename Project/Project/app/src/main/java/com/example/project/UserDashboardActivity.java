package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UserDashboardActivity extends AppCompatActivity {

    FloatingActionButton mAddFab;
    ListView notif_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        notif_list = findViewById(R.id.notif_list);

        showNotifications();

        mAddFab = findViewById(R.id.new_query);

        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, user_query.class);
                startActivity(intent);
            }
        });
    }

    public void showNotifications(){
        DBHelper DB = new DBHelper(this);
        ArrayList<String> namesList = DB.getAllNotifications();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namesList);

        notif_list.setAdapter(adapter);
    }
}