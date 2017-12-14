package com.example.omar.practice_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.omar.practice_final.TopicFiles.TopicActivity;

public class ActivityList extends AppCompatActivity {

    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), TopicActivity.class);

        switch(view.getId()){
            case R.id.htmlButton:
                i.putExtra("Topic", "HTML");
                break;
            case R.id.javaButton:
                i.putExtra("Topic", "Java");
                break;
            case R.id.jsButton:
                i.putExtra("Topic", "JavaScript");
                break;
            case R.id.cssButton:
                i.putExtra("Topic", "CSS");
                break;
            case R.id.cppButton:
                i.putExtra("Topic", "Cpp");
                break;
            case R.id.pythonButton:
                i.putExtra("Topic", "Python");
                break;
        }
        i.putExtra("Username", getIntent().getStringExtra("Username"));
        startActivity(i);
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
