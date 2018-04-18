package com.example.anukhaju.sqlitetask2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText edtName,edtMobile1,edtPass1,edtConfirmPass;
    Button btnSave;
    String Name,Mobile1,Pass1,ConfirmPass;
    SignUp signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtName=findViewById(R.id.edtName);
        edtMobile1=findViewById(R.id.edtMobile1);
        edtPass1=findViewById(R.id.edtPassword1);
        edtConfirmPass=findViewById(R.id.edtConfirmPass);
        btnSave=findViewById(R.id.btnSave);
        signUp=new SignUp(SignUpActivity.this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name=edtName.getText().toString();
                Mobile1=edtMobile1.getText().toString();
                Pass1=edtPass1.getText().toString();
                ConfirmPass=edtConfirmPass.getText().toString();

                if(Pass1.equals(ConfirmPass))
                {
                    long data=signUp.save(Name,Mobile1,Pass1);

                    Toast.makeText(SignUpActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                    // finish();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Warning!!");
                    alert.setMessage("Confirm Password does not match");
                    alert.show();
                }



            }
        });


    }


}
