package com.vangbacdaquy.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Random;

import com.vangbacdaquy.constant.FilePathConstant;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffLoader.ArffReader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.Remove;

public class WekaML {

	private Classifier classifierModel;
	private String storedTrainingDataPath;
	
	public WekaML(String trainingDataPath){
		this.storedTrainingDataPath = trainingDataPath;
	}
	
	public void setStoredTrainingDataPath(String storedTrainingDataPath) {
		this.storedTrainingDataPath = storedTrainingDataPath;
	}

	public static void main(String[] args) throws Exception {
		WekaML wekaML = new WekaML(FilePathConstant.TFIDF_TRAINING_DATA_FILE);
		wekaML.trainClassifier("NaiveBayes", "D:\\HotNewsFull.model", "D:\\labelValues.txt");
		System.out.println(wekaML.crossValidateModel(10));
	}
	
	/**
	 * Read data from an arff file
	 * @param arffPath path to arff file
	 * @return Instances object containing data from arff file
	 * @throws IOException
	 */
	public Instances readDataFromARFF(String arffPath) throws IOException{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(arffPath)));
		ArffReader arReader = new ArffReader(bReader);
		Instances data = arReader.getData();		
		bReader.close();
		return data;
	}
	
	/**
	 * Train a classifier model using the given training data, and save the trained model to the specified file path
	 * @param algorithmName name of classifier algorithm (ex. NaiveBayes, J48,...)
	 * @param modelFilePath file path for the model
	 * @param nominalValueOutFilePath path to .txt files containing possible nominal values
	 * @return false if failed to train classifier, true otherwise
	 * @throws Exception 
	 */
	public boolean trainClassifier(String algorithmName, String modelFilePath, String nominalValueOutFilePath) throws Exception {
		CSVLoader csvLoader = new CSVLoader();
		csvLoader.setSource(new File(storedTrainingDataPath));
		Instances trainingData = csvLoader.getDataSet();
		//remove columns from twitter data to run Naive Bayes classifier
		trainingData = removeAttributes(trainingData, "2-12");
		trainingData.setClassIndex(0);	
		ObjectOutputStream oos;
		FileOutputStream fos;
		try {
			classifierModel = AbstractClassifier.forName(algorithmName, null);
			classifierModel.buildClassifier(trainingData);
			oos = new ObjectOutputStream(new FileOutputStream(modelFilePath));
			oos.writeObject(classifierModel);
			oos.flush();
			oos.close();
			
			//get list of nominal values for class attribute
			String nominalValues = Collections.list(trainingData.classAttribute().enumerateValues()).toString();
			nominalValues = nominalValues.replace("[", "").replace("]", "");
			
			fos = new FileOutputStream(nominalValueOutFilePath);
			fos.write(nominalValues.getBytes());
			fos.close();
			
		} catch (IOException e){
			System.out.println("Error opening output stream");
			return false;
		} catch (Exception e1) {
			System.out.println("Error training classifier.");
			e1.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Remove from data all attributes (columns) specified by attributeIndex
	 * @param data input original data
	 * @param attributeIndex String containing indexes of columns to be removed, starting at 1
	 * @return new data with removed columns
	 * @throws Exception when filtering process is unsuccessful
	 */
	public Instances removeAttributes(Instances data, String attributeIndex) throws Exception{
		Remove remove = new Remove();
		remove.setAttributeIndices(attributeIndex);
		remove.setInputFormat(data);
		Instances filteredData = Filter.useFilter(data, remove);		
				
		return filteredData;
	}
	
	/**
	 * Load classifier model from the specified file path
	 * @param modelFilePath path (including file name) to the model
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadClassifierModel(String modelFilePath) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(modelFilePath));
		classifierModel = (Classifier)ois.readObject();
		ois.close();
	}
	
	/**
	 * Evaluate the trained model using cross validation
	 * @param numFolds number of cross validation folds
	 * @return String containing model evaluation information
	 * @throws Exception
	 */
	public String crossValidateModel(int numFolds) throws Exception{
		CSVLoader csvLoader = new CSVLoader();
		csvLoader.setSource(new File(storedTrainingDataPath));
		Instances trainingData = csvLoader.getDataSet();
		
//		Instances trainingData = readDataFromARFF(storedTrainingDataPath);
		trainingData = removeAttributes(trainingData, "2-12");
		trainingData.setClassIndex(0);
		Evaluation eval = new Evaluation(trainingData);
		Random rand = new Random(1);
		eval.crossValidateModel(classifierModel, trainingData, 10, rand);
		return eval.toClassDetailsString() + eval.toMatrixString() + "\n";
	}
	
	/**
	 * Evaluate the trained model using the supplied testing data
	 * @param trainingData data used to train the model
	 * @param testingData data for testing the model
	 * @throws Exception
	 */
	public void evaluateModel(Instances trainingData, Instances testingData) throws Exception{
		Evaluation eval = new Evaluation(trainingData);
		eval.evaluateModel(classifierModel, testingData);
		System.out.println(eval.toClassDetailsString());
		System.out.println(eval.toMatrixString());
	}
	
	/**
	 * Classify new Twitter instances
	 * @param unlabeledFilePath .csv file containing data to be classified
	 * @param resultFilePath path to results file containing instances IDs and their corresponding class label, probability distribution
	 * @param nominalValues string containing possible values of class label
	 * @throws Exception
	 */
	public void classifyNewInstances(String unlabeledFilePath, String resultFilePath, String nominalValues) throws Exception{
		CSVLoader csvLoader = new CSVLoader();
		BufferedReader bReader = new BufferedReader(new FileReader(nominalValues));
						
		//add the possible nominal values to class attribute
		csvLoader.setSource(new File(unlabeledFilePath));
		Instances unlabeledData = csvLoader.getDataSet();
		
		unlabeledData = removeAttributes(unlabeledData, "1");
		Add addFilter = new Add();
		addFilter.setAttributeIndex("1");
		addFilter.setNominalLabels(bReader.readLine());
		addFilter.setInputFormat(unlabeledData);
		unlabeledData = Filter.useFilter(unlabeledData, addFilter);
		unlabeledData.setClassIndex(0);		
		
		Instances unlabeledDataFiltered = removeAttributes(unlabeledData, "2-12");
		unlabeledDataFiltered.setClassIndex(0);
		bReader.close();
		
		bReader = new BufferedReader(new FileReader(unlabeledFilePath));
		bReader.readLine();
		StringBuffer dataToWrite = new StringBuffer();
		for (int i = 0; i < unlabeledDataFiltered.numInstances(); i++){
			double label = classifierModel.classifyInstance(unlabeledDataFiltered.get(i));
			String labelValue = unlabeledData.classAttribute().value((int)label);
			double[] instanceClassProbability = classifierModel.distributionForInstance(unlabeledDataFiltered.get(i));
			
			String[] lineParts = bReader.readLine().split(",");
			dataToWrite.append(lineParts[2]).append(",");//TweetID
//			dataToWrite.append(lineParts[5]).append(",");//TweetPostDate
			dataToWrite.append(lineParts[7]).append(",");//Category
			dataToWrite.append(labelValue).append(",");//Label in text
			dataToWrite.append(instanceClassProbability[0]).append(",");//"Không" probability
			dataToWrite.append(instanceClassProbability[1]).append(",");//"Không liên quan" probability
			dataToWrite.append(instanceClassProbability[2]).append("\r\n");//"Có" probability
			
			unlabeledData.get(i).setClassValue(label);
			
//			System.out.println(unlabeledData.get(i).value(0) + " -> "+ unlabeledData.classAttribute().value((int)label));
		}
		System.out.println("Done classifying new instances.");
		File newFile = new File(resultFilePath);
		if (!newFile.getParentFile().exists()){
			newFile.getParentFile().mkdirs();
		}	
		FileOutputStream fos = new FileOutputStream(resultFilePath);
		bReader.close();
		fos.write(dataToWrite.toString().getBytes());
		fos.close();
		
	}
}
