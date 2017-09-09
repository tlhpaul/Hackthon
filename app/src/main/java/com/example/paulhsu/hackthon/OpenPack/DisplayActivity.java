package com.example.paulhsu.hackthon.OpenPack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.paulhsu.hackthon.NutrientPack.NutrientDisplay;
import com.example.paulhsu.hackthon.NutrientPack.NutrientTracker;
import com.example.paulhsu.hackthon.R;
import com.example.paulhsu.hackthon.ScanPack.GrabBarcode;

import java.util.Scanner;


public class DisplayActivity extends Activity {
    private String[] arraySpinner;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home Page");
        setContentView(R.layout.activity_display);
        this.arraySpinner = new String[] {
                "low protein", "high protein", "low sugar", "high suagr", "low fat", "high fat"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        if (s.getSelectedItem().toString() != null) {
            answer = s.getSelectedItem().toString();
        }

    }

    public void clickedScanButton(View v) {
        Intent intent = new Intent(this, GrabBarcode.class);
        startActivity(intent);
    }

    public void clickedStatusButton(View v) {
        Intent intent = new Intent(this, NutrientDisplay.class);
        startActivity(intent);
    }



//
//
//    public void onItemSelected(AdapterView<?> parent, View view, int position,
//                               long id) {
//        // TODO Auto-generated method stub
//        Toast.makeText(this, "YOUR SELECTION IS : " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//
//
//    }

}
