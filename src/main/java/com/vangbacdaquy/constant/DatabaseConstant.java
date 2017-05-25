package com.vangbacdaquy.constant;

public class DatabaseConstant {
	public static final String MongoDBName = "EDSDB_Mongo";
	public static final String MongoDBStreamingCollection = "Streaming";
	public static final String MongoDBTrackingCollection = "Tracking";
	public static final String MongoDBStreamingLabeledCollection = "StreamingLabeled";
	
	public static final String MySQLDBName = "vangbacdaquy";
	
	public static final String[] Header = new String[] {"_id", "TweetID", "UserID", "UserScreenName", "Nội dung Tweet", "Ngày đăng Tweet",
			"Ngày thu thập", "Breaking? - HƯƠNG", "Chủ đề - HƯƠNG",  "Breaking? - AN", "Chủ đề - AN",  "Breaking? - GIANG", "Chủ đề - GIANG", "Nằm trong file"};
	
	public static final String[] ExcelHeader = new String[] {"_id", "TweetID", "UserID", "UserScreenName", "Nội dung Tweet", "Ngày đăng Tweet",
	    "Ngày thu thập", "Breaking?", "Chủ đề", "Nằm trong file"};

	public static final String[] TwitterExcelHeader = new String[] {"_id", "TweetID", "UserID", "UserScreenName", "Nội dung Tweet", "Ngày đăng Tweet",
        "Ngày thu thập", "Breaking?", "Chủ đề", "Yếu tố thời gian", "Yếu tố breaking", "Ghi chú", "Link tới Tweet"};
	public static final String[] NewsExcelHeader = new String[] {"_id", "TweetID", "UserID", "UserScreenName", "Nội dung Tweet", "Ngày đăng Tweet",
		"Ngày thu thập", "Breaking?", "Chủ đề", "Yếu tố thời gian", "Yếu tố breaking", "Ghi chú", "Link tới Tweet"};
	
	public static final String User = "User";
	public static final String UserType = "UserType";
	public static final String Topic = "Topic";
}
