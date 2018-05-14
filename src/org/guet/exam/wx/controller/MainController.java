package org.guet.exam.wx.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.guet.exam.bean.Article;
import org.guet.exam.bean.ResponeMessage;
import org.guet.exam.config.Configuration;
import org.guet.exam.entity.Exam;
import org.guet.exam.service.ArticleService;
import org.guet.exam.service.ExamService;
import org.guet.exam.service.ResponseMessageService;
import org.guet.exam.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;

/**
 * 主要控制器 用于与微信的消息交互
 * 
 * @author cx
 *
 */
@Controller
public class MainController extends GenericController {
	@Autowired
	protected WxMpConfigStorage configStorage;
	@Autowired
	protected WxMpService wxMpService;
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected ResponseMessageService messageService;
	@Autowired
	protected ExamService examService;

	@RequestMapping(value = "main")
	public void connect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");

		if (!this.wxMpService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			response.getWriter().println("非法请求");
			return;
		}

		String echoStr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echoStr)) {
			// 说明是一个仅仅用来验证的请求，回显echostr
			String echoStrOut = String.copyValueOf(echoStr.toCharArray());
			response.getWriter().println(echoStrOut);
			return;
		}

		String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw"
				: request.getParameter("encrypt_type");

		if ("raw".equals(encryptType)) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
			System.out.println("touser=================="+inMessage.getToUser());
			System.out.println("fromuser================"+inMessage.getFromUser());
			// 订阅事件 自动回复公众号使用规则
			
//			if (ResponeMessage.EVENT.equals(inMessage.getMsgType())) {
//				message = messageService.respone(inMessage.getEventKey(), ResponeMessage.EVENT);
//			}
			if (ResponeMessage.TEXT.equals(inMessage.getMsgType())) {
				Exam e = examService.findByToken(inMessage.getContent());
				
				if(e!=null){
					Article a = new Article();
					a.setTitle(e.getCourse().getName()+e.getAccessWords()+"课堂测验");
					a.setContentSourceUrl("http://"+Configuration.getDomain()+"/wx-exam/s/in/exam/show?id="+e.getId());
					a.setDigest(e.getDetail());
					List<Article> articles=new ArrayList<Article>();
					articles.add(a);
					MessageUtil.responseNEWS(response, inMessage, articles);
				}else{
					MessageUtil.responseTEXT(response, inMessage, "令牌不正确");
				}
			}
			
			return;
		}

		if ("aes".equals(encryptType)) {
			// 是aes加密的消息
			/*String msgSignature = request.getParameter("msg_signature");
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), this.configStorage,
					timestamp, nonce, msgSignature);
*/
			return;
		}

		response.getWriter().println("不可识别的加密类型");
		return;
	}

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "main/index";
	}
}
