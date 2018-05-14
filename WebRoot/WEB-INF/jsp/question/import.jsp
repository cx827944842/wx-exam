<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>题目录入</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<div class="weui-msg">
		<div class="weui-msg__icon-area">
			<i class="weui-icon-info weui-icon_msg"></i>
		</div>
		<div class="weui-msg__text-area">
			<h2 class="weui-msg__title">题库导入</h2>
			<p class="weui-msg__desc">
				文件格式说明： 
				<a  href="${pageContext.request.contextPath }/s/in/question/importRules">格式说明;</a>
			</p>
		</div>

		<form id="form1"
			action="${pageContext.request.contextPath}/s/in/question/import"
			method="post" enctype="multipart/form-data">

			<!-- 题型选择 -->

			<label>上传题库Excel文件</label><br> <input style=""
				class="weui-btn weui-btn_default" name="file" type="file"
				required="required"> <br> <input type="submit"
				value="提交" class="weui-btn weui-btn_primary">
		</form>


	</div>
	

	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>

</body>
</html>
