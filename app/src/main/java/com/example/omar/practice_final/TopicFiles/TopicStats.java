package com.example.omar.practice_final.TopicFiles;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.omar.practice_final.DatabaseHelper;
import com.example.omar.practice_final.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

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

        mChart = (LineChart) findViewById(R.id.linechart);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_html_stats, menu);
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
