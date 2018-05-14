package org.guet.exam.util;
/**
 * img 标签生成器
 * @author cx
 *
 */
public class ImgTag {
	private String html;
	private String src;
	private String alt;
	
	public ImgTag() {
	}
	public ImgTag(String src,String alt) {
		this.src=src;
		this.alt=alt;
		
		html="<img src='"+src+"'  alt='"+alt+"' />";
	}
	@Override
	public String toString() {
		return html;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	
}
