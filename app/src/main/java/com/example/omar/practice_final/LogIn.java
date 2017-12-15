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

    //initialize database helper for calling db items
    DatabaseHelper helper = new DatabaseHelper(this);

    //button click function
    public void onClick(View view) {

        //if statement for each button id
        if(view.getId() == R.id.logIn) {

            //login data is passed to a variable which is then checked
            //whether the data is in the sqlite table
            EditText userData = (EditText)findViewById(R.id.logInUser);
            String userString = userData.getText().toString();

            EditText passData = (EditText)findViewById(R.id.logInPass);
            String passString = passData.getText().toString();

            String password = helper.searchPass(userString);

            //checks if the inputted username and password match the data
            if(passString.equals(password)){
                Intent i = new Intent(LogIn.this, MainMenu.class);
                i.putExtra("Username", userString);
                startActivity(i);

            } else {

                //notification toast for error
                Toast accptMsg = Toast.makeText(getApplicationContext(),
                        R.string.badLogin, Toast.LENGTH_SHORT);
                accptMsg.show();
            }


        }
        //transfer to sign up page
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
