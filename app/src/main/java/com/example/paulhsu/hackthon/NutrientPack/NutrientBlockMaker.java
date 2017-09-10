package com.example.paulhsu.hackthon.NutrientPack;



public class NutrientBlockMaker {
    private int[] nutrientBlocks = new int[6];

    public NutrientBlockMaker(String strategy){
        switch (strategy){
            case "low protein":
                nutrientBlocks = new int[]{2000, 130, 100, 30, 40, 100};
                break;
            case "high protein":
                nutrientBlocks = new int[]{2000, 160, 100, 30, 40, 150};
                break;
            case "low fat":
                nutrientBlocks = new int[]{2000, 160, 100, 30, 10, 150};
                break;
            case "high fat":
                nutrientBlocks = new int[]{2000, 160, 100, 30, 55, 150};
                break;
            case "high sugar":
                nutrientBlocks = new int[]{2000, 130, 100, 30, 55, 150};
                break;
            case "low sugar":
                nutrientBlocks = new int[]{2000, 90, 100, 30, 55, 150};
                break;
            default:
                nutrientBlocks = new int[]{2000, 150, 100, 30, 40, 120};
                break;
        }
    }

    public int[] getNutrientBlocks() {
        return nutrientBlocks;
    }
}
