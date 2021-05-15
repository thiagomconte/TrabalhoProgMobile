package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.trabalho.dataBase.DBHelper;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}