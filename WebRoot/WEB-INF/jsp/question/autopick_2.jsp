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
			<h2 class="weui-msg__title">符合要求的题目统计</h2>
			<p class="weui-msg__desc">总共${total }道，其中有${choice }道选择题题
				，${judge }道判断题，${filling }道填空题</p>
		</div>
		<form
			action="${pageContext.request.contextPath }/s/in/question/autopick2"
			method="post">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<p>选择题</p>
				</div>
				<div class="weui-cell__ft">
					<div class="weui-count">
						<a class="weui-count__btn weui-count__decrease"></a> <input
							id="choice" name="choice" class="weui-count__number" type="number" value="0" />

						<a class="weui-count__btn weui-count__increase"></a>
					</div>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<p>填空题</p>
				</div>
				<div class="weui-cell__ft">
					<div class="weui-count">
						<a class="weui-count__btn weui-count__decrease"></a> <input
							id="filling" name="filling" class="weui-count__number" type="number" value="0" /> <a
							class="weui-count__btn weui-count__increase"></a>
					</div>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<p>判断题</p>
				</div>
				<div class="weui-cell__ft">
					<div class="weui-count">
						<a class="weui-count__btn weui-count__decrease"></a> <input
							id="judge" name="judge" class="weui-count__number" type="number" value="0" /> <a
							class="weui-count__btn weui-count__increase"></a>
					</div>
				</div>
			</div>


			<button type="submit" class="weui-btn weui-btn_primary">提交</</button>
		</form>
	</div>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath }/js/fastclick.js"></script>
	
	<script>
		var cMAX = ${choice}, MIN = 0;
		var jMAX = ${judge};
		var fMAX = ${filling};
		$('.weui-count__decrease').click(
				function(e) {
					var $input = $(e.currentTarget).parent().find(
							'.weui-count__number');
					var number = parseInt($input.val() || "0") - 1
					if (number < MIN)
						number = MIN;
					$input.val(number)
				})
		$('.weui-count__increase').click(
				function(e) {
					var $input = $(e.currentTarget).parent().find(
							'.weui-count__number');
					var number = parseInt($input.val() || "0") + 1
					if($input.attr("id")=='choice'){
						if (number > cMAX)
							number = cMAX;
					}
					if($input.attr("id")=='judge'){
						if (number > jMAX)
							number = jMAX;
					}
					if($input.attr("id")=='filling'){
						if (number > fMAX)
							number = fMAX;
					}
					$input.val(number)
				})

		
	</script>
</body>
</html>
