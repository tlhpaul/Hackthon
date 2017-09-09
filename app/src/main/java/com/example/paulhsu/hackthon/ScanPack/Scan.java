package com.example.paulhsu.hackthon.ScanPack;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

import com.example.paulhsu.hackthon.R;
import com.google.android.gms.vision.barcode.BarcodeDetector;

class Scan extends Activity {
    SurfaceView cameraPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_layout);
        cameraPreview = (SurfaceView)findViewById(R.id.cameraPreview);
        //getCameraSource();
    }

//    private void getCameraSource(){
//        BarcodeDetector;
//    }
}
