package com.example.paulhsu.hackthon.ScanPack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import com.example.paulhsu.hackthon.R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class GrabBarcode extends Activity {
    private SparseArray<Barcode> barcode = new SparseArray<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_display);
    }

    public void scanBarcode(View v){
        Intent intent = new Intent(this, Scan.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 0){
            if(resultCode == CommonStatusCodes.SUCCESS){
                if(data != null){
                    barcode = data.getParcelableExtra("barcode");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public SparseArray<Barcode> getBarcode() {
        return barcode;
    }

}

