package com.example.paulhsu.hackthon.ScanPack;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;


class BarcodeQuery{
    Barcode barcode;
    public BarcodeQuery(Barcode barcode){
        this.barcode = barcode;
    }

    //would convert but instead use fake
    public ArrayList<int[]> convert(){
        //would use barcode
        ArrayList<int[]> convertedList = new ArrayList<>();
        convertedList.add(new int[]{300, 20, 50, 50, 10, 20});
        convertedList.add(new int[]{300, 20, 50, 50, 10, 20});
        convertedList.add(new int[]{300, 20, 50, 50, 10, 20});
        convertedList.add(new int[]{300, 20, 50, 50, 10, 20});
        convertedList.add(new int[]{300, 20, 50, 50, 10, 20});
        return convertedList;
    }
}
