package com.example.paulhsu.hackthon.NutrientPack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.paulhsu.hackthon.OpenPack.DisplayActivity;
import com.example.paulhsu.hackthon.R;
import com.example.paulhsu.hackthon.ScanPack.GrabBarcode;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;


public class NutrientDisplay extends Activity {
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;
    private BarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrient_display);
        chart = (BarChart)findViewById(R.id.chart);

        BARENTRY = new ArrayList<>();
        final String strategy = DisplayActivity.getAnswer();
        BarEntryLabels = new ArrayList<>();
        NutrientTracker tracker = new NutrientTracker(7, new NutrientBlockMaker(strategy).
                getNutrientBlocks());
        updateTracker(tracker, new GrabBarcode().getPurchasedItems());
        float[] entries = tracker.getPercentConsumed();
        updateVisual(entries);

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");

        BARDATA = new BarData(Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);
    }

    private ArrayList<BarEntry> updateEntries(float[] nutrients){
        ArrayList<BarEntry> entries = new ArrayList<>();
        if(entries.size() != nutrients.length) {
            for (int i = 0; i < nutrients.length; i++) {
                entries.add(new BarEntry(nutrients[i], i));
            }
        }else{
            for(int i = 0; i < nutrients.length; i++){
                entries.get(i).setX(entries.get(i).getX() + nutrients[i]);
            }
        }
        return entries;
    }

    private void updateVisual(float[] nutrients){
        BarDataSet dataSet = new BarDataSet(updateEntries(nutrients), "Nutrient percent");
        BarData barData = new BarData(dataSet);
        chart.setData(barData);
        chart.invalidate();
    }

    private void updateTracker(NutrientTracker tracker, ArrayList<int[]> boughtItems){
        for(int[] item: boughtItems){
            tracker.updateNutrients(item);
        }
    }

    public void AddValuesToBarEntryLabels(){
        BarEntryLabels.add("Calories");
        BarEntryLabels.add("Sugar");
        BarEntryLabels.add("Salt");
        BarEntryLabels.add("Carbs");
        BarEntryLabels.add("Fat");
        BarEntryLabels.add("Protein");
    }
}
