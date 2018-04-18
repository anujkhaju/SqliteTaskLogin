package com.example.anukhaju.sqlitetask2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtMobile,edtPass;
    SignUp signUp;
    String mob,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMobile=findViewById(R.id.edtMobile);
        edtPass=findViewById(R.id.edtPass);
        signUp=new SignUp(MainActivity.this);
    }


    public void SignUp(View view) {

        Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void SignIn(View view) {
        mob=edtMobile.getText().toString();
        pas=edtPass.getText().toString();

        String dbPass=signUp.get(mob);

        if(dbPass.equals(pas)){
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("Mobile",mob);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Warning!!");
            alert.setMessage("Username or Password is Incorrect!");
            alert.show();
        }

    }
}
