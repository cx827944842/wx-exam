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
	<form action="">
	<div class="weui-cells__title">题目类型</div>
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check__label" for="x11">
				<div class="weui-cell__bd">
					<p>选择题</p>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" class="weui-check" name="radio1" id="x11">
					<span class="weui-icon-checked"></span>
				</div>
			</label> <label class="weui-cell weui-check__label" for="x12">

				<div class="weui-cell__bd">
					<p>填空题</p>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" name="radio1" class="weui-check" id="x12"
						checked="checked"> <span class="weui-icon-checked"></span>
				</div>
			</label> <label class="weui-cell weui-check__label" for="x12">

				<div class="weui-cell__bd">
					<p>判断题</p>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" name="radio1" class="weui-check" id="x12"
						checked="checked"> <span class="weui-icon-checked"></span>
				</div>
			</label> <a href="javascript:void(0);" class="weui-cell weui-cell_link">
			</a>
		</div>
		<div class="weui-cells__title">题干</div>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<textarea class="weui-textarea" placeholder="请输入题干" rows="3"></textarea>
					<div class="weui-textarea-counter">
						<span>0</span>/200
					</div>
				</div>
			</div>
		</div>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<div class="weui-uploader">
						<div class="weui-uploader__hd">
							<p class="weui-uploader__title">相关图片上传</p>
							<div class="weui-uploader__info">0/2</div>
						</div>
						<div class="weui-uploader__bd">
							<ul class="weui-uploader__files" id="uploaderFiles">
								<li class="weui-uploader__file weui-uploader__file_status"
									style="background-image: url(./images/pic_160.png)">
									<div class="weui-uploader__file-content">
										<i class="weui-icon-warn"></i>
									</div>
								</li>
								<li class="weui-uploader__file weui-uploader__file_status"
									style="background-image: url(./images/pic_160.png)">
									<div class="weui-uploader__file-content">50%</div>
								</li>
							</ul>
							<div class="weui-uploader__input-box">
								<input id="uploaderInput" class="weui-uploader__input"
									type="file" accept="image/*" multiple="">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">相关科目</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="text" pattern="[0-9]*"
					placeholder="相关科目">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">相关知识点</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="text" pattern="[0-9]*"
					placeholder="相关知识点">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">答案</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="text" pattern="[0-9]*"
					placeholder="答案">
			</div>
		</div>
		<a href="javascript:;" class="weui-btn weui-btn_primary">提交</a>
	</form>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
