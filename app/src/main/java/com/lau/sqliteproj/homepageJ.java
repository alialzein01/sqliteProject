package com.lau.sqliteproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class homepageJ extends AppCompatActivity {
    SQLiteDatabase sqliteDB;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        i = new Intent(this, secondPageJ.class);
        //SQL commands to initialize the DB and insert data
        try {
            sqliteDB = this.openOrCreateDatabase("fExamsdb", MODE_PRIVATE, null);
            /*sqliteDB.execSQL("CREATE Table IF NOT EXISTS exams(subject VARCHAR, webpage VARCHAR)");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Android Development','https://developer.android.com/docs')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Discrete Math','https://www.coursera.org/courses?query=discrete%20mathematics')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Operating System','https://maker.pro/linux/tutorial/basic-linux-commands-for-beginners')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Software Engineering','https://www.edx.org/learn/software-engineering')");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to get the webpage url from the DB
    public String getWebpage(String subject) {
        String url = "";
        try {
            Cursor cursor = sqliteDB.rawQuery("Select webpage from exams where subject = \"" + subject + "\"", null);
            int n = cursor.getColumnIndex("webpage");
            cursor.moveToFirst();
            url = cursor.getString(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    //methods to send urls to the webpage according to the selected course
    public void androidWeb(View view) {
        String url = getWebpage("Android Development");
        i.putExtra("WebURL", url);
        startActivity(i);
    }
    public void discreteWeb(View view) {
        String url = getWebpage("Discrete Math");
        i.putExtra("WebURL", url);
        startActivity(i);
    }
    public void osWeb(View view) {
        String url = getWebpage("Operating System");
        i.putExtra("WebURL", url);
        startActivity(i);
    }
    public void seWeb(View view) {
        String url = getWebpage("Software Engineering");
        i.putExtra("WebURL", url);
        startActivity(i);
    }

}