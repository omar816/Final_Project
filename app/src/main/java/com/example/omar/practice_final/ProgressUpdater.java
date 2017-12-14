package com.example.omar.practice_final;

import android.widget.ProgressBar;

/**
 * Created by andre on 14-Dec-2017.
 */

public class ProgressUpdater {

    public ProgressUpdater(){

    }

    public void updateProgressBar(ProgressBar progressBar, DatabaseHelper helper, String topic, String username){
        progressBar.setMax(100);
        int[] fractionProgress = helper.getTopScore(topic,username);
        double percentProgress = ((double)fractionProgress[0]/(double)fractionProgress[1])*100.00;
        progressBar.setProgress((int) percentProgress);
    }
}
