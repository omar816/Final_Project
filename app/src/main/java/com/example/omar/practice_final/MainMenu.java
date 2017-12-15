package com.example.omar.practice_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    String userx;

    // goes to menu to select a topic to learn
    public void beginLearning(View view) {
        Intent i = new Intent(getApplicationContext(), ActivityList.class);
        i.putExtra("Username", userx);
        startActivity(i);
    }
    // menu to view all progress in quizzes
    public void profile(View view) {
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        i.putExtra("Username", userx);
        startActivity(i);
    }
    // menu to compare progress to other users
    public void compare(View view) {
        Intent i = new Intent(getApplicationContext(), MapDisplay.class);
        i.putExtra("Username", userx);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // displays username on main menu
        userx = getIntent().getStringExtra("Username");
        TextView tv = findViewById(R.id.TVusername);
        tv.setText(userx);
    }

}
