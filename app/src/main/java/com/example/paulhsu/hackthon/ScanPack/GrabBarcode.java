package com.example.paulhsu.hackthon.ScanPack;

import android.app.Activity;
import android.os.Bundle;

import com.example.paulhsu.hackthon.R;

public class GrabBarcode extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_display);
    }
}

