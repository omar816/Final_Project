package com.example.omar.practice_final.HtmlFiles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.omar.practice_final.R;

public class HtmlActivity extends AppCompatActivity {
    String topic;

    public void clickFunction(View view) {
        String urlString="";
        if (view.getId() == R.id.conceptButton) {
            switch (topic){
                case "HTML":
                    urlString= "https://en.wikipedia.org/wiki/HTML";
                    break;
                case "Java":
                    urlString ="https://en.wikipedia.org/wiki/Java_(programming_language)";
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
            Intent i = new Intent(getApplicationContext(), HtmlQuiz.class);
            i.putExtra("Topic", topic);
            startActivity(i);
        }
        if (view.getId() == R.id.statButton) {
            Intent i = new Intent(getApplicationContext(), HtmlStats.class);
            i.putExtra("Topic", topic);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topic = getIntent().getStringExtra("Topic");
        setContentView(R.layout.activity_html);
        TextView topicText = (TextView)findViewById(R.id.topicText);
        topicText.setText(topic);
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
