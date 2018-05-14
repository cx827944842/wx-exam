<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>身份验证</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<form action="${pageContext.request.contextPath }/s/user/certified"
		method="post">
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">姓名</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" required="required"
						name="name" placeholder="姓名">
				</div>
			</div>

			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">学号/教工号</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" required="required"
						name="scNum" placeholder="学号/教工号">
				</div>
			</div>

			<div class="weui-cell weui-cell_vcode">
				<div class="weui-cell__hd">
					<label class="weui-label">手机号</label>
				</div>
				<div class="weui-cell__bd">
					<input name="phone" class="weui-input" type="tel" required="required"
						placeholder="请输入手机号">
				</div>
				<div class="weui-cell__ft">
					<button class="weui-vcode-btn">获取验证码</button>
				</div>
			</div>


		</div>

		<div class="weui-cells__title">用户角色</div>
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check__label" for="x11">
				<div class="weui-cell__bd">
					<p>学生</p>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" class="weui-check" value="0" name="role"
						id="x11"> <span class="weui-icon-checked"></span>
				</div>
			</label> <label class="weui-cell weui-check__label" for="x12">

				<div class="weui-cell__bd">
					<p>老师</p>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" name="role" value="1" class="weui-check"
						id="x12" checked="checked"> <span
						class="weui-icon-checked"></span>
				</div>
			</label>
		</div>
		<input type="submit" value="提交" class="weui-btn weui-btn_primary">
	</form>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
