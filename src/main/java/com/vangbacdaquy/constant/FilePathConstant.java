package com.vangbacdaquy.constant;

import java.io.File;

public class FilePathConstant {
	public static final String FS = File.separator;
	// this is for product development eviroment;
	public static final String BASE = System.getProperty("catalina.base") + FS + Configuration.DEPLOY_FOLDER + FS + "eds" + FS;
	// this is for dev eviroment
//	public static final String BASE = System.getProperty("catalina.base") + FS + "wtpwebapps" + FS + "eds" + FS;
//	public static final String BASE = System.getProperty("user.dir") + FS;
	// resource
	public static final String RESOURCE_FOLDER = BASE + "resource" + FS;
	public static final String CORPUS_FILE = BASE + "data" + FS + "corpus.txt";
	public static final String MODEL_FOLDER = BASE + "model" + FS;
	public static final String STOPWORD_FILE = RESOURCE_FOLDER + "stopwords.txt";
	public static final String KEYWORD_FOLDER = RESOURCE_FOLDER + "keyword" + FS;	
	public static final String NEWS_PATTERN_FOLDER = RESOURCE_FOLDER + "news" + FS;	

	public static final String DATA_FOLDER = BASE + "data" + FS;
	public static final String DICTIONARY_FOLDER = DATA_FOLDER + "2-Testing" + FS + "3.1-TrainingIndex" + FS;
	public static final String DICTIONARY_ZIP_FILE = DICTIONARY_FOLDER + "LuceneIndex.zip";
	// 1. input data, folder path
	public static final String INPUT_TRAINING_DATA_FOLDER = DATA_FOLDER + "1-Training" + FS + "1-Input" + FS;
	public static final String INPUT_TESTING_DATA_FOLDER = DATA_FOLDER + "2-Testing" + FS + "1-Input" + FS;
	public static final String INPUT_SAMPLE_TRAINING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Training" + FS + "1-Input" + FS;
	public static final String INPUT_SAMPLE_TESTING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Testing" + FS + "1-Input" + FS;
	public static final String INPUT_STREAMING_DATA_FOLDER = DATA_FOLDER + "4-Streaming" + FS + "1-Input" + FS;
	public static final String INPUT_STREAMING_DATA_FILE = INPUT_STREAMING_DATA_FOLDER + "Streaming.xlsx";
	
	// 2. preprocessed data, folder path
	public static final String PREPROCESSED_TRAINING_DATA_FOLDER = DATA_FOLDER + "1-Training" + FS + "2-Preprocessed" + FS;
	public static final String PREPROCESSED_TESTING_DATA_FOLDER = DATA_FOLDER + "2-Testing" + FS + "2-Preprocessed" + FS;
	public static final String PREPROCESSED_SAMPLE_TRAINING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Training" + FS + "2-Preprocessed" + FS;
	public static final String PREPROCESSED_SAMPLE_TESTING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Testing" + FS + "2-Preprocessed" + FS;
	public static final String PREPROCESSED_STREAMING_DATA_FOLDER = DATA_FOLDER + "4-Streaming" + FS + "2-Preprocessed" + FS;
	
	// 3. index, folder path
	public static final String INDEX_TRAINING_DATA_FOLDER = DATA_FOLDER + "1-Training" + FS + "3-Index" + FS;
	public static final String INDEX_TESTING_DATA_FOLDER = DATA_FOLDER + "2-Testing" + FS + "3-Index" + FS;
	public static final String INDEX_SAMPLE_TRAINING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Training" + FS + "3-Index" + FS;
	public static final String INDEX_SAMPLE_TESTING_DATA_FOLDER = DATA_FOLDER + "3-Sample" + FS + "Testing" + FS + "3-Index" + FS;
	public static final String INDEX_STREAMING_DATA_FOLDER = DATA_FOLDER + "4-Streaming" + FS + "3-Index" + FS;

	// 4. TF-IDF vector folder, .csv file path
	public static final String TFIDF_TRAINING_DATA_FILE = DATA_FOLDER + "1-Training" + FS + "4-TFIDFVector" + FS + "dataTrain.csv";
	public static final String TFIDF_TRAINING_DATA_FILE_APP = DATA_FOLDER + "1-Training" + FS + "4-TFIDFVector" + FS;
	public static final String TFIDF_TESTING_DATA_FILE = DATA_FOLDER + "2-Testing" + FS + "4-TFIDFVector" + FS + "dataTest.csv";
	public static final String TFIDF_SAMPLE_TRAINING_DATA_FILE = DATA_FOLDER + "3-Sample" + FS + "Training" + FS + "4-TFIDFVector" + FS + "sampleTrain.csv";
	public static final String TFIDF_SAMPLE_TESTING_DATA_FILE = DATA_FOLDER + "3-Sample" + FS + "Testing" + FS + "4-TFIDFVector" + FS + "sampleTest.csv";
	public static final String TFIDF_STREAMING_DATA_FILE = DATA_FOLDER + "4-Streaming" + FS + "4-TFIDFVector" + FS + "Streaming.csv";
	
	// 5. Final data folder
	public static final String FINAL_TRAINING_DATA_FILE = DATA_FOLDER + "1-Training" + FS + "5-Final" + FS + "dataTrain.arff";
	public static final String FINAL_TESTING_DATA_FILE = DATA_FOLDER + "2-Testing" + FS + "5-Final" + FS + "dataTest.arff";
	public static final String FINAL_SAMPLE_TRAINING_DATA_FILE = DATA_FOLDER + "3-Sample" + FS + "Training" + FS + "5-Final" + FS + "sampleTrain.arff";
	public static final String FINAL_SAMPLE_TESTING_DATA_FILE = DATA_FOLDER + "3-Sample" + FS + "Testing" + FS + "5-Final" + FS + "sampleTest.arff";
	public static final String FINAL_STREAMING_DATA_FILE = DATA_FOLDER + "4-Streaming" + FS + "5-Final" + FS + "Streaming.arff";
	
	// 6. Classification result folder
	public static final String CLASSIFICATION_STREAMING_RESULT_FILE = DATA_FOLDER + "4-Streaming" + FS + "6-ClassificationResult" + FS + "classificationResult.csv";
	
	public static final String CLASSIFICATION_RESULT_FILE = DATA_FOLDER + "2-Testing" + FS + "6-ClassificationResult" + FS + "classificationResult.csv";
	
	// Top N keyword index foler
	public static final String TOP_N_KEYWORDS_INDEX_DIR_BASE = FilePathConstant.BASE + "data" + FS + "TopNKeywords";
	
	// VCNer config file
	public static final String VCNER_CONFIG_FILE = FilePathConstant.RESOURCE_FOLDER + "configure"+ FS +"config_decode_pos_vi.xml"; 
}