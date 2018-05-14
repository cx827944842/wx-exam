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
	<article class="weui-article">
		<h1>题库导入文件格式说明</h1>
		<section>
			<h2 class="title">Excel文件</h2>
			<section>
				<h3>题型与表</h3>
				<p>如下图所示，在excel文件中分别建立三个名为“判断题”、“填空题”、“选择题”的表。用来分别存储不同题型的题目信息。
				</p>
				<p>
					<img id="sheets" src="${pageContext.request.contextPath }/rules/sheets.png"
						alt=""> 
				</p>
			</section>
			<section>
				<h3>选择题</h3>
				<p>如下图所示，在“选择题”表中按照如下格式存放题目内容：
				<br>	第1列：题干
				<br>	第2列：相关科目
				<br>	第3列：知识点或章节
				<br>	第4列：正确答案 多个答案中间用“,”分隔。
				<br>	第5-12列：选项A-H （最多八个选项）
				</p>
				<p>
					
					<img id="choice"
						src="${pageContext.request.contextPath }/rules/choice.png" alt="">
					

				</p>
			</section>
			<section>
				<h3>填空题</h3>
				<p>如下图所示，在“填空题”表中按照如下格式存放题目内容：
					<br>第1列：题干
					<br>第2列：相关科目
					<br>第3列：知识点或章节
					<br>第4-11列：空1-8的正确答案，按顺序填（最多八个空）。
				</p>
				<p>
					
					
					<img id="filling"
						src="${pageContext.request.contextPath }/rules/filling.png" alt="">

				</p>
			</section>
			<section>
				<h3>判断题</h3>
				<p>如下图所示，在“判断题”表中按照如下格式存放题目内容：
					<br>第1列：题干
					<br>第2列：相关科目
					<br>第3列：知识点或章节
					<br>第4列：正确答案（T或F）。
				</p>
				<p>
					<img id="judge"
						src="${pageContext.request.contextPath }/rules/judge.png" alt="">
				</p>
			</section>
		</section>
	</article>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/swiper.js"></script>
	<script type="text/javascript">
		var pb2 = $
				.photoBrowser({
					items : [
							
							{
								image : "${pageContext.request.contextPath}/rules/sheets.png",
								caption : "文件所包含的表示意图"
							},{
								image : "${pageContext.request.contextPath}/rules/choice.png",
								caption : "选择题格式示意图"
							},{
								image : "${pageContext.request.contextPath}/rules/filling.png",
								caption : "填空题格式示意图"
							},
							{
								image : "${pageContext.request.contextPath}/rules/judge.png",
								caption : "判断题格式示意图"
							}
							],
					initIndex : 0
				});
		$("#sheets").click(function() {
			pb2.open(0);
		});
		$("#choice").click(function() {
			pb2.open(1);
		});
		$("#judge").click(function() {
			pb2.open(3);
		});
		$("#filling").click(function() {
			pb2.open(2);
		});
	</script>
</body>
</html>
