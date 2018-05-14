<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>试题</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<h1>${exam.course.name }课堂测验</h1>
	
	<form action="${pageContext.request.contextPath }/s/in/exam/answer" method="post">
		<input name="examid" type="hidden" value="${exam.id}">
		<c:forEach items="${list }" var="me" varStatus="vs">
		
			<!-- 选择题 -->
			<c:if test="${!empty me.bankChoiceQuestion}">
				<div class="weui-cells__title">${vs.count}. ${me.bankChoiceQuestion.content}</div>
				<div class="weui-cells weui-cells_checkbox">
						<!-- 选项是否存在 -->
						<c:if test="${!empty me.bankChoiceQuestion.choiceA}">
						<label class="weui-cell weui-check__label" for="s11${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="A"
									id="s11${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceA}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceB}">
						<label class="weui-cell weui-check__label" for="s12${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="B"
									id="s12${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceB}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceC}">
						<label class="weui-cell weui-check__label" for="s13${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="C"
									id="s13${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceC}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceD}">
						<label class="weui-cell weui-check__label" for="s15${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="D"
									id="s15${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceD}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceE}">
						<label class="weui-cell weui-check__label" for="s16${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="E"
									id="s16${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceE}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceF}">
						<label class="weui-cell weui-check__label" for="s17${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="F"
									id="s17${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceF}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceG}">
						<label class="weui-cell weui-check__label" for="s18${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="G"
									id="s18${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceG}</p>
							</div>
							</label>
						</c:if>
						
						<c:if test="${!empty me.bankChoiceQuestion.choiceH}">
						<label class="weui-cell weui-check__label" for="s19${me.id}">
							<div class="weui-cell__hd">
								<input  type="checkbox" class="weui-check" name="${me.id}" value="H"
									id="s19${me.id}" > <i class="weui-icon-checked"></i>
							</div>
							<div class="weui-cell__bd">
								<p>${me.bankChoiceQuestion.choiceH}</p>
							</div>
							</label>
						</c:if>
					
				</div>

			</c:if>
			
			<!--填空题  -->
			<c:if test="${!empty me.bankBlankFillingQuestion}">
				<div class="weui-cells__title">${vs.count}.${me.bankBlankFillingQuestion.content }</div>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">1.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer2 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">2.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer3 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">3.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer4 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">4.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer5 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">5.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer6 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">6.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer7 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">7.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>
					<c:if test="${!empty me.bankBlankFillingQuestion.answer8 }">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">8.</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" name="${me.id}">
						</div>
						</div>
					</c:if>

			</c:if>

			<!--判断题  -->
			<c:if test="${!empty me.bankJudgeQuestion}">
				<div class="weui-cells__title">${vs.count}.${me.bankJudgeQuestion.content}</div>
				<div class="weui-cells weui-cells_radio">
					<label class="weui-cell weui-check__label" for="x11${me.id}">
						<div class="weui-cell__bd">
							<p>对</p>
						</div>
						<div class="weui-cell__ft">
							<input type="radio" class="weui-check" value="T" name="${me.id}" id="x11${me.id}">
							<span class="weui-icon-checked"></span>
						</div>
					</label> <label class="weui-cell weui-check__label" for="x12${me.id}">

						<div class="weui-cell__bd">
							<p>错</p>
						</div>
						<div class="weui-cell__ft">
							<input type="radio" name="${me.id}" value="F" class="weui-check" id="x12${me.id}"
								checked="checked"> <span class="weui-icon-checked"></span>
						</div>
					</label>
				</div>

			</c:if>

		</c:forEach>

		<input type="submit" value="提交" class="weui-btn weui-btn_primary">

	</form>
	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
