package com.example.paulhsu.hackthon.NutrientPack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.paulhsu.hackthon.R;
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
    private ArrayList<BarEntry> entries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrient_display);
        chart = (BarChart)findViewById(R.id.chart);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");

        BARDATA = new BarData(Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);
    }

    private void updateEntries(ArrayList<Integer> nutrients){
        if(entries.size() != nutrients.size()) {
            for (int i = 0; i < nutrients.size(); i++) {
                entries.add(new BarEntry(nutrients.get(i), i));
            }
        }else{
            for(int i = 0; i < nutrients.size(); i++){
                entries.get(i).setX(entries.get(i).getX() + nutrients.get(i));
            }
        }
    }

    public void updateVisual(ArrayList<Integer> nutrients){
        BarDataSet dataSet = new BarDataSet(entries, "Nutrient percent");
        BarData barData = new BarData(dataSet);
        chart.setData(barData);
        chart.invalidate();
    }

    public void AddValuesToBARENTRY(){
        BARENTRY.add(new BarEntry(2f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(8f, 3));
        BARENTRY.add(new BarEntry(7f, 4));
        BARENTRY.add(new BarEntry(3f, 5));
    }

    public void AddValuesToBarEntryLabels(){
        BarEntryLabels.add("January");
        BarEntryLabels.add("February");
        BarEntryLabels.add("March");
        BarEntryLabels.add("April");
        BarEntryLabels.add("May");
        BarEntryLabels.add("June");
    }
}
