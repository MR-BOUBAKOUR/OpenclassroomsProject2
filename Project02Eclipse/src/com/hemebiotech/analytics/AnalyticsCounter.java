package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// first get input
		// BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		// String line = reader.readLine();

		ReadSymptomDataFromFile symptoms = new ReadSymptomDataFromFile("symptoms.txt");

		FileWriter writer = new FileWriter("result.txt");

		List<String> results = symptoms.GetSymptoms();
		Map<String, Integer> counters = new HashMap<>();

		results.forEach(result -> {
			counters.put(result, counters.getOrDefault(result, 0) + 1);
		});

		Map<String, Integer> sortedCounters = new TreeMap<>(counters);

		sortedCounters.forEach((key, value) -> {
			try {
				writer.write(key + ": " + value + "\n");
				System.out.println(key + ": " + value);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.close();

		// int headCount = 0; // counts headaches
		// while (line != null) {

		// System.out.println("symptom from file: " + line);
		// if (line.equals("headache")) {
		// headCount++;
		// System.out.println("number of headaches: " + headCount);
		// } else if (line.equals("rush")) {
		// rashCount++;
		// } else if (line.contains("pupils")) {
		// pupilCount++;
		// }

		// line = reader.readLine(); // get another symptom
		// }
		// reader.close();

		// next generate output
		// FileWriter writer = new FileWriter("result.txt");
		// writer.write("headache: " + headacheCount + "\n");
		// writer.write("rash: " + rashCount + "\n");
		// writer.write("dialated pupils: " + pupilCount + "\n");
		// writer.close();
	}
}
