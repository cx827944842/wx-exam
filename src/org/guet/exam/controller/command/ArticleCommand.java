package org.guet.exam.controller.command;

/**
 * 添加图文素材表单模型
 * 
 * @author cx
 *
 */
public class ArticleCommand {
	private String thumbMediaId;
	private String thumbUrl;
	private String author;
	private String title;
	private String contentSourceUrl;
	private String content;
	private String digest;
	private boolean showCoverPic;
	private String url;
	
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public boolean isShowCoverPic() {
		return showCoverPic;
	}
	public void setShowCoverPic(boolean showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
