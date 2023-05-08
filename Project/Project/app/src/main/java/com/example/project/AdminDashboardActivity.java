package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDashboardActivity extends AppCompatActivity {

    private EditText adminNoticeTitle1, adminNoticePincode1, adminNoticeDetails1, adminNoticeCategory1;
    private Button adminNoticeSubmitButton1;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        DB = new DBHelper(this);

        adminNoticeTitle1 = (EditText) findViewById(R.id.adminNoticeTitle);
        adminNoticePincode1 = (EditText) findViewById(R.id.adminNoticePincode);
        adminNoticeDetails1 = (EditText) findViewById(R.id.adminNoticeDetails);
        adminNoticeCategory1 = (EditText) findViewById(R.id.adminNoticeCategory);
        adminNoticeSubmitButton1 = (Button) findViewById(R.id.adminNoticeSubmitButton);



        adminNoticeSubmitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pin, title, details, category;
                pin = adminNoticePincode1.getText().toString();
                title = adminNoticeDetails1.getText().toString();
                details = adminNoticeDetails1.getText().toString();
                category = adminNoticeCategory1.getText().toString();

//                if(pin.equals("576104")){
//                    Toast.makeText(AdminDashboardActivity.this, "The notification will be sent", Toast.LENGTH_SHORT).show();
//                } else if(pin == "hello" || title == "test"){
//                    Toast.makeText(AdminDashboardActivity.this, "The aksdfjl;asdkfj notification will be sent", Toast.LENGTH_SHORT).show();
//                }
                Toast.makeText(AdminDashboardActivity.this, "The notification will be sent", Toast.LENGTH_SHORT).show();
                DB.insertNotification(pin, title, details, 1, category);
            }
        });
    }
}