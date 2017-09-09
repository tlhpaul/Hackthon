package com.example.paulhsu.hackthon.ScannerPack;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import com.example.paulhsu.hackthon.R;

public class Scan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_display);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private SparseArray<Barcode> scanImage(){
        BarcodeDetector detector =
                new BarcodeDetector.Builder(getApplicationContext())
                        .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                        .build();
        if(!detector.isOperational()){
            //findView is wrong
            Snackbar.make(findViewById(R.id.match_parent), R.string.invalid_snackbar, Snackbar.LENGTH_LONG)
                    .setActionTextColor(getResources().getColor(R.color.BLUE))
                    .setDuration(3000).show();
            return null;
        }
        return interpretBitmap(detector);
    }
    private SparseArray<Barcode> interpretBitmap(BarcodeDetector detector){
        Bitmap myBitmap = grabBitMap(detector);
        Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
        return detector.detect(frame);
    }

    private Bitmap grabBitMap(BarcodeDetector detector){
        final CameraSource cameraSource = new CameraSource.Builder(this, detector).build();
    }
}
