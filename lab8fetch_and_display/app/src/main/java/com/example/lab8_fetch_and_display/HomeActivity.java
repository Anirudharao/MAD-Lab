package com.example.lab8_fetch_and_display;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<String>listItem = new ArrayList<String>();
//    listItem.add("Hello");
    ArrayAdapter adapter;
    DBHelper DB;
    ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DB = new DBHelper(this);
        userList = findViewById(R.id.user_list);
        showData();

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(HomeActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showData(){
//        Cursor cursor = DB.viewData();
//        System.out.println(cursor);
//        if(cursor.getCount() == 0) Toast.makeText(this, "No data to display", Toast.LENGTH_SHORT).show();
//        else{
//            while(cursor.moveToNext()){
//                listItem.add(cursor.getString(0));
//            }
//
//            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
//            userList.setAdapter(adapter);
//        }


//        listView = findViewById(R.id.listView);

        DB = new DBHelper(this);

        ArrayList<String> namesList = DB.getAllNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namesList);

        userList.setAdapter(adapter);
    }
}