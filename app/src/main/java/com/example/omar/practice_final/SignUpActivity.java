package com.example.omar.practice_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    public void onSignUpClick(View view) {

        if(view.getId()==R.id.BsignupButton){
            EditText name = findViewById(R.id.TFname);
            EditText username = findViewById(R.id.TFuname);
            EditText pass = findViewById(R.id.TFpass);
            EditText cPass = findViewById(R.id.TFcPass);

            String nameStr = name.getText().toString();
            String unameStr = username.getText().toString();
            String passStr = pass.getText().toString();
            String cPassStr = cPass.getText().toString();

            if(!passStr.equals(cPassStr)) {
                // toast if retyped password doesn't match
                Toast passMsg = Toast.makeText(SignUpActivity.this, R.string.noMatch, Toast.LENGTH_SHORT);
                passMsg.show();
            }
            else
            {
                // creates new user
                Contact c = new Contact();
                c.setName(nameStr);
                c.setUname(unameStr);
                c.setPass(passStr);

                // adds user to the database along with progress in quizzes
                helper.insertContact(c);
                helper.createTopicRecord("HTML", unameStr);
                helper.createTopicRecord("CSS", unameStr);
                helper.createTopicRecord("JavaScript", unameStr);
                helper.createTopicRecord("Java", unameStr);
                helper.createTopicRecord("Cpp", unameStr);
                helper.createTopicRecord("Python", unameStr);


                Toast accptMsg = Toast.makeText(getApplicationContext(), R.string.infoAccepted, Toast.LENGTH_SHORT);
                accptMsg.show();

                // return to the login menu
                Intent i = new Intent(getApplicationContext(), LogIn.class);
                startActivity(i);
            }
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

}
