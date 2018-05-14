package org.guet.exam.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 二维码实体类型
 * @author cx
 *
 */
public class QrCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3652883101313457277L;
	private String ticket;
	private String url;//二维码跳转 url
	private String imgUrl;//二维码图片路径
	private boolean last; //是否永久二维码
	private Date createTime;//创建时间
	private Integer lastLong;//有效时间 /秒 若为永久则没有
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getLastLong() {
		return lastLong;
	}
	public void setLastLong(Integer lastLong) {
		this.lastLong = lastLong;
	}
	
	
}
