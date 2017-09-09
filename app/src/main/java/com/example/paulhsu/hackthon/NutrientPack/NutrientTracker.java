package com.example.paulhsu.hackthon.NutrientPack;

public class NutrientTracker {

    private int days;
    private int[] blockNutrients = new int[6];
    private int[] consumedNutrients = new int[6];
    private float[] percentConsumed = new float[6];


    public NutrientTracker(int days, int[] blockNutrients){
        this.days = days;
        this.blockNutrients = blockNutrients;
        for(int i = 0; i < blockNutrients.length; i++){
            int nutrient = blockNutrients[i];
            blockNutrients[i] = nutrient * days;
        }
    }
    public int getDays() {
        return days;
    }

    public void updateNutrients(int[] newItem){ //arg may differ based on API
        for(int i = 0; i < consumedNutrients.length; i ++){
            consumedNutrients[i] += newItem[i];
            percentConsumed[i] = (consumedNutrients[i]/blockNutrients[i]) * 100;
        }
    }

    public float[] getPercentConsumed() {

        return percentConsumed;
    }
}
