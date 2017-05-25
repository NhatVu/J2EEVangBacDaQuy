package com.vangbacdaquy.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.IndexWriter;

public class GlobalVariable {
	private  List<IndexWriter> listLuceneIndexWriter;
	private static GlobalVariable mInstance = null;
	private  GlobalVariable(){
		listLuceneIndexWriter = new ArrayList<IndexWriter>();
	}
	
	synchronized public static GlobalVariable getInstance(){
		if(mInstance == null)
			mInstance = new GlobalVariable();
		return mInstance;
	}

	public List<IndexWriter> getListLuceneIndexWriter() {
		return listLuceneIndexWriter;
	}

	public void setListLuceneIndexWriter(List<IndexWriter> listLuceneIndexWriter) {
		this.listLuceneIndexWriter = listLuceneIndexWriter;
	}
	
	
}
