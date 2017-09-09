package com.example.paulhsu.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.paulhsu.hackthon.OpenPack.DisplayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchButton(View v) {
        Intent i = new Intent(this, DisplayActivity.class);


    }

}
