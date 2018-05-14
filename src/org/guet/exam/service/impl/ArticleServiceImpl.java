package org.guet.exam.service.impl;

import java.util.List;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.bean.Article;
import org.guet.exam.service.ArticleService;
import org.guet.exam.service.ImageService;
import org.guet.exam.util.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.mp.bean.WxMpMassNews.WxMpMassNewsArticle;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews.WxMpMaterialNewsArticle;
@Service
public class ArticleServiceImpl extends DaoSupportImpl<Article> implements ArticleService {
	@Autowired
	private ImageService imageService;
	@Override
	public void delete(Long[] articleIds) {
		for(int i=0;i<articleIds.length;i++){
			if(i%20==0){
				getSession().flush();
			}
			getSession().delete(getById(articleIds[i]));
		}
	}
	@Override
	public WxMpMassNewsArticle transToMass(Article a){
		WxMpMassNewsArticle article=new WxMpMassNewsArticle();
		
		article.setAuthor(a.getAuthor());
		String content=a.getContent();
		List<String> srcList=HtmlUtils.getImgSrc(content);
		
		for(String src:srcList){
			String wxUrl=imageService.getWxrUrl(src);
			if(wxUrl!=null){
				content=content.replace(src,wxUrl);
				System.out.println("将"+src+"替换为"+wxUrl);
			}
		}
		
		article.setContent(content);
		
		article.setContentSourceUrl(a.getContentSourceUrl());
		article.setDigest(a.getDigest());
		article.setShowCoverPic(a.isShowCoverPic());
		article.setThumbMediaId(a.getThumbMediaId());
		article.setTitle(a.getTitle());
		
		return article;
	}
	public WxMpMaterialNewsArticle transToNews(Article a){
		WxMpMaterialNewsArticle article=new WxMpMaterialNewsArticle();
		
		article.setAuthor(a.getAuthor());
		
		String content=a.getContent();
		List<String> srcList=HtmlUtils.getImgSrc(content);
		
		for(String src:srcList){
			String wxUrl=imageService.getWxrUrl(src);
			if(wxUrl!=null){
				content=content.replace(src,wxUrl);
				System.out.println("将"+src+"替换为"+wxUrl);
			}
		}
		article.setContent(content);
		
		
		article.setContentSourceUrl(a.getContentSourceUrl());
		article.setDigest(a.getDigest());
		article.setShowCoverPic(a.isShowCoverPic());
		article.setThumbMediaId(a.getThumbMediaId());
		article.setThumbUrl(a.getThumbUrl());
		article.setTitle(a.getTitle());
		article.setUrl(a.getUrl());
		
		return article;
	}
}
