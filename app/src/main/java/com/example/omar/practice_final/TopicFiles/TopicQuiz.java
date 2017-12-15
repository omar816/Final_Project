package com.example.omar.practice_final.TopicFiles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omar.practice_final.DatabaseHelper;
import com.example.omar.practice_final.R;

import java.util.Random;

public class TopicQuiz extends AppCompatActivity {
    String topic, username;
    Button answer1, answer2, answer3, answer4;

    TextView score, question;
    String questionsDone;
    int qnum;

    private TopicQuizQuestions mQuestions = new TopicQuizQuestions();

    private String mAnswer;
    private int mScore=0;
    private int mQuestionLength;
    int quizNumber=0;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_quiz);
        topic = getIntent().getStringExtra("Topic");
        username = getIntent().getStringExtra("Username");
        questionsDone = "";
        qnum=0;
        switch(topic){
            case "HTML":
                quizNumber=1;
                break;
            case "CSS":
                quizNumber=2;
                break;
            case "JavaScript":
                quizNumber=3;
                break;
            case "Java":
                quizNumber=4;
                break;
            case "Cpp":
                quizNumber=5;
                break;
            case "Python":
                quizNumber=6;
                break;
            default:
                quizNumber=0;
                break;
        }

        mQuestionLength= mQuestions.mQuestions[quizNumber].length;
        r = new Random();

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        score.setText(getString(R.string.score_and_value, mScore));

        while(questionsDone.contains(String.valueOf(qnum))) {
            qnum = r.nextInt(mQuestionLength);
        }
        questionsDone+= " " + qnum;
        updateQuestion(qnum);
    }

    public void onClick(View v) {
        Button b = (Button)v;
        if(b.getText().equals(mAnswer)){
            endQuestion();
        }else{
            gameover();
        }
    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(quizNumber, num));
        answer1.setText(mQuestions.getChoice1(quizNumber, num));
        answer2.setText(mQuestions.getChoice2(quizNumber, num));
        answer3.setText(mQuestions.getChoice3(quizNumber, num));
        answer4.setText(mQuestions.getChoice4(quizNumber, num));

        mAnswer = mQuestions.getCorrectAnswers(quizNumber, num);

    }

    private void endQuestion(){
        mScore++;
        if (mScore>=mQuestionLength){
            Toast winMsg = Toast.makeText(getApplicationContext(),
                    R.string.win, Toast.LENGTH_LONG);
            winMsg.show();
            gameover();
        }else{
            score.setText(getString(R.string.score_and_value, mScore));
            while(questionsDone.contains(String.valueOf(qnum))) {
                qnum = r.nextInt(mQuestionLength);
            }
            questionsDone+= " " + qnum;
            updateQuestion(qnum);
        }
    }

        private void gameover(){
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.insertRecord(topic,username, mScore, mQuestionLength);
        String x = helper.getRecord(topic,username);
        System.out.println(x);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TopicQuiz.this);
        alertDialogBuilder
                .setMessage(getString(R.string.gameOver, mScore))
                .setCancelable(false)
                .setPositiveButton(R.string.newGame,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Intent i = new Intent(getApplicationContext(), TopicQuiz.class);
                                i.putExtra("Topic", topic);
                                i.putExtra("Username", username);
                                startActivity(i);
                            }
                        })
                .setNegativeButton(R.string.exit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Intent i = new Intent(getApplicationContext(), TopicActivity.class);
                                i.putExtra("Topic", topic);
                                i.putExtra("Username", username);
                                startActivity(i);

                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_html_quiz, menu);
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
