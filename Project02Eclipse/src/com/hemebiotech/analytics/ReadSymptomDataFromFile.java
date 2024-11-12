package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filepath));) {
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (Exception e) {
			System.err.println("Erreur lors de la lecture du fichier : " + filepath + e.getMessage());
		}
		return result;
	}

}
