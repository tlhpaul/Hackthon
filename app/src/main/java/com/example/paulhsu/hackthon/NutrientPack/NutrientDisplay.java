package com.example.paulhsu.hackthon.NutrientPack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.paulhsu.hackthon.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;


import java.util.ArrayList;


public class NutrientDisplay extends Activity {
    private BarChart chart;
    private ArrayList<BarEntry> entries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrient_display);
        chart = (BarChart)findViewById(R.id.chart);
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
}
