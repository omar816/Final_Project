package com.example.omar.practice_final.TopicFiles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.omar.practice_final.DatabaseHelper;
import com.example.omar.practice_final.ProgressUpdater;
import com.example.omar.practice_final.R;

public class TopicActivity extends AppCompatActivity {
    String topic;
    String username;
    public void clickFunction(View view) {
        String urlString;
        if (view.getId() == R.id.conceptButton) {
            switch (topic){
                case "HTML":
                    urlString= "https://en.wikipedia.org/wiki/HTML";
                    break;
                case "CSS":
                    urlString ="https://en.wikipedia.org/wiki/Cascading_Style_Sheets";
                    break;
                case "JavaScript":
                    urlString ="https://en.wikipedia.org/wiki/JavaScript";
                    break;
                case "Java":
                    urlString ="https://en.wikipedia.org/wiki/Java_(programming_language)";
                    break;
                case "Cpp":
                    urlString ="https://en.wikipedia.org/wiki/C%2B%2B";
                    break;
                case "Python":
                    urlString ="https://en.wikipedia.org/wiki/Python_(programming_language)";
                    break;
                default:
                    urlString = "https://www.google.ca/";
                    break;
            }
            Uri uriURL = Uri.parse(urlString);
            Intent i = new Intent(Intent.ACTION_VIEW, uriURL);
            startActivity(i);
        }
        if (view.getId() == R.id.quizButton) {
            finish();
            Intent i = new Intent(getApplicationContext(), TopicQuiz.class);
            i.putExtra("Topic", topic);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);

        }
        if (view.getId() == R.id.statButton) {
            Intent i = new Intent(getApplicationContext(), TopicStats.class);
            i.putExtra("Topic", topic);
            i.putExtra("Username", username);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper helper = new DatabaseHelper(this);
        topic = getIntent().getStringExtra("Topic");
        username = getIntent().getStringExtra("Username");
        setContentView(R.layout.activity_topic);
        TextView topicText = findViewById(R.id.topicText);
        topicText.setText(topic);
        ProgressBar progressBar=findViewById(R.id.progressBar); // initiate the progress bar
        ProgressUpdater progressUpdater = new ProgressUpdater();
        progressUpdater.updateProgressBar(progressBar,helper,topic, username);
        helper.close();
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
