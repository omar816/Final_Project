package com.example.omar.practice_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.omar.practice_final.HtmlFiles.HtmlActivity;

public class ActivityList extends AppCompatActivity {

    public void onClick(View view) {
        if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }
        /*if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }
        if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }
        if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }
        if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }
        if(view.getId() == R.id.htmlButton) {
            Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
            startActivity(i);
        }*/


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_list, menu);
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
