package com.vangbacdaquy.utility;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vangbacdaquy.constant.FilePathConstant;

public class LuceneEngine {

//	/**
//	 * Index, calculate TF-IDF for data in Excel files (input docs) and write out an CSV file (training data) 
//	 * @param inputDataDir directory containing input (preprocessed) data
//	 * @param outputIndexDir directory containing Lucene index of the input data
//	 * @param outputCSVName csv file containing tf-idf representation of the input data
//	 * @throws IOException
////	 */
////	public void vectorizeData(String inputDataDir, String outputIndexDir, String outputCSVName) throws IOException {
////		createIndex(outputIndexDir, inputDataDir);
////		encodeDataAsTFIDFVector(outputIndexDir, outputCSVName);
////		exportTermCorpus(outputIndexDir, FilePath.CORPUS_FILE);
////		System.out.println("Done!");
////	}
//	
//	/**
//	 * 
//	 * @param inputDataDir directory containing new input data
//	 * @param originalDataIndexDir directory containing Lucene index of original training data
//	 * @param newDataIndexDir directory containing Lucene index of new data
//	 * @param outputCSVName csv file containing tf-idf representation of new input data
//	 * @throws IOException
////	 */
////	public void vectorizeData(String inputDataDir, String originalDataIndexDir, String newDataIndexDir, String outputCSVName) throws IOException{
////		createIndex(newDataIndexDir, inputDataDir);
////		encodeNewDataAsTFIDFVector(originalDataIndexDir, newDataIndexDir, outputCSVName);		
////	}
//
//	/**
////	 * Indexing all excel files in the inputDir and write indexed data to files in the outputDir.
////	 * @param indexDir directory containing Lucene index
////	 * @param dataDir directory containing files to be indexed
////	 * @throws IOException
////	 */
////	public void createIndex(String indexDir, String dataDir) throws IOException {
////		Directory indexDirectory = FSDirectory.open(new File(indexDir));
////		@SuppressWarnings("deprecation")
////		IndexWriter writer = new IndexWriter(indexDirectory, new StandardAnalyzer(Version.LUCENE_36, Collections.emptySet()), true, IndexWriter.MaxFieldLength.UNLIMITED);
////		long startTime = System.currentTimeMillis();
////		File[] files = new File(dataDir).listFiles();
////		FileFilter filter = new TextFileFilter();
////		for (File file : files) {
////			if (!file.isDirectory() && !file.isHidden() && file.exists()
////					&& file.canRead() && filter.accept(file)) {
////				indexFile(writer, file);
////			}// end if (file filter)
////		}// end for (loop through files)
////		
////		int numIndexed = writer.numDocs();
////		writer.close();
////
////		long endTime = System.currentTimeMillis();
////		System.out.println(numIndexed + " Document indexed, time taken: "
////				+ (endTime - startTime) + " ms");
////	}
//
//	/**
//	 * Index an excel file and write indexed data to Lucene index. Skips header row in excel file.
//	 * @param writer Lucene index writer with 
//	 * @param file excel file containing data to be indexed, each row in the file is transformed into a Lucene document
//	 * @throws IOException
//	 */
//	/*private void indexFile(IndexWriter writer, File file) throws IOException {
//		System.out.println("Indexing " + file.getCanonicalPath());
//		
//		XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(file));
//		wBook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		XSSFSheet sheet = wBook.getSheetAt(0);
//		Row row;
//		Iterator<Row> rowIterator = sheet.iterator();
//
//		row = rowIterator.next();
//		while (rowIterator.hasNext()) {
//			row = rowIterator.next();
//
//			// index all columns and write
//			writer.addDocument(createTwitterDocument(row));
//		}
//		wBook.close();
//	}
//*/
//	/**
//	 * Read data from an Excel row for indexing
//	 * @param row Excel row object containing the row data
//	 * @return a Lucene document to be added to the index
//	 */
//	/*
//	private Document createTwitterDocument(Row row){
//		Field mongoID = new Field(LuceneFieldConstants.MONGODB_ID, row.getCell(0).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field tweetID = new Field(LuceneFieldConstants.TWEET_ID, row.getCell(1).getStringCellValue(),
//				Field.Store.YES, Field.Index.NO);
//		Field userID = new Field(LuceneFieldConstants.USER_ID, row.getCell(2).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field userScreenName = new Field(LuceneFieldConstants.USER_SCREEN_NAME, row.getCell(3).getStringCellValue(),
//				Field.Store.YES, Field.Index.NO);
//		Field tweetContent = new Field(LuceneFieldConstants.TWEET_CONTENT, row.getCell(4).getStringCellValue(),
//				Field.Store.NO,	Field.Index.ANALYZED, Field.TermVector.YES);
//		Field tweetPostDate = new Field(LuceneFieldConstants.TWEET_POST_DATE, row.getCell(5).getStringCellValue(),
//				Field.Store.YES, Field.Index.NO);
//		Field tweetCollectDate = new Field(LuceneFieldConstants.TWEET_COLLECT_DATE, row.getCell(6).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field breakingLabel = new Field(LuceneFieldConstants.BREAKING_LABEL, row.getCell(7).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//
//		Field category = new Field(LuceneFieldConstants.CATEGORY, row.getCell(8).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field timeElement = new Field(LuceneFieldConstants.TIME_ELEMENT, row.getCell(9).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field breakingElement = new Field(LuceneFieldConstants.BREAKING_ELEMENT, row.getCell(10).getStringCellValue(),
//				Field.Store.YES, Field.Index.NO);
//		Field propagationSpeed = new Field(LuceneFieldConstants.PROPAGATION_SPEED, row.getCell(11).getStringCellValue(), 
//				Field.Store.YES, Field.Index.NO);
//		Field notes = new Field(LuceneFieldConstants.NOTES, row.getCell(12).getStringCellValue(),
//				Field.Store.YES, Field.Index.NO);
//
//		Document document = new Document();
//
//		document.add(breakingLabel);
//		document.add(mongoID);
//		document.add(tweetID);
//		document.add(userID);
//		document.add(userScreenName);
//		document.add(tweetContent);
//		document.add(tweetPostDate);
//		document.add(tweetCollectDate);
//		
//		document.add(category);
//		document.add(timeElement);
//		document.add(breakingElement);
//		document.add(propagationSpeed);
//		document.add(notes);
//		return document;		
//	}
//	*/
//	/**
//	 * Calculate idf vector for all terms in index
//	 * IDF equations from: https://janav.wordpress.com/2013/10/27/tf-idf-and-cosine-similarity/
//	 * @param indexDir Lucene index directory of original, training data
//	 * @return TreeMap containing idf vector for all terms (sorted by alphabetical order as per TreeMap's properties)
//	 * @throws IOException
//	 */
//	private TreeMap<String, Double> calculateIDFVector(String indexDir) throws IOException{
//		Directory indexDirectory = FSDirectory.open(new File(indexDir));
//		IndexReader reader = IndexReader.open(indexDirectory);
//		IndexSearcher searcher = new IndexSearcher(reader);
//		int docCount = reader.numDocs();
//		TermEnum listOfTerms = reader.terms();
//		
//		TreeMap<String, Double> idfVector = new TreeMap<String, Double>();
//		// populate idfVector with all terms and calculate their idfs in corpus
//		while (listOfTerms.next()) {
//			String currentTerm = listOfTerms.term().text();
//			int docContainingCurrentTerm = searcher.docFreq(new Term(
//					LuceneFieldConstants.TWEET_CONTENT, currentTerm));
//			double idf = 1 + Math.log((double) docCount / docContainingCurrentTerm);
//			idfVector.put(currentTerm, idf);
//		}
//		searcher.close();
//		return idfVector;
//	}
//	
//	/**
//	 * Calculate tf-idf vector for single document
//	 * @param docIndex index/position of document in the "Lucene index"
//	 * @param idfVector idf vector for original training data
//	 * @param reader Lucene index reader
//	 * @return LinkedHashMap containing tf-idf vector for the document
//	 * @throws IOException
//	 */
//	private LinkedHashMap<String, Double> calculateTFIDFVectorForSingleDocument(int docIndex, TreeMap<String, Double> idfVector, IndexReader reader) throws IOException{
//		TermFreqVector tfv = reader.getTermFreqVector(docIndex,
//				LuceneFieldConstants.TWEET_CONTENT);
//		String[] termList = tfv.getTerms(); //list of terms in this document
//		int[] termFreqList = tfv.getTermFrequencies();
//
//		int totalTermCount = 0;
//		LinkedHashMap<String, Double> tfidfVector = new LinkedHashMap<String, Double>();
//
//		// initialize tf-idf vector with all zeroes
//		for (String key : idfVector.keySet()) {
//			tfidfVector.put(key, 0.0);
//		}
//
//		// calculate (total) term count in document i
//		for (int temp : termFreqList) {
//			totalTermCount += temp;
//		}
//
//		// loop through all term in doc i and calculate tfidf vector
//		int uniqueTermCount = termList.length;
//		for (int j = 0; j < uniqueTermCount; j++) {				
//			if (idfVector.containsKey(termList[j])){
//				double tfidf = ((double)termFreqList[j] / totalTermCount)
//						* idfVector.get(termList[j]);
//				tfidfVector.put(termList[j], tfidf);
//			}
//		}
//		return tfidfVector;
//	}
//	/**
//	 * Calculating TFIDF for original data
//	 * @param indexDir directory containing the Lucene index of original data
//	 * @param outputCSVFilePath path to output file
//	 * @throws IOException
//	 */
//	public void encodeDataAsTFIDFVector(String indexDir, String outputCSVFilePath) throws IOException {
//		Directory indexDirectory = FSDirectory.open(new File(indexDir));
//		IndexReader reader = IndexReader.open(indexDirectory);
//
//		File newFile = new File(outputCSVFilePath);
//		if (!newFile.getParentFile().exists()){
//			newFile.getParentFile().mkdirs();
//		}		
//		FileOutputStream fos = new FileOutputStream(newFile);
//		StringBuffer data = new StringBuffer();
//
//		// HashMap<String, Double> idfVector = new HashMap<String, Double>();
//		TreeMap<String, Double> idfVector = calculateIDFVector(indexDir);//new TreeMap<String, Double>();
//
//		// first line of csv file
//		Iterator<FieldInfo> itFieldInfo = ReaderUtil
//				.getMergedFieldInfos(reader).iterator();
//		while (itFieldInfo.hasNext()) {
//			FieldInfo temp = itFieldInfo.next();
//			if (temp.name != LuceneFieldConstants.TWEET_CONTENT) {
//				data.append(temp.name + ", ");
//			}
//		}
//		for (String key : idfVector.keySet()) {
//			data.append(key + ", ");
//		}
//		data.delete(data.length()-2, data.length());
//		data.append("\r\n");
//
//		// loop through all docs
//		int docCount = reader.numDocs();
//		for (int i = 0; i < docCount; i++) {
//			// write content of fields other than the TWEET_CONTENT field
//			List<Fieldable> fields = reader.document(i).getFields();
//			for (Fieldable field : fields) {
//				if (field.name() != LuceneFieldConstants.TWEET_CONTENT) {
//					data.append(reader.document(i).get(field.name()) + ", ");
//				}
//			}
//			
//			LinkedHashMap<String, Double> tfidfVector = calculateTFIDFVectorForSingleDocument(i, idfVector, reader);
//
//			//write tf-idf vector content for this doc
//			Iterator<Double> it = tfidfVector.values().iterator();
//			while (it.hasNext()) {
//				Double value = it.next();
//				data.append(value + ", ");
//			}
//			data.delete(data.length()-2, data.length());
//			data.append("\r\n");
//			fos.write(data.toString().getBytes());
//			data.setLength(0);
//		}
//		fos.close();
//		reader.close();
//	}
//	
//	/**
//	 * Calculate tf-idf vectors for new documents with respect to original data's corpus and idfs, any terms not existing in the original corpus will be discarded
//	 * @param originalIndexDir
//	 * @param newIndexDir
//	 * @param outputCSVFilePath
//	 * @throws IOException
//	 */
//	public void encodeNewDataAsTFIDFVector(String originalIndexDir, String newIndexDir, String outputCSVFilePath) throws IOException {
//		Directory indexDirectory = FSDirectory.open(new File(originalIndexDir));
//		IndexReader reader = IndexReader.open(indexDirectory);
//		
//		Directory indexDirectoryNew = FSDirectory.open(new File(newIndexDir));
//		IndexReader readerNew = IndexReader.open(indexDirectoryNew);
//
//		File newFile = new File(outputCSVFilePath);
//		if (!newFile.getParentFile().exists()){
//			newFile.getParentFile().mkdirs();
//		}		
//		FileOutputStream fos = new FileOutputStream(newFile);
//		StringBuffer data = new StringBuffer();
//
//		// HashMap<String, Double> idfVector = new HashMap<String, Double>();
//		TreeMap<String, Double> idfVector = calculateIDFVector(originalIndexDir);//new TreeMap<String, Double>();
//
//		// first line of csv file
//		Iterator<FieldInfo> itFieldInfo = ReaderUtil
//				.getMergedFieldInfos(reader).iterator();
//		while (itFieldInfo.hasNext()) {
//			FieldInfo temp = itFieldInfo.next();
//			if (temp.name != LuceneFieldConstants.TWEET_CONTENT) {
//				data.append(temp.name + ", ");
//			}
//		}
//		for (String key : idfVector.keySet()) {
//			data.append(key + ", ");
//		}
//		data.delete(data.length()-2, data.length());
//		data.append("\r\n");
//
//		// loop through all docs
//		int docCount = readerNew.numDocs();
//		for (int i = 0; i < docCount; i++) {
//			// write content of fields other than the TWEET_CONTENT field
//			List<Fieldable> fields = readerNew.document(i).getFields();
//			for (Fieldable field : fields) {
//				if (field.name() != LuceneFieldConstants.TWEET_CONTENT) {
//					data.append(readerNew.document(i).get(field.name()) + ", ");
//				}
//			}
//
//			LinkedHashMap<String, Double> tfidfVector = calculateTFIDFVectorForSingleDocument(i, idfVector, readerNew);
//			
//			//write tf-idf vector content for this doc
//			Iterator<Double> it = tfidfVector.values().iterator();
//			while (it.hasNext()) {
//				Double value = it.next();
//				data.append(value + ", ");
//			}
//			data.delete(data.length()-2, data.length());
//			data.append("\r\n");
//			fos.write(data.toString().getBytes());
//			data.setLength(0);
//		}
//		fos.close();
//		reader.close();
//	}
//	
//	/**
//	 * Output the whole term corpus in the Lucene index
//	 * @param indexDir directory containing the Lucene index
//	 * @param outputCorpusFile	.txt file path (including file name) for the output file
//	 * @throws CorruptIndexException
//	 * @throws IOException
//	 */
//	public void exportTermCorpus(String indexDir, String outputCorpusFile) throws CorruptIndexException, IOException{
//		Directory indexDirectory = FSDirectory.open(new File(indexDir));
//		IndexReader reader = IndexReader.open(indexDirectory);
//		TermEnum listOfTerms = reader.terms();
//		List<String> sortedListOfTerms = new ArrayList<String>();
//		while(listOfTerms.next()){
//			String currentTerm = listOfTerms.term().text();
//			sortedListOfTerms.add(currentTerm);
//		}
//		Collections.sort(sortedListOfTerms);
//		
//		File newFile = new File(outputCorpusFile);
//		if (!newFile.getParentFile().exists()){
//			newFile.getParentFile().mkdirs();
//		}		
//		FileOutputStream fos = new FileOutputStream(newFile);
//		
//		for (String term : sortedListOfTerms){
//			fos.write(term.getBytes());
//			fos.write("\n".getBytes());
//		}
//		fos.close();
//	}
	
}