<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>操作成功</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<div class="weui-msg">
		<div class="weui-msg__icon-area">
			<i class="weui-icon-success weui-icon_msg"></i>
		</div>
		<div class="weui-msg__text-area">
			<h2 class="weui-msg__title">${empty title?'请预览你的题目':title}</h2>
			<p class="weui-msg__desc">${description}</p>
		</div>
		<div class="weui-msg__opr-area">
			<p class="weui-btn-area">
				<a
					class="weui-btn weui-btn_primary open-popup"
					data-target="#preview" href="javascript:">预览</a>
				<a
					class="weui-btn weui-btn_primary"
					 href="${pageContext.request.contextPath}/s/in/question/import2">确认导入</a>

			</p>
		</div>

		<div id="preview" class='weui-popup__container'>
			<div class="weui-popup__overlay"></div>
			<div class="weui-popup__modal">
				<header class='demos-header'>
					<h2 class="demos-second-title">题目预览</h2>
				</header>
				<article class="weui-article">
					<c:forEach items="${sessionScope.preview}" var="me">
					<section>
						<h2 class="title">科目：${me.subject }</h2>
						<h2 class="title">知识点：${me.knowledgePoint }</h2>
						<h2 class="title">题目描述:${me.description }</h2>
						<h2 class="title">题目类型：${me.type }</h2>
						<h2 class="title">
							答案：
							<c:if test="${me.type=='填空题'}">
													${me.answerStr }
												</c:if>
							<c:if test="${me.type!='填空题'}">
													${me.answer}
												</c:if>
						</h2>
						<section>
							<h3>题干：</h3>
							<p>${me.content }</p>
							<p>
								<c:if test="${me.type=='选择题'}">
									<%-- ${me.fullContent} --%>
									<c:if test="${!empty me.choiceA}">${me.choiceA}<br>
									</c:if>
									<c:if test="${!empty me.choiceB}">${me.choiceB}<br>
									</c:if>
									<c:if test="${!empty me.choiceC}">${me.choiceC}<br>
									</c:if>
									<c:if test="${!empty me.choiceD}">${me.choiceD}<br>
									</c:if>
									<c:if test="${!empty me.choiceE}">${me.choiceE}<br>
									</c:if>
									<c:if test="${!empty me.choiceF}">${me.choiceF}<br>
									</c:if>
									<c:if test="${!empty me.choiceG}">${me.choiceG}<br>
									</c:if>
									<c:if test="${!empty me.choiceH}">${me.choiceH}<br>
									</c:if>
								</c:if>
							</p>
						</section>

					</section>
					<br>
					</c:forEach>
				</article>
				<a href="javascript:;" class="weui-btn weui-btn_primary close-popup">关闭</a>
				<br> <br> <br>
			</div>
		</div>



		<div class="weui-msg__extra-area">
			<div class="weui-footer">
				<p class="weui-footer__links">
					<a href="javascript:void(0);" class="weui-footer__link">底部链接文本</a>
				</p>
				<p class="weui-footer__text">Copyright © 2008-2016 weui.io</p>
			</div>
		</div>
	</div>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
	
</body>
</html>
