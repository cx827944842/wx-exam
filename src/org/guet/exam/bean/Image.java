package org.guet.exam.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 图片
 * @author cx
 *
 */
@Entity
public class Image {
	@Id
	private String url;
	private String wxUrl;
	private String localPath;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWxUrl() {
		return wxUrl;
	}
	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}
	public String getLocalPath() {
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	
	
	
	
}
