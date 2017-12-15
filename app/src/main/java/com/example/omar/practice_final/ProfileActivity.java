package com.example.omar.practice_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

// shows quiz progress for all of the topics
public class ProfileActivity extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // displays current user name at the top of the view
        username = getIntent().getStringExtra("Username");
        ((TextView)findViewById(R.id.textUsername)).setText(username);
        DatabaseHelper helper = new DatabaseHelper(this);
        ProgressUpdater progressUpdater = new ProgressUpdater();



        // updates and displays progress bar for each topic to be learned
        ProgressBar progressBar=findViewById(R.id.progressBarHTML);
        progressUpdater.updateProgressBar(progressBar,helper,"HTML", username);

         progressBar=findViewById(R.id.progressBarCSS);
        progressUpdater.updateProgressBar(progressBar,helper,"CSS", username);

         progressBar=findViewById(R.id.progressBarJS);
        progressUpdater.updateProgressBar(progressBar,helper,"JavaScript", username);

         progressBar=findViewById(R.id.progressBarJava);
        progressUpdater.updateProgressBar(progressBar,helper,"Java", username);

        progressBar=(findViewById(R.id.progressBarCpp));
        progressUpdater.updateProgressBar(progressBar,helper,"Cpp", username);

        progressBar=findViewById(R.id.progressBarPython);
        progressUpdater.updateProgressBar(progressBar,helper,"Python", username);


        helper.close();
    }

}
