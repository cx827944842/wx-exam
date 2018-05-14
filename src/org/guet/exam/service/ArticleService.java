package org.guet.exam.service;

import org.guet.exam.base.DaoSupport;
import org.guet.exam.bean.Article;

import me.chanjar.weixin.mp.bean.WxMpMassNews.WxMpMassNewsArticle;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews.WxMpMaterialNewsArticle;

public interface ArticleService extends DaoSupport<Article> {

	void delete(Long[] articleIds);

	WxMpMassNewsArticle transToMass(Article a);

	WxMpMaterialNewsArticle transToNews(Article article);
}
