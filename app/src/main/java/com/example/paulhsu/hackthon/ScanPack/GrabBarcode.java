package com.example.paulhsu.hackthon.ScanPack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import com.example.paulhsu.hackthon.NutrientPack.NutrientTracker;
import com.example.paulhsu.hackthon.R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;

public class GrabBarcode extends Activity {
    private Barcode barcode = new Barcode();
    private static ArrayList<int[]> purchasedItems = null;
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
                    purchasedItems = new BarcodeQuery(barcode).convert();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }


    public ArrayList<int[]> getPurchasedItems() {
        return purchasedItems;
    }


}

