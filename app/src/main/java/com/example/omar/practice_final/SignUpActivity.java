package com.example.omar.practice_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    public void onSignUpClick(View view) {

        if(view.getId()==R.id.BsignupButton){
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText username = (EditText)findViewById(R.id.TFuname);
            EditText pass = (EditText)findViewById(R.id.TFpass);
            EditText cPass = (EditText)findViewById(R.id.TFcPass);

            String nameStr = name.getText().toString();
            String unameStr = username.getText().toString();
            String passStr = pass.getText().toString();
            String cPassStr = cPass.getText().toString();

            if(!passStr.equals(cPassStr)) {
                //popup toast
                Toast passMsg = Toast.makeText(SignUpActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                passMsg.show();
            }
            else
            {
                Contact c = new Contact();
                c.setName(nameStr);
                c.setUname(unameStr);
                c.setPass(passStr);

                helper.insertContact(c);

                Toast accptMsg = Toast.makeText(getApplicationContext(), "Information Accepted!", Toast.LENGTH_SHORT);
                accptMsg.show();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
