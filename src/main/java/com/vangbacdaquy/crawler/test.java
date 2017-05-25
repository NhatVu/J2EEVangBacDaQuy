package com.vangbacdaquy.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test {
	public static void main(String[] args) throws Exception {
		Crawler c = new Crawler();
		String url = "https://t.co/o60SQ7xDkn";
		String realUrl = "http://vnexpress.net/tong-thuat/the-gioi/cong-to-chua-co-du-tai-lieu-doan-thi-huong-se-bi-xu-tiep-vao-30-5-3569506.html";
		Page page = c.crawlUrl(url);
System.out.println(page);
//		Document doc = Jsoup.connect("https://fb.me/8MGeAkKHe").get();
//		System.out.println(doc);
	}
}
