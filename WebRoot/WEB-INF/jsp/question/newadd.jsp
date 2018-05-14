<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	
	<!-- 容器 -->
	<div class="weui-tab">
		<div class="weui-navbar">
			<a class="weui-navbar__item weui-bar__item--on" href="#tab1">选择题
			</a> <a class="weui-navbar__item" href="#tab2">判断题 </a> <a
				class="weui-navbar__item" href="#tab3">填空题 </a><a
				class="weui-navbar__item" href="#tab4">批量导入 </a>
		</div>
		<div class="weui-tab__bd">
			<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
				<form:form id="choice" commandName="command" action="addchoice"
					method="post" role="form">
					<div class="weui-cells__title">题干</div>
					<div class="weui-cells weui-cells_form">
						<div class="weui-cell">
							<div class="weui-cell__bd">
								<form:textarea path="content" class="weui-textarea"
									required="required" placeholder="请输入题干" rows="3"></form:textarea>
								<div class="weui-textarea-counter">
									<span>0</span>/200
								</div>
							</div>
						</div>
					</div>

					<div class="weui-cells__title">选项</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">A.</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="option1" class="weui-input" required="required"
								type="text" placeholder="选项A" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">B.</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="option2" class="weui-input" required="required"
								type="text" placeholder="选项B" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">C.</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="option3" class="weui-input" type="text"
								placeholder="选项C" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">D.</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="option4" class="weui-input" type="text"
								placeholder="选项D" />
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关科目</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="subject" class="weui-input" type="text"
								required="required" placeholder="相关科目" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关知识点</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="knowledgePoint" class="weui-input" type="text"
								required="required" placeholder="相关知识点" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">答案</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="answer" class="weui-input" type="text"
								required="required" pattern="" placeholder="多选则用-分隔 例：A-B-C" />
						</div>
					</div>
					<input type="submit" class="weui-btn weui-btn_primary" value="提交">
				</form:form>
			</div>
			<div id="tab2" class="weui-tab__bd-item">
				<form:form id="judege" commandName="command" action="addjudge"
					method="post" role="form">
					<div class="weui-cells__title">题干</div>
					<div class="weui-cells weui-cells_form">
						<div class="weui-cell">
							<div class="weui-cell__bd">
								<form:textarea path="content" class="weui-textarea"
									required="required" placeholder="请输入题干" rows="3"></form:textarea>
								<div class="weui-textarea-counter">
									<span>0</span>/200
								</div>
							</div>
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关科目</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="subject" class="weui-input" type="text"
								required="required" placeholder="相关科目" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关知识点</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="knowledgePoint" class="weui-input" type="text"
								required="required" placeholder="相关知识点" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">答案</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="answer" class="weui-input" type="text"
								required="required" pattern="" placeholder="T或F" />
						</div>
					</div>
					<input type="submit" class="weui-btn weui-btn_primary" value="提交">
				</form:form>
			</div>

			<div id="tab3" class="weui-tab__bd-item">
				<form:form id="blankfilling" commandName="command"
					action="addblankfilling" method="post" role="form">
					<div class="weui-cells__title">题干</div>
					<div class="weui-cells weui-cells_form">
						<div class="weui-cell">
							<div class="weui-cell__bd">
								<form:textarea path="content" class="weui-textarea"
									required="required" placeholder="请输入题干" rows="3"></form:textarea>
								<div class="weui-textarea-counter">
									<span>0</span>/200
								</div>
							</div>
						</div>
					</div>

					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关科目</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="subject" class="weui-input" type="text"
								required="required" placeholder="相关科目" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">相关知识点</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="knowledgePoint" class="weui-input" type="text"
								required="required" placeholder="相关知识点" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">答案</label>
						</div>
						<div class="weui-cell__bd">
							<form:input path="answer" class="weui-input" type="text"
								required="required" pattern="" placeholder="多个答案用空格分隔 例：列宁 马克思" />
						</div>
					</div>
					<input type="submit" class="weui-btn weui-btn_primary" value="提交">
				</form:form>
			</div>
			<div id="tab4" class="weui-tab__bd-item">
				<%@ include file="/WEB-INF/jsp/question/import.jsp"%>
			</div>
		</div>
	</div>

	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
