package com.vangbacdaquy.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;

import com.vangbacdaquy.constant.FilePathConstant;

/**
 * @author cuongdev
 *
 */
public class Crawler {
	private Map<String, NewsPattern> mapNewsPattern = new HashMap<String, NewsPattern>();
	
	public Crawler() {
		long start = System.currentTimeMillis();
		try {
			this.mapNewsPattern = inIt();
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchFieldException
				| IOException e) {
			e.printStackTrace();
		}
		System.out.println("Time init: " + (System.currentTimeMillis() - start));
	}
	
	/**
	 * @param folderPath
	 */
	public Crawler(String folderPath){
		try {
			this.mapNewsPattern = inIt(folderPath);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchFieldException
				| IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param url
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
		long start = System.currentTimeMillis();
		public Page crawlUrl(String url) throws URISyntaxException, IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException{
		url = url.trim();
		String site = getDomainName(url);
		try {
		    if(site.equals("bit.ly") || site.equals("t.co") || site.equals("fb.me")){
	            url = expandUrl(url);
	            site = getDomainName(url);
	        }
        } catch (Exception e) {
            url = "";
            site = "";
        }
		
		NewsPattern newsPattern = mapNewsPattern.get(site);
		Page page = new Page();
		if(newsPattern != null){
			page.setUrl(url);
			Field[] fields = newsPattern.getClass().getDeclaredFields();
			String document = GetPageContent(url);

			for(Field field : fields){
				String getMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
				String setMethod = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
				Method gMethod = newsPattern.getClass().getDeclaredMethod(getMethod);
				String regex = (String) gMethod.invoke(newsPattern);
				if(!"setRulePaging".equals(setMethod) && regex != null && !"".equals(regex)){
					regex = regex.replace("[", "\\[");
					regex = regex.replace("]", "\\]");
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(document);
					if(matcher.find()){
						Class<?> clz = page.getClass().getDeclaredField(field.getName()).getType();
						Method sMethod = page.getClass().getDeclaredMethod(setMethod, clz);
						
						// remove all HTML tag, if do not need, can skip this step
						String plainText = getPlainText(matcher.group());
						sMethod.invoke(page, plainText);
					}
				}
				
			}
		}
//		System.out.println("Time crawl: " + (System.currentTimeMillis() - start));
		return page;
	}
	
	/**
	 * @param url
	 * @return
	 * @throws URISyntaxException
	 */
	public String getDomainName(String url) throws URISyntaxException {
		String originDoamin = "";
		try {
			if(!url.startsWith("http://")&&!url.startsWith("https://")){
				url = "http://" + url;
			}
		    URI uri = new URI(url);
		    String domain = uri.getHost();
		    if( domain.startsWith("www.")){
		    	 originDoamin =  domain.substring(4);
		    }else{
		    	originDoamin = domain;
		    }
		   
		} catch (Exception e) {
			originDoamin = "";
			System.err.println("Domain " + url);
		}
		return originDoamin;
	}
	
	/**
	 * @param url
	 * @return
	 */
	private String GetPageContent(String url){
		long start = System.currentTimeMillis();
		URL link;
		StringBuffer document = new StringBuffer();
		try {
			link = new URL(url);
			URLConnection conn = link.openConnection();
//			set cookie for news.zing.vn
			conn.addRequestProperty("Cookie", "tuser=0; __utma=1.2032074393.1485268642.1488546819.1488546819.1; __utmc=1; __utmz=1.1488546819.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __gads=ID=743a0ad7ec6db717:T=1488546938:S=ALNI_MbQIuRx1vC2p-tP8jph9Y11rd-3rA; ab_campaign=28092016; znews_mobile=2; adtimaUserId=2000.a9cc9d3751bdb8e3e1ac.1485268643285.94f1b741; BANNER_OFF=; .ASPXANONYMOUS=xaZN_QeSVp8GIfpP4eI93wojH34IqpXj64gHVIBwOg8D6fSFYejJbWlh_kv2zRPmVx2DnP79StX8aB3pfqQX3qLEXs8A3So00mVg5GLrA6W1ZEP_zQruiwfUkvQLzLUYcVW-LpZ7XAzy-jazzDJEVQ2; ASP.NET_SessionId=51002cfqof4bnefbddzmapfe; __zi=2000.a9cc9d3751bdb8e3e1ac.1485268643285.94f1b741; _ga=GA1.2.2032074393.1485268642");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				document.append(inputLine);
			}

			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("Time getPageContent: " + (System.currentTimeMillis() - start));
		return document.toString();
	  }
	
	/**
	 * @return
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 */
	public Map<String, NewsPattern> inIt() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		File[] files = new File(FilePathConstant.NEWS_PATTERN_FOLDER).listFiles();
//		File[] files = new File("D:\\ADMICRO\\EDS\\resource\\news").listFiles();
		Map<String, NewsPattern> mapNewsPattern = new HashMap<String, NewsPattern>();
		if (files != null){
			for (File file : files) {
				if (!file.isDirectory() && !file.isHidden() && file.exists()) {
					NewsPattern newsPattern = new NewsPattern();
					String site = file.getName().replace("_pattern.txt", "").replace("_", ".");
					newsPattern.setSite(site.trim());
					
					FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
					String line = null;
					br.mark(4);
					if ('\ufeff' != br.read()) br.reset();
					do {
						
						line = br.readLine();
						if (line != null && !line.equalsIgnoreCase("")) {
							String[] keyValue = line.toString().trim().split(":");
							String proName = keyValue[0].toString().trim().substring(3);
							Class<?> clz = null;
							try {
								clz = newsPattern.getClass().getDeclaredField(proName.substring(0,1).toLowerCase() + proName.substring(1)).getType();
							} catch (Exception e) {
								System.out.println(file.getName());
							}
							Method method = newsPattern.getClass().getMethod(keyValue[0].trim(), clz);
							String value = "";
							if(keyValue.length == 2) value = keyValue[1].trim();
							method.invoke(newsPattern, value);
							
						}
					} while (line != null);
					
					mapNewsPattern.put(site, newsPattern);
				}
			}		
		}
		return mapNewsPattern;
	}
	
	
	/**
	 * @param folderPath
	 * @return
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 */
	public Map<String, NewsPattern> inIt(String folderPath) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		File[] files = new File(folderPath).listFiles();
		Map<String, NewsPattern> mapNewsPattern = new HashMap<String, NewsPattern>();
		if (files != null){
			for (File file : files) {
				if (!file.isDirectory() && !file.isHidden() && file.exists()) {
					NewsPattern newsPattern = new NewsPattern();
					String site = file.getName().replace("_pattern.txt", "").replace("_", ".");
					newsPattern.setSite(site.trim());
					
					FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
					String line = null;
					br.mark(4);
					if ('\ufeff' != br.read()) br.reset();
					do {
						
						line = br.readLine();
						if (line != null && !line.equalsIgnoreCase("")) {
							String[] keyValue = line.toString().trim().split(":");
							String proName = keyValue[0].toString().trim().substring(3);
							Class<?> clz = null;
							try {
								clz = newsPattern.getClass().getDeclaredField(proName.substring(0,1).toLowerCase() + proName.substring(1)).getType();
							} catch (Exception e) {
								System.out.println(file.getName());
							}
							Method method = newsPattern.getClass().getMethod(keyValue[0].trim(), clz);
							String value = "";
							if(keyValue.length == 2) value = keyValue[1].trim();
							method.invoke(newsPattern, value);
							
						}
					} while (line != null);
					
					mapNewsPattern.put(site, newsPattern);
				}
			}		
		}
		return mapNewsPattern;
	}

