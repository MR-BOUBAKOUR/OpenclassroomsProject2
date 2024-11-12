package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counters = new HashMap<>();
		symptoms.forEach(result -> {
			counters.put(result, counters.getOrDefault(result, 0) + 1);
		});

		return counters;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	public void exe() {
		List<String> symptoms = getSymptoms();
		Map<String, Integer> countedSymptoms = countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
		writeSymptoms(sortedSymptoms);
	}
}
