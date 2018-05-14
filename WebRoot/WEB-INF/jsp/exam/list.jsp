<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>课堂测验</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<c:if test="${empty list }">
		<div class="weui-msg">
			<div class="weui-msg__icon-area">
				<i class="weui-icon-info weui-icon_msg"></i>
			</div>
			<div class="weui-msg__text-area">
				<h2 class="weui-msg__title">当前课程没有测验。</h2>
				<p class="weui-msg__desc"></p>
			</div>

		</div>
	</c:if>

	<c:if test="${!empty list }">
		<c:forEach items="${list }" var="me">
			<div class="weui-form-preview">
				<div class="weui-form-preview__hd">
					<label class="weui-form-preview__label">测验名称</label> <em
						class="we ui-form-preview__value">${empty me.name?'无题':me.name}</em>
				</div>
				<div class="weui-form-preview__bd">
					<div class="weui-form-preview__item">
						<label class="weui-form-preview__label">所属课程</label> <span
							class="weui-form-preview__value">${me.course.name}</span>
					</div>
					 <div class="weui-form-preview__item">
						<label class="weui-form-preview__label">创建时间</label> <span
							class="weui-form-preview__value">${me.createDate }</span>
					</div>
					<div class="weui-form-preview__item">
						<label class="weui-form-preview__label">测验时间</label> <span
							class="weui-form-preview__value">${me.examDate }</span>
					</div>
				</div>
				<!-- 学生操作 -->
				<c:if test="${sessionScope.user.role==0 }">

					<div class="weui-form-preview__ft">

						<c:if test="${!me.opened }">
							<button type="submit"
								class="weui-form-preview__btn weui-form-preview__btn_primary"
								href="javascript:">查看错题</button>
						</c:if>
					</div>
				</c:if>
				<!-- 老师操作 -->
				<c:if test="${sessionScope.user.role==1 }">
					<div class="weui-form-preview__ft">
						<c:if test="${me.opened}">
							<a id="close_${me.id }"
								class="weui-form-preview__btn weui-form-preview__btn_default"
								href="javascript:close(${me.id })">关闭测试</a>
						</c:if>

						<a 
							class="weui-form-preview__btn weui-form-preview__btn_primary"
							href="${pageContext.request.contextPath }/s/in/exam/result?examId=${me.id}">查看测试数据</a>
					</div>
				</c:if>
			</div>

		</c:forEach>
	</c:if>


	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
	<script type="text/javascript">
		function close(id) {
			$.ajax({
				url : './close?examId=' + id,
				type : 'POST',
				//			data : $(document.form1).serialize(),
				success : function(data) {
					if (data == 'ng') {
						$.toptip('错误操作', 'warning');
					} else {
						$("#close_" + id).remove();
						$.toptip('操作成功', 'success');
					}

				},
				error : function() {
					$.toptip('服务器错误', 'error');
				}
			});
		}
	</script>
</body>
</html>
