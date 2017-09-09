package com.example.paulhsu.hackthon.ScanPack;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import com.google.android.gms.vision.barcode.Barcode;

class BarcodeQuery{
    Barcode barcode;
    public BarcodeQuery(Barcode barcode){
        this.barcode = barcode;
    }


}
