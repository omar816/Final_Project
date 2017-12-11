package com.example.omar.practice_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    public void onClick(View view) {

        if(view.getId() == R.id.logIn) {

            EditText userData = (EditText)findViewById(R.id.logInUser);
            String userString = userData.getText().toString();

            EditText passData = (EditText)findViewById(R.id.logInPass);
            String passString = passData.getText().toString();

            String password = helper.searchPass(userString);
            if(passString.equals(password)){
                Intent i = new Intent(LogIn.this, MainMenu.class);
                i.putExtra("Username", userString);
                startActivity(i);
            } else {
                Toast accptMsg = Toast.makeText(getApplicationContext(),
                        "INVALID LOGIN CREDENTIALS!", Toast.LENGTH_SHORT);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
