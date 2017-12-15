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
    //TextView textStats;

    private static final String TAG = "TopicStats";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_stats);
        topic = getIntent().getStringExtra("Topic");
        username = getIntent().getStringExtra("Username");
        DatabaseHelper helper = new DatabaseHelper(this);
        String stats =  getString(R.string.topScore, helper.getTopScore(topic,username)[0], helper.getRecord(topic, username));
        ((TextView)findViewById(R.id.textStats)).setText(stats);
        //textStats.setMovementMethod(new ScrollingMovementMethod());

        Object[][] record = helper.getGraphData(topic, username);

        mChart = (LineChart) findViewById(R.id.linechart);
//        mChart.setOnChartGestureListener(TopicStats.this);
//        mChart.setOnChartValueSelectedListener(TopicStats.this);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues1 = new ArrayList<>();
  /*      yValues1.add(new Entry(0, 2f));
        yValues1.add(new Entry(1, 3f));
        yValues1.add(new Entry(2, 5f));
        yValues1.add(new Entry(3, 4f));
        yValues1.add(new Entry(4, 12f));
        yValues1.add(new Entry(5, 17f));*/

        for(int i =0; i<=record.length; i++){
            yValues1.add(new Entry(i,((int) record[1][i])));
        }

        LineDataSet set1 = new LineDataSet(yValues1, username + "'s record");



        set1.setFillAlpha(110);
        set1.setColor(Color.BLUE);
        set1.setLineWidth(2f);
        set1.setCircleHoleRadius(3f);
        //set1.set
/*
        ArrayList<Entry> yValues2 = new ArrayList<>();
        yValues2.add(new Entry(0, 3f));
        yValues2.add(new Entry(1, 5f));
        yValues2.add(new Entry(2, 6f));
        yValues2.add(new Entry(3, 11f));
        yValues2.add(new Entry(4, 14f));
        yValues2.add(new Entry(5, 16f));
        LineDataSet set2 = new LineDataSet(yValues2, "Average record");

        set2.setFillAlpha(110);
        set2.setColor(Color.RED);
        set2.setLineWidth(2f);
        set2.setCircleHoleRadius(3f);
        //set2.set
*/
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
    //    dataSets.add(set2);

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
