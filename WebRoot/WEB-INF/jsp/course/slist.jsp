<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>学生课程</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<c:if test="${empty openList }">
		<div class="weui-msg">
			<div class="weui-msg__icon-area">
				<i class="weui-icon-info weui-icon_msg"></i>
			</div>
			<div class="weui-msg__text-area">
				<h2 class="weui-msg__title">您的所有课程已完结。</h2>
				<p class="weui-msg__desc">
					
				</p>
			</div>

		</div>
	</c:if>

	<c:if test="${!empty openList }">
		<c:forEach items="${openList }" var="me">
			<div class="weui-form-preview">
				<div class="weui-form-preview__hd">
					<label class="weui-form-preview__label">课程名称</label> <em
						class="weui-form-preview__value">${me.name }</em>
				</div>
				<div class="weui-form-preview__bd">
					<div class="weui-form-preview__item">
						<label class="weui-form-preview__label">课程代码</label> <span
							class="weui-form-preview__value">${me.courseNum}</span>
					</div>
					<div class="weui-form-preview__item">
						<label class="weui-form-preview__label">任课教师</label> <span
							class="weui-form-preview__value">${me.teacher.name }</span>
					</div>
					<div class="weui-form-preview__item">
						<label class="weui-form-preview__label">课程描述</label> <span
							class="weui-form-preview__value">${me.description }</span>
					</div>
				</div>
				<div class="weui-form-preview__ft">
					<a class="weui-form-preview__btn weui-form-preview__btn_default"
						href="${pageContext.request.contextPath }/s/in/exam/list?courseId=${me.id}">课堂测验</a>
					<button type="submit"
						class="weui-form-preview__btn weui-form-preview__btn_primary"
						href="${pageContext.request.contextPath }/s/in/course/cancel?courseId=${me.id}">退课</button>
				</div>
			</div>

		</c:forEach>
	</c:if>


	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
