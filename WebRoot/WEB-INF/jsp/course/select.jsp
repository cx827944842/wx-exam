<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<form action="${pageContext.request.contextPath }/s/in/course/select"
		method="post">

		<div class="weui-msg">
			<div class="weui-msg__icon-area">
				<i class="weui-icon-info weui-icon_msg""></i>
			</div>
			<div class="weui-msg__text-area">
				<h2 class="weui-msg__title">选课</h2>
				<p class="weui-msg__desc">请输入课程课号。</p>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">课号</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="courseNum" type="number" placeholder="请输入课号">
				</div>
			</div>
			<div class="weui-msg__opr-area">
				<p class="weui-btn-area">
					<input type="submit" value="选课" class="weui-btn weui-btn_default">
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
