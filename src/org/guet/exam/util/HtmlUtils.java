package org.guet.exam.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.guet.exam.entity.BankChoiceQuestion;
import org.guet.exam.entity.BankQuestion;

/**
 * html处理工具类
 * 
 * @author cx
 */
public class HtmlUtils {

	/**
	 * 替换指定标签的属性和值
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @param tag
	 *            标签名称
	 * @param tagAttrib
	 *            要替换的标签属性值
	 * @param startTag
	 *            新标签开始标记
	 * @param endTag
	 *            新标签结束标记
	 * @return
	 * @author huweijun
	 * @date 2016年7月13日 下午7:15:32
	 */
	public static String replaceHtmlTag(String str, String tag, String tagAttrib, String startTag, String endTag) {
		String regxpForTag = "<\\s*" + tag + "\\s+([^>]*)\\s*";
		String regxpForTagAttrib = tagAttrib + "=\\s*\"([^\"]+)\"";
		Pattern patternForTag = Pattern.compile(regxpForTag, Pattern.CASE_INSENSITIVE);
		Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib, Pattern.CASE_INSENSITIVE);
		Matcher matcherForTag = patternForTag.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = matcherForTag.find();
		while (result) {
			StringBuffer sbreplace = new StringBuffer("<" + tag + " ");
			Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
			if (matcherForAttrib.find()) {
				String attributeStr = matcherForAttrib.group(1);
				matcherForAttrib.appendReplacement(sbreplace, startTag + attributeStr + endTag);
			}
			matcherForAttrib.appendTail(sbreplace);
			matcherForTag.appendReplacement(sb, sbreplace.toString());
			result = matcherForTag.find();
		}
		matcherForTag.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 获取img标签中的src值
	 * 
	 * @param content
	 * @return
	 */
	public static List<String> getImgSrc(String content) {

		List<String> list = new ArrayList<String>();
		// 目前img标签标示有3种表达式
		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""
		// src="1.jpg">
		// 开始匹配content中的<img />标签
		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
		boolean result_img = m_img.find();
		if (result_img) {
			while (result_img) {
				// 获取到匹配的<img />标签中的内容
				String str_img = m_img.group(2);

				// 开始匹配<img />标签中的src
				Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
				Matcher m_src = p_src.matcher(str_img);
				if (m_src.find()) {
					String str_src = m_src.group(3);
					list.add(str_src);
				}
				// 结束匹配<img />标签中的src

				// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
				result_img = m_img.find();
			}
		}
		return list;
	}

	// <div class='weui-form-preview'>
	// <div class='weui-form-preview__hd'>
	// <label class='weui-form-preview__label'>题型</label> <em
	// class='weui-form-preview__value'>${me.type }</em>
	// </div>
	// <div class='weui-form-preview__bd' style='text-align: left;'>
	// ${me.content}<br>
	// ${me.choiceA}<br>
	// </div>
	// <div class='weui-form-preview__ft'>
	// <button type='submit' onclick='delDraft(${me.id})'
	// class='weui-form-preview__btn weui-form-preview__btn_primary'
	// href='javascript:'>从草稿中删除</button>
	// </div>
	// </div>
	/**
	 * 将题目转换成html表示
	 * 
	 * @param question
	 * @return
	 */
	public static String questionToDraftHtml(BankQuestion question) {

		String questionHtml = "<div id='draft_" + question.getId() + "' class='weui-form-preview'>";
		questionHtml += "<div class='weui-form-preview__hd'>";
		questionHtml += "<label class='weui-form-preview__label'>题型</label> <em ";
		questionHtml += "class='weui-form-preview__value'>" + question.getType() + "</em></div>";
		questionHtml += "<div class='weui-form-preview__bd' style='text-align: left;'>";
		questionHtml += question.getContent() + "<br>";

		if ("选择题".equals(question.getType())) {
			BankChoiceQuestion bankChoiceQuestion = (BankChoiceQuestion) question;
			questionHtml += bankChoiceQuestion.getChoiceA() != null ? bankChoiceQuestion.getChoiceA() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceB() != null ? bankChoiceQuestion.getChoiceB() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceC() != null ? bankChoiceQuestion.getChoiceC() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceD() != null ? bankChoiceQuestion.getChoiceD() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceE() != null ? bankChoiceQuestion.getChoiceE() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceF() != null ? bankChoiceQuestion.getChoiceF() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceG() != null ? bankChoiceQuestion.getChoiceG() + "<br>" : "";
			questionHtml += bankChoiceQuestion.getChoiceH() != null ? bankChoiceQuestion.getChoiceH() + "<br>" : "";
		}

		questionHtml += "</div>";
		questionHtml += "<div class='weui-form-preview__ft'>";
		questionHtml += "<button type='submit' onclick='delDraft(" + question.getId() + ")'";
		questionHtml += "class='weui-form-preview__btn weui-form-preview__btn_primary'";
		questionHtml += "href='javascript:'>从草稿中删除</button></div></div>";

		return questionHtml;
	}
//	<div class='weui-msg'>
//	<div class='weui-msg__icon-area'>
//		<i class='weui-icon-info weui-icon_msg'></i>
//	</div>
//	<div class='weui-msg__text-area'>
//		<h2 class='weui-msg__title'>草稿箱是空的：</h2>
//		<p class='weui-msg__desc'>
//			请从题库中添加题目到草稿箱中！<a href='javascript:void(0);'>文字链接</a>
//		</p>
//	</div>
//
//</div>
	/**
	 * 提示页面
	 * @param title
	 * @param content
	 * @return
	 */
	public static String infoUIHtml(String title,String content) {
		String infoUIHtml="<div class='weui-msg'>";
		infoUIHtml+="<div class='weui-msg__icon-area'>";
		infoUIHtml+="<i class='weui-icon-info weui-icon_msg'></i></div>";
		infoUIHtml+="<div class='weui-msg__text-area'>";
		infoUIHtml+="<h2 class='weui-msg__title'>"+title+"</h2>";
		infoUIHtml+="<p class='weui-msg__desc'>"+content+"</p></div></div>";
		
		return infoUIHtml;
	}
	public static void main(String[] args) {
		StringBuffer content = new StringBuffer();
		content.append(
				"<ul class=\"imgBox\"><li><img id=\"160424\" src=\"uploads/allimg/160424/1-160424120T1-50.jpg\" class=\"src_class\"></li>");
		content.append(
				"<li><img id=\"150628\" src=\"uploads/allimg/150628/1-15062Q12247.jpg\" class=\"src_class\"></li></ul>");
		System.out.println("原始字符串为:" + content.toString());
		String newStr = replaceHtmlTag(content.toString(), "img", "src", "src=\"http://junlenet.com/", "\"");
		System.out.println("       替换后为:" + newStr);
	}

}