<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<i class="weui-icon-warn weui-icon_msg-primary"></i>
		</div>
		<div class="weui-msg__text-area">
			<h2 class="weui-msg__title">warnning</h2>
			<p class="weui-msg__desc">
				${description}
			</p>
		</div>
		<div class="weui-msg__opr-area">
			<p class="weui-btn-area">
				<a href="${pageContext.request.contextPath}/s/in/${mainOperationUrl}" class="weui-btn weui-btn_primary">${mainOperationName }</a> <a
					href="${pageContext.request.contextPath}/s/in/${viceOperationUrl}" class="weui-btn weui-btn_default">${viceOperationName }</a>
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
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
