package com.example.paulhsu.hackthon.OpenPack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.paulhsu.hackthon.NutrientPack.NutrientDisplay;
import com.example.paulhsu.hackthon.NutrientPack.NutrientTracker;
import com.example.paulhsu.hackthon.R;
import com.example.paulhsu.hackthon.ScannerPack.Scan;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home Page");
        setContentView(R.layout.activity_display);
    }

    public void clickedScanButton(View v) {
        Intent intent = new Intent(this, Scan.class);
        startActivity(intent);
    }

    public void clickedStatusButton(View v) {
        Intent intent = new Intent(this, NutrientDisplay.class);
        startActivity(intent);
    }



}
