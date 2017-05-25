package com.vangbacdaquy.utility;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class ARFFConverter {
	
	/**
	 * Convert CSV file into Arff file
	 * @param inputPath: the csv file name
	 * @param outputPath: the arff file name
	 * @throws IOException
	 */
	public static void csv2arff(String inputPath, String outputPath) throws IOException {
		File oldFile = new File(inputPath);
		File newFile = new File(outputPath);
		if (!newFile.getParentFile().exists()){
			newFile.getParentFile().mkdirs();
		}
		
	    CSVLoader loader = new CSVLoader();
	    loader.setSource(oldFile);
	    Instances data = loader.getDataSet();
	 
	    // save ARFF
	    ArffSaver saver = new ArffSaver();
	    saver.setInstances(data);
	    saver.setFile(newFile);
	    saver.writeBatch();
	    System.out.println("Converting " + oldFile.getName() + " to .arff... Done!");
	}

}
