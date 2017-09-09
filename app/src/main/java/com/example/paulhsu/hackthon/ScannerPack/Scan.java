package com.example.paulhsu.hackthon.ScannerPack;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import com.example.paulhsu.hackthon.R;

import java.io.IOException;

public class Scan extends Activity {
    SurfaceView cameraPreview;
    private static final String SCANTAG = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_display);
        Button scanButton = (Button) findViewById(R.id.button);
        cameraPreview = (SurfaceView)findViewById(R.id.cameraPreview);
        scanButton.setOnClickListener(new View.OnClickListener() {
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
                    .setActionTextColor(getResources().getColor(R.color.blue))
                    .setDuration(3000).show();
            return null;
        }
        return interpretBitmap(detector);
    }
    private SparseArray<Barcode> interpretBitmap(BarcodeDetector detector){
//        Bitmap myBitmap = grabBitMap(detector);
//        Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
//        return detector.detect(frame);
        return new SparseArray<Barcode>();
    }

    private void grabBitMap(BarcodeDetector detector){ //will be bitmap
        final CameraSource cameraSource = new CameraSource.Builder(this, detector)
                .build();
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try{
                    cameraSource.start(cameraPreview.getHolder());
                }catch (IOException e){
                    Log.e(SCANTAG, "Camera Permission still not available");
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
}
