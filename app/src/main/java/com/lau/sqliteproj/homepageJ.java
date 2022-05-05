package com.lau.sqliteproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class homepageJ extends AppCompatActivity {
    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        Intent i = new Intent(this, secondPageJ.class);
        try {
            sqliteDB = this.openOrCreateDatabase("fExamsdb", MODE_PRIVATE, null);
            sqliteDB.execSQL("CREATE Table IF NOT EXISTS exams(subject VARCHAR, webpage VARCHAR)");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Android Development','https://developer.android.com/docs')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Discrete Math','https://www.coursera.org/courses?query=discrete%20mathematics')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Operating System','https://maker.pro/linux/tutorial/basic-linux-commands-for-beginners')");
            sqliteDB.execSQL("INSERT INTO exams(subject,webpage) VALUES ('Software Engineering','https://www.edx.org/learn/software-engineering')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}