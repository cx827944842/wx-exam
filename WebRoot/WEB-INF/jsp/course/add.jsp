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
	<form action="${pageContext.request.contextPath }/s/in/course/add"
		method="post">
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">课程名称</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" required="required"
						name="name" placeholder="课程名称">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">课程代码</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" 
						required="required" name="courseNum" placeholder="课程代码">
				</div>
			</div>

			<div class="weui-cell weui-cell_vcode">
				<div class="weui-cell__hd">
					<label class="weui-label">手机号</label>
				</div>
				<div class="weui-cell__bd">
					<input name="phone" class="weui-input" type="tel"
						placeholder="请输入手机号">
				</div>
				<div class="weui-cell__ft">
					<button class="weui-vcode-btn">获取验证码</button>
				</div>
			</div>


		</div>

		<div class="weui-cells__title">课程描述</div>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<textarea name="description" class="weui-textarea"
						placeholder="请输入课程描述" rows="3"></textarea>
					<div class="weui-textarea-counter">
						<span>0</span>/200
					</div>
				</div>
			</div>
		</div>
		<input type="submit" value="提交" class="weui-btn weui-btn_primary">
	</form>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
