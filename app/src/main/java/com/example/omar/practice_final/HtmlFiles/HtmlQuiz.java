package com.example.omar.practice_final.HtmlFiles;

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

import com.example.omar.practice_final.R;

import java.util.Random;

public class HtmlQuiz extends AppCompatActivity {
    String topic;
    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    private HtmlQuizQuestions mQuestions = new HtmlQuizQuestions();

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
            case "C++":
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

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mQuestionLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }else{
                    gameover();
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }else{
                    gameover();
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }else{
                    gameover();
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }else{
                    gameover();
                }

            }
        });
    }

    private  void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(quizNumber, num));
        answer1.setText(mQuestions.getChoice1(quizNumber, num));
        answer2.setText(mQuestions.getChoice2(quizNumber, num));
        answer3.setText(mQuestions.getChoice3(quizNumber, num));
        answer4.setText(mQuestions.getChoice4(quizNumber, num));

        mAnswer = mQuestions.getCorrectAnswers(quizNumber, num);

    }

    private void gameover(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HtmlQuiz.this);
        alertDialogBuilder
                .setMessage("Game over! You're score is " + mScore)
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Intent i = new Intent(getApplicationContext(), HtmlQuiz.class);
                                i.putExtra("Topic", topic);
                                startActivity(i);
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

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
