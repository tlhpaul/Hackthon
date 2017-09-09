package com.example.paulhsu.hackthon.NutrientPack;

import java.util.ArrayList;

public class NutrientTracker {

    private int days;
    private ArrayList<Integer> freeNutrients;

    public NutrientTracker(int days, ArrayList<Integer> freeNutrients){
        this.days = days;
        this.freeNutrients = freeNutrients;
        for(int nutrient: freeNutrients){
            nutrient *= days;
        }
    }
    public int getDays() {
        return days;
    }

    public ArrayList<Integer> getFreeNutrients() {
        return freeNutrients;
    }
}
