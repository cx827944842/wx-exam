<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>新建课程</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<form action="${pageContext.request.contextPath }/s/in/exam/create"
		method="post">

		<div class="weui-msg">
			<div class="weui-msg__icon-area">
				<i class="weui-icon-info weui-icon_msg""></i>
			</div>
			<div class="weui-msg__text-area">
				<h2 class="weui-msg__title">测验发布</h2>
				<p class="weui-msg__desc">一共${fn:length(sessionScope.draft)}条习题。</p>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">测验名称</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="name" type="text"
						placeholder="请输入测验名称">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">说明</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="detail" type="text"
						placeholder="请输入相关说明">
				</div>
			</div>

			<div class="weui-cell weui-cell_select weui-cell_select-after">
				<div class="weui-cell__hd">
					<label for="" class="weui-label">选择所属课程</label>
				</div>
				<div class="weui-cell__bd">
					<select class="weui-select" name="courseid" required="required">
						<c:forEach items="${courses}" var="me">
							<option value="${me.id}">${me.name}(${me.courseNum })</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			
			
			
			<div class="weui-msg__opr-area">
				<p class="weui-btn-area">
					<input type="submit" value="发布" class="weui-btn weui-btn_default">
				</p>
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


	</form>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
