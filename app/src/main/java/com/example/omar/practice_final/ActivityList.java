package com.example.omar.practice_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

}
