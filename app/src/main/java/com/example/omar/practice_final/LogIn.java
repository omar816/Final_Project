package com.example.omar.practice_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    public void onClick(View view) {

        if(view.getId() == R.id.logIn) {

            EditText userData = findViewById(R.id.logInUser);
            String userString = userData.getText().toString();

            EditText passData = findViewById(R.id.logInPass);
            String passString = passData.getText().toString();

            String password = helper.searchPass(userString);
            if(passString.equals(password)){
                Intent i = new Intent(LogIn.this, MainMenu.class);
                i.putExtra("Username", userString);
                startActivity(i);
            } else {
                Toast accptMsg = Toast.makeText(getApplicationContext(),
                        R.string.badLogin, Toast.LENGTH_SHORT);
                accptMsg.show();
            }


        }
        if(view.getId() == R.id.signUpButton) {
            Intent intent = new Intent(LogIn.this, SignUpActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


    }

}
