package com.example.omar.practice_final.HtmlFiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.omar.practice_final.R;

public class HtmlActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        if (view.getId() == R.id.conceptButton) {
            Intent i = new Intent(getApplicationContext(), HtmlContent.class);
            startActivity(i);
        }
        if (view.getId() == R.id.quizButton) {
            Intent i = new Intent(getApplicationContext(), HtmlQuiz.class);
            startActivity(i);
        }
        if (view.getId() == R.id.statButton) {
            Intent i = new Intent(getApplicationContext(), HtmlStats.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_html, menu);
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
