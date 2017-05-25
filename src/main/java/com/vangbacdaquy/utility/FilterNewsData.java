package com.vangbacdaquy.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterNewsData {
	/**
	 * From News_DB, Selecting/Filtering News which their title/description/content contain at least one "Breaking News" Keyword  
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("START FILTERING ...");
		String inPath = System.getProperty("user.dir") + File.separator
				+ "data" + File.separator + "dump(500).csv";
		String keywordsPath = System.getProperty("user.dir") + File.separator
				+ "resource" + File.separator + "keyword" + File.separator
				+ "[StreamingKeywords].txt";
		String outPath = System.getProperty("user.dir") + File.separator
				+ "data" + File.separator + "dump(filtered).csv";

		FilterNewsData filterTest = new FilterNewsData();
		filterTest.filterDataContainingKeywords(inPath, keywordsPath, outPath);
		System.out.println("DONE");
	}

	/**
	 * Filter news data, keep news that has at least one keyword in their title/description/content
	 * @param inPath .csv file, containing news data exported from database (NewsDB)
	 * @param keywordsPath .txt file, containing list of keywords 
	 * @param outPath .csv file, containing the resulting filtered data
	 * @throws IOException
	 */
	public void filterDataContainingKeywords(String inPath,
			String keywordsPath, String outPath) throws IOException {

		List<String> keywords = new ArrayList<String>();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(keywordsPath))));
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(
				outPath)));

		String line = bReader.readLine();
		while (line != null) {
			keywords.add(line);
			line = bReader.readLine();
		}

		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(
				new File(inPath))));
		//first row of filtered file
		line = bReader.readLine();
		bWriter.write(line);
		bWriter.newLine();
		
		rowLoop: while ((line = bReader.readLine()) != null) {
			List<String> fields = new ArrayList<String>(Arrays.asList(line.split("\t")));
			for (String keyW : keywords) {
				// The cell order: 1
				if ((fields.size() >= 2) && (fields.get(1).contains(keyW))) {
					bWriter.write(line);
					bWriter.newLine();
					continue rowLoop;
				}
				// The cell order: 2 
				if ((fields.size() >= 3) && (fields.get(2).contains(keyW))) {
					bWriter.write(line);
					bWriter.newLine();
					continue rowLoop;
				}
				// The cell order: 6
				if ((fields.size() >= 7) && (fields.get(6).contains(keyW))) {
					bWriter.write(line);
					bWriter.newLine();
					continue rowLoop;
				}
			}
		}
		
		bReader.close();
		bWriter.close();
	}
}
