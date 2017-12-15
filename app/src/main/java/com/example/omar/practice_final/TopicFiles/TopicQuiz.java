package com.example.omar.practice_final.TopicFiles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.omar.practice_final.DatabaseHelper;
import com.example.omar.practice_final.R;

import java.util.Random;

public class TopicQuiz extends AppCompatActivity {

    //initialize relevant variables
    String topic, username, endMessage;
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

    private SoundPool soundPool;
    private int soundWin, soundLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_quiz);

        Resources res = getResources();

        // load a sound effect
        AssetFileDescriptor sound1Fd = res.openRawResourceFd(R.raw.kids_booing);
        AssetFileDescriptor sound2Fd = res.openRawResourceFd(R.raw.kids_cheering);
        SoundPool.Builder spBuilder = new SoundPool.Builder();
        spBuilder.setMaxStreams(20);
        soundPool = spBuilder.build();

        soundLose = soundPool.load(sound1Fd, 1);
        soundWin = soundPool.load(sound2Fd, 1);

        topic = getIntent().getStringExtra("Topic");
        username = getIntent().getStringExtra("Username");
        questionsDone = "";
        qnum=0;

        //choose the right case
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

        //add the answers to the right question
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        //initializing the score and question textviews
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        //score will take the values of mScore
        score.setText(getString(R.string.score_and_value, mScore));

        //get num values of all question
        while(questionsDone.contains(String.valueOf(qnum))) {
            qnum = r.nextInt(mQuestionLength);
        }
        questionsDone+= " " + qnum;
        updateQuestion(qnum);
    }

    //initializing volume controls
    public void onClick(View v) {
        Button b = (Button)v;
        if(b.getText().equals(mAnswer)){
            endQuestion();
        }else{
            soundPool.play(soundLose,
                    1f, 1f,
                    0, 0, 1f);
            endMessage = getString(R.string.gameOver, mScore);
            gameover();
        }
    }

    private void updateQuestion(int num) {

        //updating the question text to the textview
        question.setText(mQuestions.getQuestion(quizNumber, num));
        answer1.setText(mQuestions.getChoice1(quizNumber, num));
        answer2.setText(mQuestions.getChoice2(quizNumber, num));
        answer3.setText(mQuestions.getChoice3(quizNumber, num));
        answer4.setText(mQuestions.getChoice4(quizNumber, num));

        mAnswer = mQuestions.getCorrectAnswers(quizNumber, num);

    }

    private void endQuestion(){
        //applies at the end of a question
        //score is incremented then
        //appropriate sound is played at success oor failure of quiz question

        mScore++;
        if (mScore>=mQuestionLength){
            soundPool.play(soundWin,
                    1f, 1f,
                    0, 0, 1f);
            endMessage = getString(R.string.gameWon, mScore);
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

    //at game over, the database records the appropriate values
        private void gameover(){
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.insertRecord(topic,username, mScore, mQuestionLength);
        String x = helper.getRecord(topic,username);
        System.out.println(x);

        //Upon quiz end, prompt the user to retry or exit the module
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TopicQuiz.this);
        alertDialogBuilder
                .setMessage(endMessage)
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

}
