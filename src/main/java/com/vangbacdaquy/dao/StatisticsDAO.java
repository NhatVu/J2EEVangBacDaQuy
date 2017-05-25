/**
 * 
 */
package com.vangbacdaquy.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.vangbacdaquy.constant.DatabaseConstant;

/**
 * @author cuongdev
 *
 */
public class StatisticsDAO extends MongoDAO{
	public static int count = 0;
	
	public StatisticsDAO() {
		super();
	}
	
	public List<Document> countDocumentsGroupByYearMonthDay(String collectionName){
		List<Document> result = new ArrayList<Document>();
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);

		
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date today30 = cal.getTime();
		today30.setHours(0);
		today30.setMinutes(0);
		today30.setSeconds(0);
		cal.add(Calendar.DAY_OF_MONTH, -60);
		Date today60 = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -90);
		Date today90 = cal.getTime();
		
		
		//match
		Document matchFields = new Document("CollectDate", new Document("$gt", today30).append("$lt", date));
		Document matchAggregation = new Document("$match", matchFields);
		//sort
//		Document sortFields = new Document("CollectDate", -1);
//		Document sortAggregation = new Document("$sort", sortFields);
		//project		
		Document projectFields = new Document("month", new Document("$month", "$CollectDate"))
									.append("year", new Document("$year", "$CollectDate"))
									.append("day", new Document("$dayOfMonth", "$CollectDate"))
									.append("yearMonthDay", new Document("$dateToString", new Document(new Document("format", "%Y-%m-%d")).append("date", "$CollectDate")));
		Document projectAggregation = new Document("$project", projectFields);
		
	
		
		//group
		Document groupFields = new Document("_id", "$yearMonthDay").append("tweetsNumber", new Document("$sum", 1));
		Document groupAggregation = new Document("$group", groupFields);
		Document sortFields = new Document("_id", 1);
	    Document sortAggregation = new Document("$sort", sortFields);
		
		
		MongoCollection<Document> collection = getConnection()
				.getDatabase(DatabaseConstant.MongoDBName)
				.getCollection(collectionName);
		AggregateIterable<Document> res = collection.aggregate(Arrays.asList(matchAggregation, projectAggregation, groupAggregation,sortAggregation));
		
		for (Document doc : res) {
			result.add(doc);
		}
		return result;
	}
	
	public int countDocuments(String collectionName) {
		int count = 0;
		MongoCursor<Document> cursor = getConnection()
				.getDatabase(DatabaseConstant.MongoDBName)
				.getCollection(collectionName).find().iterator();

		while (cursor.hasNext()) {
			count++;
		}
		cursor.close();

		return count;
	}
	
	public int countDocumentsByCurrentDay(String collectionName) throws ParseException {
		int count = 0;

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
		Date date = new Date();
		date.setHours(7); 	
		date.setMinutes(0);
		date.setSeconds(0);
		Document find = new Document("CollectDate", new Document("$gt", date));
		MongoCollection<Document> collection = getConnection()
				.getDatabase(DatabaseConstant.MongoDBName)
				.getCollection(collectionName);
		
		MongoCursor<Document> cursor = collection.find(find).iterator();

		while (cursor.hasNext()) {
			cursor.next();
			count++;
		}

		cursor.close();

		return count++;
	}
}
