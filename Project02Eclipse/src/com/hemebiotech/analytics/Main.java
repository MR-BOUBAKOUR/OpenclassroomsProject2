package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args) {
        ISymptomReader symptomsDataReader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter symptomDataWriter = new WriteSymptomDataToFile("result.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomsDataReader, symptomDataWriter);

        analyticsCounter.exe();
    }

}
