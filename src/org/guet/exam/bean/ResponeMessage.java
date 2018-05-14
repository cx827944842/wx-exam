package org.guet.exam.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 自动回复消息
 * @author cx
 *
 */
@Entity
public class ResponeMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7693858063959140010L;
	
	@Id
	private String ekey;//触发 的key
	private String mediaId;//若回复素材则填 素材的mediaId
	private String message;//key对应的消息
	private String type;//触发类型
	private String contentType;//回复内容类型
	//private Set<Article> articles=new HashSet<Article>();
	public static final String TEXT = "text";
	public static final String EVENT = "event";
	
	public static final String IMAGE = "image";
	public static final String NEWS = "news";
	public static final String VOICE = "voice";
	
	
	
	/*public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}*/
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getEkey() {
		return ekey;
	}
	public void setEkey(String ekey) {
		this.ekey = ekey;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
}
