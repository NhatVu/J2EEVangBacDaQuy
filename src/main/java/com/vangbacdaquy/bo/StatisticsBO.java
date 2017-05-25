package com.vangbacdaquy.bo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.vangbacdaquy.dao.StatisticsDAO;

public class StatisticsBO {
	
	public int countDocumentsByCurrentDay(String collectionName) throws Exception{
		StatisticsDAO mapper = null;
		int result = 0;
		
		try {
            mapper = new StatisticsDAO();
            result = mapper.countDocumentsByCurrentDay(collectionName);
        } catch (Exception e) {
            throw e;
        } finally {
//			  issue: http://stackoverflow.com/questions/30045127/issue-on-opening-mongodb-connections-after-calling-close-method
//            mapper.closeConnection();
        }
        return result;
	}
	
	public List<Document> countDocumentsGroupByYearMonthDay(String collectionName) throws Exception{
		StatisticsDAO mapper = null;
		List<Document> result = new ArrayList<Document>();
		
		try {
            mapper = new StatisticsDAO();
            result = mapper. countDocumentsGroupByYearMonthDay(collectionName);
        } catch (Exception e) {
            throw e;
        } finally {
//			  issue: http://stackoverflow.com/questions/30045127/issue-on-opening-mongodb-connections-after-calling-close-method
//            mapper.closeConnection();
        }
        return result;
	}

}
