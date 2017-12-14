package com.example.omar.practice_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username = getIntent().getStringExtra("Username");
        ((TextView)findViewById(R.id.textUsername)).setText(username);
        DatabaseHelper helper = new DatabaseHelper(this);
        ProgressUpdater progressUpdater = new ProgressUpdater();




        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBarHTML);
        progressUpdater.updateProgressBar(progressBar,helper,"HTML", username);

         progressBar=(ProgressBar)findViewById(R.id.progressBarCSS);
        progressUpdater.updateProgressBar(progressBar,helper,"CSS", username);

         progressBar=(ProgressBar)findViewById(R.id.progressBarJS);
        progressUpdater.updateProgressBar(progressBar,helper,"JavaScript", username);

         progressBar=(ProgressBar)findViewById(R.id.progressBarJava);
        progressUpdater.updateProgressBar(progressBar,helper,"Java", username);

        progressBar=(ProgressBar)findViewById(R.id.progressBarCpp);
        progressUpdater.updateProgressBar(progressBar,helper,"Cpp", username);

        progressBar=(ProgressBar)findViewById(R.id.progressBarPython);
        progressUpdater.updateProgressBar(progressBar,helper,"Python", username);
        helper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
//        findViewById(R.id.progressBar);
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
