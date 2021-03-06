package com.example.paulhsu.hackthon.NutrientPack;

public class NutrientTracker {

    private int days;
    private static int[] blockNutrients = new int[6];
    private static int[] consumedNutrients = new int[6];
    private static float[] percentConsumed = new float[6];


    public NutrientTracker(int days, int[] blockNutrients){ //called in Main
        this.days = days;
        this.blockNutrients = blockNutrients;
        for(int i = 0; i < blockNutrients.length; i++){
            int nutrient = blockNutrients[i];
            blockNutrients[i] = nutrient * days;
        }
    }
    public int getDays() {
        return days;
    } //may be useful for visual in the future

    public void updateNutrients(int[] newItem){ //arg may differ based on API //called in GrabBarcode
        for(int i = 0; i < consumedNutrients.length; i ++){
            consumedNutrients[i] += newItem[i];
            percentConsumed[i] = (consumedNutrients[i]/blockNutrients[i]) * 100;
        }
    }

    public float[] getPercentConsumed() { // called in Display

        return percentConsumed;
    }
}
