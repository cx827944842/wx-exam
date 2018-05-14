package org.guet.exam.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.guet.exam.bean.Article;
import org.guet.exam.bean.ResponeMessage;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.builder.outxml.NewsBuilder;

public class MessageUtil {
	public static void response(HttpServletResponse response,WxMpXmlMessage in,ResponeMessage message) throws IOException{
		if(ResponeMessage.IMAGE.equals(message.getContentType())){
			responseIMAGE(response, in, message.getMediaId());
		}
		/*if(ResponeMessage.NEWS.equals(message.getContentType())){
			responseNEWS(response, in, articles);
		}*/
		if(ResponeMessage.TEXT.equals(message.getContentType())){
			responseTEXT(response, in, message.getMessage());
		}
		if(ResponeMessage.VOICE.equals(message.getContentType())){
			
		}
		
	}
	public static void responseTEXT(HttpServletResponse response,WxMpXmlMessage in,String text) throws IOException{
		 WxMpXmlOutTextMessage outMessage =WxMpXmlOutMessage.TEXT()
                 .content(text)
                 .fromUser(in.getToUser())
                 .toUser(in.getFromUser())
                 .build();
         response.getWriter().write(outMessage.toXml());
	}
	public static void responseIMAGE(HttpServletResponse response,WxMpXmlMessage in,String media_id) throws IOException{
		WxMpXmlOutImageMessage outMessage =WxMpXmlOutMessage.IMAGE()
				.mediaId(media_id)
				.fromUser(in.getToUser())
				.toUser(in.getFromUser())
				.build();
		response.getWriter().write(outMessage.toXml());
	}
	
	public static void responseNEWS(HttpServletResponse response,WxMpXmlMessage in,List<Article> articles) throws IOException{
		NewsBuilder builder=WxMpXmlOutMessage.NEWS();
		
		for(Article article:articles){
			builder.addArticle(article.transToItem());
		}
		WxMpXmlOutNewsMessage outMessage =builder.fromUser(in.getToUser())
											.toUser(in.getFromUser())
											.build();
		
		response.getWriter().write(outMessage.toXml());
	}
}
