package com.example.omar.practice_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    SQLiteDatabase db;

    private static final String USER_TABLE_CREATE = "create table contacts " +
            "(id integer primary key not null , " +
            "name text not null , uname text not null , pass text not null);";



    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
        this.db = db;
    }


    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());


        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public void createTopicRecord(String topic, String username){
        db = this.getWritableDatabase();
        String recordName = username+topic;
        String TOPIC_RECORD_TABLE_CREATE = "create table " + recordName +
                "(attempt integer not null, score integer not null, total integer not null);";
        System.out.println("created " + recordName);

        db.execSQL(TOPIC_RECORD_TABLE_CREATE);
        db.close();
        insertRecord(topic,username, 0, 1);
    }

    public void insertRecord(String topic, String username, int score, int total){
        db = this.getWritableDatabase();
        String recordName = username+topic;
        ContentValues values = new ContentValues();

        String query = "select * from " + recordName;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put("attempt",count);
        values.put("score", score);
        values.put("total", total);
        db.insert(recordName, null, values);
        db.close();
    }

    public String getRecord(String topic, String username){
        String result= "";

        //int[] scoreArray;
        db = this.getReadableDatabase();
        String recordName= username+topic;
        String query = "select attempt, score from " +recordName;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToNext();
        while(cursor.moveToNext()){
            //int i = 0;
            //int[] attemptArray[i] = cursor.getInt();
            result+= "Attempt: " + cursor.getInt(0);
            result+= " Score: " + cursor.getInt(1) + "\n";
        }
        db.close();
        return result;
    }

    public Object[][] getGraphData(String topic, String username){
        ArrayList<Integer> attempts = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        db = this.getReadableDatabase();
        String recordName=username+topic;
        String query = "select attempt, score from " +recordName;
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            //int i = 0;
            //int[] attemptArray[i] = cursor.getInt();
            attempts.add(cursor.getInt(0));
            scores.add(cursor.getInt(1));
        }
        Object[][] result = {attempts.toArray(),scores.toArray()};
        db.close();
        return result;
    }


    public int[] getTopScore(String topic, String username){
        int result[] ={0,0};
        String tableName = username+topic;
        db = this.getReadableDatabase();
        String query = "select score, total from " + tableName;
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()){
            result[1] = cursor.getInt(1);
            if (result[0]<cursor.getInt(0)){
                result[0] = cursor.getInt(0);

            }
        }

        db.close();
        return result;
    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                System.out.println(a);
                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
