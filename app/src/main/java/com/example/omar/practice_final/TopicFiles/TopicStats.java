package com.example.omar.practice_final.TopicFiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.omar.practice_final.DatabaseHelper;
import com.example.omar.practice_final.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class TopicStats extends AppCompatActivity{
    String topic;
    String username;
    //TextView textStats; - associated with textview scrolling

    private static final String TAG = "TopicStats";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_stats);
        topic = getIntent().getStringExtra("Topic");
        username = getIntent().getStringExtra("Username");
        DatabaseHelper helper = new DatabaseHelper(this);

        //connect the score and attempt text data from the database class to stats variable
        String stats =  getString(R.string.topScore, helper.getTopScore(topic,username)[0], helper.getRecord(topic, username));

        ((TextView)findViewById(R.id.textStats)).setText(stats);
        //textStats.setMovementMethod(new ScrollingMovementMethod());
        //above function should make the code scroallable after it exceeds 10 lines

        Object[][] record = helper.getGraphData(topic, username);

        mChart = findViewById(R.id.linechart);
//        mChart.setOnChartGestureListener(TopicStats.this);
//        mChart.setOnChartValueSelectedListener(TopicStats.this);
        //insert above code for older android version, else disregard

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        //initialize arrayList for line graph node locations
        ArrayList<Entry> yValues1 = new ArrayList<>();

        for(int i =0; i<record[0].length; i++){
            yValues1.add(new Entry(i+1,((int) record[1][i])));
        }

        LineDataSet set1 = new LineDataSet(yValues1, username + "'s record");
        //initialize the graph legends

        //add characteristics to the line graph
        set1.setFillAlpha(110);
        set1.setColor(Color.BLUE);
        set1.setLineWidth(2f);
        set1.setCircleHoleRadius(3f);
        //set1.set

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        mChart.setData(data);
    }

}
