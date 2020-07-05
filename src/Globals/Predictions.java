/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

/**
 *
 * @author 23554853
 */
public enum Predictions {
    Prediction1("Category 1-Level Aggregation", 2000),
    Prediction2("Category 2-Level Aggregation", 4000),
    Prediction3("Category 3-Level Aggregation", 6000);
    
    private final String classification;
    private final double value;

    private Predictions(String classification, double value) {
        this.classification = classification;
        this.value = value;
    }

    public static Predictions getPrediction1() {
        return Prediction1;
    }

    public static Predictions getPrediction2() {
        return Prediction2;
    }

    public static Predictions getPrediction3() {
        return Prediction3;
    }

    public String getClassification() {
        return classification;
    }

    public double getValue() {
        return value;
    }
    
    public String displayClassification(){
        return this.getClassification();
    }
    
    public String displayValue(){
        double temp = this.getValue();
        String temp2 = (temp + " ");
        return temp2;
    }
}
