<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>自动生成测试</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<div class="weui-msg">
		<div class="weui-msg__icon-area">
			<i class="weui-icon-info weui-icon_msg""></i>
		</div>
		<div class="weui-msg__text-area">
			<h2 class="weui-msg__title">试卷主要考点</h2>
			<p class="weui-msg__desc"></p>
		</div>
		<form
			action="${pageContext.request.contextPath }/s/in/question/autopick"
			method="post">
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">相关科目</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" name="subject"
						placeholder="相关科目">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">相关知识点</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" name="knowledgePoint"
						placeholder="多个知识点如：线程,集合">
				</div>
			</div>

			<button type="submit" class="weui-btn weui-btn_primary">提交</</button>
		</form>
	</div>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