	/**
	 * @param url
	 * @return
	 */
	public NewsPattern getNewsPattern(String url){
		String site = "";
		try {
			site = getDomainName(url);
			if(site.equals("bit.ly") || site.equals("t.co") || site.equals("fb.me")){
				url = expandUrl(url);
				site = getDomainName(url);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapNewsPattern.get(site);
	}
	
	public String expandUrl(String shortenedUrl) throws IOException {
		String expandedURL = shortenedUrl;
		try {
			if(!shortenedUrl.startsWith("http://")&&!shortenedUrl.startsWith("https://")){
				shortenedUrl = "http://" + shortenedUrl;
			}
			String unshortedUrl = "";
			HttpURLConnection httpURLConnection = null;
	        while(true) {
	        	URL url = new URL(expandedURL);
	            // open connection
	        	httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); 
	            
	            // stop following browser redirect
	            httpURLConnection.setInstanceFollowRedirects(false);
	             
	            // extract location header containing the actual destination URL
	            unshortedUrl = expandedURL;
	            expandedURL = httpURLConnection.getHeaderField("location") == null ? httpURLConnection.getHeaderField("Location") : httpURLConnection.getHeaderField("location");
	            try {
					if((getDomainName(unshortedUrl).equals(getDomainName(expandedURL==null? "http://cuongtuannguyen.vn" : expandedURL)) && (unshortedUrl.substring(0, 5).equals(expandedURL.substring(0, 5))))|| expandedURL == null){
						expandedURL = unshortedUrl;
						break;
					}
				} catch (URISyntaxException e) {
					expandedURL = "";
				}
	        }
	        httpURLConnection.disconnect();
		} catch (Exception e) {
			expandedURL =  "";
		}
		return expandedURL;
    }
	
	/**
	 * @param html
	 * @return
	 */
	public String getPlainText(String html){
		return Jsoup.parse(html).text();
	}
	
	public Date convertToDate(String strDate){
		Date date= null;
		try {
			String hms = "(\\d{0,2}:\\d{0,2}(:\\d{0,2})?)";
			String dmy = "(\\d{0,2}(-|\\/)\\d{0,2}(-|\\/)\\d{0,4})";
			// day month year - hour minute secound
			//without second
//			String PATTERN1 = "(\\d{0,2}-\\d{0,2}-\\d{0,4} \\d{0,2}:\\d{0,2})";
//			String PATTERN2 = "(\\d{0,2}/\\d{0,2}/\\d{0,4} \\d{0,2}:\\d{0,2})";
//			// has second
//			String PATTERN3 = "(\\d{0,2}/\\d{0,2}/\\d{0,4} \\d{0,2}:\\d{0,2}:\\d{0,2})";
//			String PATTERN4 = "(\\d{0,2}/\\d{0,2}/\\d{0,4} \\d{0,2}:\\d{0,2}:\\d{0,2})";
//			
			
			// hour minute second - day month year
//			String PATTERN4 = "(\\d{0,2}/\\d{0,2}/\\d{0,4} \\d{0,2}:\\d{0,2}:\\d{0,2})";
//			String PATTERN4 = "(\\d{0,2}/\\d{0,2}/\\d{0,4} \\d{0,2}:\\d{0,2}:\\d{0,2})";
//			
//			List<String> list = new ArrayList<String>();
//			list.add(PATTERN4);
//			list.add(PATTERN3);
//			list.add(PATTERN2);
//			list.add(PATTERN1);
//			list.add(dmy);
//			list.add(hms);
			
			String dayMonthYear = "";
			String hourMinuteSecond = "";
			
			try {
				Pattern regex = Pattern.compile(dmy);
				Matcher m = regex.matcher(strDate);
				if(m.find()){
					dayMonthYear = m.group();
				}
			} catch (Exception e) {
				dayMonthYear = "";
			}
			
			try {
				Pattern regex = Pattern.compile(hms);
				Matcher m = regex.matcher(strDate);
				if(m.find()){
					if(m.group(2) == null){
						hourMinuteSecond = m.group() + ":00";
					}else{
						hourMinuteSecond = m.group();
					}
				}
			} catch (Exception e) {
				hourMinuteSecond = "";
			}
//			System.err.println(dayMonthYear + " " + hourMinuteSecond);
			DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			if(!"".equals(dayMonthYear) && !"".equals(hourMinuteSecond)){
				if(dayMonthYear.contains("-")){
					format1.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
					date = format1.parse(dayMonthYear + " " + hourMinuteSecond);
				}else{
					format2.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
					date = format2.parse(dayMonthYear + " " + hourMinuteSecond);
				}
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return date;
	}
	
	/**
	 * @param page
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void showAll(Page page) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Field[] fields = page.getClass().getDeclaredFields();
		int count = 0;
		for(Field field : fields){
			String getMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			String setMethod = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			Method gMethod = page.getClass().getDeclaredMethod(getMethod);
			String regex = (String) gMethod.invoke(page);
			if(!regex.equals("")) {
				count ++;
			}
			System.out.println(getMethod +" : "+regex);
		}
		System.out.println("Total fields have value : " + count);
	}
	
	/**
	 * @param url
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void showAll(String url) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException, URISyntaxException, IOException{
		Page page = this.crawlUrl("http://bantinsom.vn/xa-hoi/kinh-doanh/gia-vang-tang-theo-xu-the-ap-sat-moc-37-trieu-dongluong.bts");
		showAll(page);
	}
	
	/**
	 * @param text
	 * @return
	 */
	public List<String> getLinksFromString(String text) {
		String regex = "[https?|ftp:\\/\\/]*(www.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		List<String> result = new ArrayList<String>();
		while(m.find()) {
			result.add(m.group());
		}
		return result;
	}
	
	
}
