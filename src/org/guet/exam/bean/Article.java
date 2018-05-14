package org.guet.exam.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import me.chanjar.weixin.mp.bean.WxMpMassNews.WxMpMassNewsArticle;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews.WxMpMaterialNewsArticle;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;

/**
 * 图文素材中的article实体
 * 需要保存到数据库中以用于复用
 * @author cx
 *
 */
@Entity
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3756945771135752768L;
	private Long id;
	private Date time;
	 /**
     * (必填) 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     */
    private String thumbMediaId;
    /**
     * 图文消息的封面url
     */
    private String thumbUrl;
    /**
     * 图文消息的作者
     */
    private String author;
    /**
     * (必填) 图文消息的标题
     */
    private String title;
    /**
     * 在图文消息页面点击“阅读原文”后的页面链接
     */
    private String contentSourceUrl;
    /**
     * (必填) 图文消息页面的内容，支持HTML标签
     */
    private String content;
    /**
     * 图文消息的描述
     */
    private String digest;
    /**
     * 是否显示封面，true为显示，false为不显示
     */
    private boolean showCoverPic;

    /**
     * 点击图文消息跳转链接
    */
    private String url;
    
    
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

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
	@Column(columnDefinition="longtext")
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
    
	/**
	 * 转成sdk中的类型
	 * @return
	 */
	public WxMpMaterialNewsArticle transToNews(){
		WxMpMaterialNewsArticle article=new WxMpMaterialNewsArticle();
		
		article.setAuthor(author);
		article.setContent(content);
		article.setContentSourceUrl(contentSourceUrl);
		article.setDigest(digest);
		article.setShowCoverPic(showCoverPic);
		article.setThumbMediaId(thumbMediaId);
		article.setThumbUrl(thumbUrl);
		article.setTitle(title);
		article.setUrl(contentSourceUrl);
		
		return article;
	}
	
	public WxMpMassNewsArticle transToMass(){
		WxMpMassNewsArticle article=new WxMpMassNewsArticle();
		
		article.setAuthor(author);
		article.setContent(content);
		article.setContentSourceUrl(contentSourceUrl);
		article.setDigest(digest);
		article.setShowCoverPic(showCoverPic);
		article.setThumbMediaId(thumbMediaId);
		article.setTitle(title);
		
		return article;
	}

	public Item transToItem() {
		Item e=new Item();
		e.setDescription(digest);
		e.setPicUrl(thumbUrl);
		e.setTitle(title);
		e.setUrl(contentSourceUrl);
		return e;
	}
    
}
