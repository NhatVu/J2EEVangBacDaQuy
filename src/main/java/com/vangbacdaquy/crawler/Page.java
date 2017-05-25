package com.vangbacdaquy.crawler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuongdev
 *
 */
public class Page {
	private String site;
	private String urlCategoryRestrictHml;
	private String urlCategoryRestrictHmlSecond;
	private String urlCategoryRemoveTagNoUsed;
	private String urlCategorySingle;
	private String urlArticleRestrictHml;
	private String urlArticleRestrictHmlSecond;
	private String urlArticleRemoveTagNoUsed;
	private String urlArticleSingle;
	private String rulePaging;
	private String pagingLimit;
	private String restrictHtml;
	private String removeTagNoUse;
	private String id;
	private String idSecond;
	private String title;
	private String titleSecond;
	private String titleRemoveTag;
	private String summary;
	private String summarySecond;
	private String summaryRemoveTag;
	private String content;
	private String contentSecond;
	private String contentRemoveTag;
	private String categoryName;
	private String categoryNameSecond;
	private String categoryNameRemoveTag;
	private String postDate;
	private String postDateSecond;
	private String postDateRemoveTag;
	private String ruleDateTime;
	private String tagnameRestrictHtml;
	private String tagnameRestrictHtmlSecond;
	private String tagnameRemoveTag;
	private String tagnameSingle;
	private String author;
	private String authorSecond;
	private String authorRemoveTag;
	private String commentRulePaging;
	private String commentTotalPage;
	private String commentTotalPageSecond;
	private String commentTotalPageRemoveTag;
	private String comment;
	private String commentSecond;
	private String commentRemoveTag;
	private String urlIgnore;
	private String urlValid;
	private String commentId;
	private String commentIdSecond;
	private String commentIdRemoveTag;
	private String url;
	
