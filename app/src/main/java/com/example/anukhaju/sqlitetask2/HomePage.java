package com.example.anukhaju.sqlitetask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
TextView txtres;

    SignUp signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        signUp=new SignUp(HomePage.this);

        String mob=getIntent().getStringExtra("Mobile");

        String dbName=signUp.gett(mob);

        txtres=findViewById(R.id.txtres);
        txtres.setText("Welcome"+dbName);
    }
}