	public Page() {
		try {
			safeSetNull();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void safeSetNull() throws Exception {
		try {
			for(Field field:getClass().getDeclaredFields()) {
				if(field.getType().equals(Integer.class) && field.get(this) == null) {
					field.set(this, 0);
				}else if(field.getType().equals(BigDecimal.class) && field.get(this) == null) {
					field.set(this, BigDecimal.ZERO);
				}else if(field.getType().equals(Float.class) && field.get(this) == null) {
					field.set(this, 0f);
				}else if(field.getType().equals(Double.class) && field.get(this) == null) {
					field.set(this, 0d);
				}else if(field.getType().equals(Long.class) && field.get(this) == null) {
					field.set(this, 0l);
				}else if(field.getType().equals(String.class) && field.get(this) == null) {
					field.set(this, "");
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		} 
	}
	
	public Page(String url) {
		this.url = url;
	}
	
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentIdSecond() {
		return commentIdSecond;
	}
	public void setCommentIdSecond(String commentIdSecond) {
		this.commentIdSecond = commentIdSecond;
	}
	public String getCommentIdRemoveTag() {
		return commentIdRemoveTag;
	}
	public void setCommentIdRemoveTag(String commentIdRemoveTag) {
		this.commentIdRemoveTag = commentIdRemoveTag;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getUrlCategoryRestrictHml() {
		return urlCategoryRestrictHml;
	}
	public void setUrlCategoryRestrictHml(String urlCategoryRestrictHml) {
		this.urlCategoryRestrictHml = urlCategoryRestrictHml;
	}
	public String getUrlCategoryRestrictHmlSecond() {
		return urlCategoryRestrictHmlSecond;
	}
	public void setUrlCategoryRestrictHmlSecond(String urlCategoryRestrictHmlSecond) {
		this.urlCategoryRestrictHmlSecond = urlCategoryRestrictHmlSecond;
	}
	public String getUrlCategoryRemoveTagNoUsed() {
		return urlCategoryRemoveTagNoUsed;
	}
	public void setUrlCategoryRemoveTagNoUsed(String urlCategoryRemoveTagNoUsed) {
		this.urlCategoryRemoveTagNoUsed = urlCategoryRemoveTagNoUsed;
	}
	public String getUrlCategorySingle() {
		return urlCategorySingle;
	}
	public void setUrlCategorySingle(String urlCategorySingle) {
		this.urlCategorySingle = urlCategorySingle;
	}
	public String getUrlArticleRestrictHml() {
		return urlArticleRestrictHml;
	}
	public void setUrlArticleRestrictHml(String urlArticleRestrictHml) {
		this.urlArticleRestrictHml = urlArticleRestrictHml;
	}
	public String getUrlArticleRestrictHmlSecond() {
		return urlArticleRestrictHmlSecond;
	}
	public void setUrlArticleRestrictHmlSecond(String urlArticleRestrictHmlSecond) {
		this.urlArticleRestrictHmlSecond = urlArticleRestrictHmlSecond;
	}
	public String getUrlArticleRemoveTagNoUsed() {
		return urlArticleRemoveTagNoUsed;
	}
	public void setUrlArticleRemoveTagNoUsed(String urlArticleRemoveTagNoUsed) {
		this.urlArticleRemoveTagNoUsed = urlArticleRemoveTagNoUsed;
	}
	public String getUrlArticleSingle() {
		return urlArticleSingle;
	}
	public void setUrlArticleSingle(String urlArticleSingle) {
		this.urlArticleSingle = urlArticleSingle;
	}
	public String getRulePaging() {
		return rulePaging;
	}
	public void setRulePaging(String rulePaging) {
		this.rulePaging = rulePaging;
	}
	public String getPagingLimit() {
		return pagingLimit;
	}
	public void setPagingLimit(String pagingLimit) {
		this.pagingLimit = pagingLimit;
	}
	public String getRestrictHtml() {
		return restrictHtml;
	}
	public void setRestrictHtml(String restrictHtml) {
		this.restrictHtml = restrictHtml;
	}
	public String getRemoveTagNoUse() {
		return removeTagNoUse;
	}
	public void setRemoveTagNoUse(String removeTagNoUse) {
		this.removeTagNoUse = removeTagNoUse;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdSecond() {
		return idSecond;
	}
	public void setIdSecond(String idSecond) {
		this.idSecond = idSecond;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleSecond() {
		return titleSecond;
	}
	public void setTitleSecond(String titleSecond) {
		this.titleSecond = titleSecond;
	}
	public String getTitleRemoveTag() {
		return titleRemoveTag;
	}
	public void setTitleRemoveTag(String titleRemoveTag) {
		this.titleRemoveTag = titleRemoveTag;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSummarySecond() {
		return summarySecond;
	}
	public void setSummarySecond(String summarySecond) {
		this.summarySecond = summarySecond;
	}
	public String getSummaryRemoveTag() {
		return summaryRemoveTag;
	}
	public void setSummaryRemoveTag(String summaryRemoveTag) {
		this.summaryRemoveTag = summaryRemoveTag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentSecond() {
		return contentSecond;
	}
	public void setContentSecond(String contentSecond) {
		this.contentSecond = contentSecond;
	}
	public String getContentRemoveTag() {
		return contentRemoveTag;
	}
	public void setContentRemoveTag(String contentRemoveTag) {
		this.contentRemoveTag = contentRemoveTag;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryNameSecond() {
		return categoryNameSecond;
	}
	public void setCategoryNameSecond(String categoryNameSecond) {
		this.categoryNameSecond = categoryNameSecond;
	}
	public String getCategoryNameRemoveTag() {
		return categoryNameRemoveTag;
	}
	public void setCategoryNameRemoveTag(String categoryNameRemoveTag) {
		this.categoryNameRemoveTag = categoryNameRemoveTag;
	}
	public String getPostDate() {
		return convertToStrDate(postDate);
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostDateSecond() {
		return postDateSecond;
	}
	public void setPostDateSecond(String postDateSecond) {
		this.postDateSecond = postDateSecond;
	}
	public String getPostDateRemoveTag() {
		return postDateRemoveTag;
	}
	public void setPostDateRemoveTag(String postDateRemoveTag) {
		this.postDateRemoveTag = postDateRemoveTag;
	}
	public String getRuleDateTime() {
		return ruleDateTime;
	}
	public void setRuleDateTime(String ruleDateTime) {
		this.ruleDateTime = ruleDateTime;
	}
	public String getTagnameRestrictHtml() {
		return tagnameRestrictHtml;
	}
	public void setTagnameRestrictHtml(String tagnameRestrictHtml) {
		this.tagnameRestrictHtml = tagnameRestrictHtml;
	}
	public String getTagnameRestrictHtmlSecond() {
		return tagnameRestrictHtmlSecond;
	}
	public void setTagnameRestrictHtmlSecond(String tagnameRestrictHtmlSecond) {
		this.tagnameRestrictHtmlSecond = tagnameRestrictHtmlSecond;
	}
	public String getTagnameRemoveTag() {
		return tagnameRemoveTag;
	}
	public void setTagnameRemoveTag(String tagnameRemoveTag) {
		this.tagnameRemoveTag = tagnameRemoveTag;
	}
	public String getTagnameSingle() {
		return tagnameSingle;
	}
	public void setTagnameSingle(String tagnameSingle) {
		this.tagnameSingle = tagnameSingle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorSecond() {
		return authorSecond;
	}
	public void setAuthorSecond(String authorSecond) {
		this.authorSecond = authorSecond;
	}
	public String getAuthorRemoveTag() {
		return authorRemoveTag;
	}
	public void setAuthorRemoveTag(String authorRemoveTag) {
		this.authorRemoveTag = authorRemoveTag;
	}
	public String getCommentRulePaging() {
		return commentRulePaging;
	}
	public void setCommentRulePaging(String commentRulePaging) {
		this.commentRulePaging = commentRulePaging;
	}
	public String getCommentTotalPage() {
		return commentTotalPage;
	}
	public void setCommentTotalPage(String commentTotalPage) {
		this.commentTotalPage = commentTotalPage;
	}
	public String getCommentTotalPageSecond() {
		return commentTotalPageSecond;
	}
	public void setCommentTotalPageSecond(String commentTotalPageSecond) {
		this.commentTotalPageSecond = commentTotalPageSecond;
	}
	public String getCommentTotalPageRemoveTag() {
		return commentTotalPageRemoveTag;
	}
	public void setCommentTotalPageRemoveTag(String commentTotalPageRemoveTag) {
		this.commentTotalPageRemoveTag = commentTotalPageRemoveTag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentSecond() {
		return commentSecond;
	}
	public void setCommentSecond(String commentSecond) {
		this.commentSecond = commentSecond;
	}
	public String getCommentRemoveTag() {
		return commentRemoveTag;
	}
	public void setCommentRemoveTag(String commentRemoveTag) {
		this.commentRemoveTag = commentRemoveTag;
	}
	public String getUrlIgnore() {
		return urlIgnore;
	}
	public void setUrlIgnore(String urlIgnore) {
		this.urlIgnore = urlIgnore;
	}
	public String getUrlValid() {
		return urlValid;
	}
	public void setUrlValid(String urlValid) {
		this.urlValid = urlValid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @param strDate
	 * @return
	 */
	public Date convertToDate(String strDate){
		Date date= null;
		try {
			String hms = "(\\d{0,2}:\\d{0,2}(:\\d{0,2})?)";
			String dmy = "(\\d{0,2}(-|\\/)\\d{0,2}(-|\\/)\\d{0,4})";
			String dayMonthYear = "";
			String hourMinuteSecond = "";
			
			try {
				Pattern regex = Pattern.compile(dmy);
				Matcher m = regex.matcher(strDate);
				if(m.find()){
					dayMonthYear = m.group();
				}
			} catch (Exception e) {
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
			}
//			System.err.println(dayMonthYear + " " + hourMinuteSecond);
			DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			if(dayMonthYear.contains("-")){
				format1.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
				date = format1.parse(dayMonthYear + " " + hourMinuteSecond);
			}else{
				format2.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
				date = format2.parse(dayMonthYear + " " + hourMinuteSecond);
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return date;
	}
	
	/**
	 * @param strDate
	 * @return
	 */
	public String convertToStrDate(String strDate){
		String date= "";
		try {
			String hms = "(\\d{0,2}:\\d{0,2}(:\\d{0,2})?)";
			String dmy = "(\\d{0,2}(-|\\/)\\d{0,2}(-|\\/)\\d{0,4})";
			String dayMonthYear = "";
			String hourMinuteSecond = "";
			
			try {
				Pattern regex = Pattern.compile(dmy);
				Matcher m = regex.matcher(strDate);
				if(m.find()){
					dayMonthYear = m.group();
				}
			} catch (Exception e) {
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
			}
//			System.err.println(dayMonthYear + " " + hourMinuteSecond);
			date = dayMonthYear + " " + hourMinuteSecond;
			
		} catch (Exception e) {
			return "";
		}
		
		return date.replace("-", "/");
	}
	
	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for(Field field : fields){
			String getMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			String setMethod = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			Method gMethod = null;
			try {
				gMethod = this.getClass().getDeclaredMethod(getMethod);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			String regex = null;
			try {
				regex = (String) gMethod.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			if(regex != null && !regex.equals("")) {
				count ++;
			}
			sb.append(getMethod +" : "+regex).append("\n");
		}
		sb.append("Total fields have value : " + count);
		return sb.toString();
	}
	
}
