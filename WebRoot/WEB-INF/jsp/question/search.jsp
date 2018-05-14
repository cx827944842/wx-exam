<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>题库检索</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

</head>
<body>
	<div class="weui-tab">

		<!-- 页面主体 -->
		<div class="weui-tab__bd">

			<div id="tab1" class="weui-tab__bd-item ${empty tag ?'weui-tab__bd-item--active':'' }">
				<div class="weui-search-bar" id="searchBar">
					<form id="pageForm" class="weui-search-bar__form"
						action="${pageContext.request.contextPath}/s/in/question/search"
						method="post">

						<div class="weui-search-bar__box">
							<i class="weui-icon-search"></i> <input type="search"
								name="keyword" value="${keyword }"
								class="weui-search-bar__input" id="searchInput" placeholder="搜索"
								required=""> <a href="javascript:"
								class="weui-icon-clear" id="searchClear"></a>
						</div>
						<label class="weui-search-bar__label" id="searchText"> <i
							class="weui-icon-search"></i> <span>搜索</span>
						</label>
					</form>
					<a href="javascript:document:pageForm.submit()" class=""
						id="searchCancel"><i class="weui-icon-search"></i></a>
				</div>
				<!-- 搜索列表 -->
				<c:if test="${!empty pageBean}">

					<!-- 题目展示模块 -->
					<c:forEach items="${pageBean.recordList}" var="me">
						<br>
						<div class="weui-form-preview">
							<%-- <div class="weui-form-preview__hd">
								<label class="weui-form-preview__label">题型</label> <em
									class="weui-form-preview__value">${me.type }</em>
							</div> --%>
							<div class="weui-form-preview__bd">
								<div class="weui-form-preview__item">
									<label class="weui-form-preview__label">题型:</label> <span
										class="weui-form-preview__value">${me.type}</span>
								</div>
								<div class="weui-form-preview__item">
									<label class="weui-form-preview__label">相关科目:</label> <span
										class="weui-form-preview__value">${me.subject}</span>
								</div>
								<div class="weui-form-preview__item">
									<label class="weui-form-preview__label">相关知识点:</label> <span
										class="weui-form-preview__value">${me.knowledgePoint }</span>
								</div>
								<div class="weui-form-preview__item">
									<label class="weui-form-preview__label">题干:</label> <span
										class="weui-form-preview__value">${me.content }</span>
								</div>
							</div>
							<div class="weui-form-preview__ft">
								<a
									class="weui-form-preview__btn weui-form-preview__btn_default open-popup"
									data-target="#que${me.id }" href="javascript:">查看详情</a>
								<button type="submit" onclick="addDraft(${me.id})"
									class="weui-form-preview__btn weui-form-preview__btn_primary"
									href="javascript:">加入出题区</button>
							</div>
							<!-- 题目详情窗口 -->
							<div id="que${me.id }" class='weui-popup__container'>
								<div class="weui-popup__overlay"></div>
								<div class="weui-popup__modal">
									<header class='demos-header'>
										<h2 class="demos-second-title">题目详情</h2>
										<p class="demos-sub-title">By ${me.contributor } @${me. createDate}</p>
									</header>
									<article class="weui-article">
										<section>
											<h2 class="title">科目：${me.subject }</h2>
											<h2 class="title">知识点：${me.knowledgePoint }</h2>
											<h2 class="title">题目描述:${me.description }</h2>
											<h2 class="title">题目类型：${me.type }</h2>
											<h2 class="title">答案：
												<c:if test="${me.type=='填空题'}">
													${me.answerStr }
												</c:if>
												<c:if test="${me.type!='填空题'}">
													${me.answer}
												</c:if>
											</h2>
											<section>
												<h3>题干</h3>
												<p>${me.content }</p>
												<p>
													 <c:if test="${me.type=='选择题'}">
													 	<%-- ${me.fullContent} --%>
														<c:if test="${!empty me.choiceA}">${me.choiceA}<br>
														</c:if>
														<c:if test="${!empty me.choiceB}">${me.choiceB}<br>
														</c:if>
														<c:if test="${!empty me.choiceC}">${me.choiceC}<br>
														</c:if>
														<c:if test="${!empty me.choiceD}">${me.choiceD}<br>
														</c:if>
														<c:if test="${!empty me.choiceE}">${me.choiceE}<br>
														</c:if>
														<c:if test="${!empty me.choiceF}">${me.choiceF}<br>
														</c:if>
														<c:if test="${!empty me.choiceG}">${me.choiceG}<br>
														</c:if>
														<c:if test="${!empty me.choiceH}">${me.choiceH}<br>
														</c:if>
													</c:if>  
												</p>
											</section>
											
										</section>
									</article>
									<a href="javascript:;"
										class="weui-btn weui-btn_primary close-popup">关闭</a> <br>
									<br> <br>
								</div>
							</div>
						</div>
						<br>
					</c:forEach>
					<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
					<div>
						<br> <br>
					</div>
				</c:if>

				<!-- 未搜索首页 搜索规则说明 -->
				<c:if test="${empty pageBean}">
					<div class="weui-msg">
						<div class="weui-msg__icon-area">
							<i class="weui-icon-info weui-icon_msg"></i>
						</div>
						<div class="weui-msg__text-area">
							<h2 class="weui-msg__title">题库搜索规则：</h2>
							<p class="weui-msg__desc">
								内容详情，可根据实际需要安排，如果换行则不超过规定长度，居中展现<a href="javascript:void(0);">文字链接</a>
							</p>
						</div>

					</div>

				</c:if>
			</div>

			<div id="tab2" class="weui-tab__bd-item ${tag eq 'draft'?'weui-tab__bd-item--active':'' }">
				<!-- 出题区无内容提示 -->
				<c:if test="${empty sessionScope.draft}">
					<div class="weui-msg">
						<div class="weui-msg__icon-area">
							<i class="weui-icon-info weui-icon_msg"></i>
						</div>
						<div class="weui-msg__text-area">
							<h2 class="weui-msg__title">出题区是空的：</h2>
							<p class="weui-msg__desc">
								请从题库中添加题目到出题区中！<a href="javascript:void(0);">文字链接</a>
							</p>
						</div>

					</div>

				</c:if>

				<!-- 题目展示模块 -->
				<c:if test="${!empty sessionScope.draft}">
					<a href="${pageContext.request.contextPath}/s/in/exam/oncreate"
						class="weui-btn weui-btn_primary">生成课堂测验</a>
					<c:forEach items="${sessionScope.draft}" var="me">
						<div id="draft_${me.id }" class="weui-form-preview">
							<div class="weui-form-preview__hd">
								<label class="weui-form-preview__label">题型</label> <em
									class="weui-form-preview__value">${me.type }</em>
							</div>
							<div class="weui-form-preview__bd" style="text-align: left;">
								${me.content}<br>
								<c:if test="${me.type=='选择题'}">
									<c:if test="${!empty me.choiceA}">${me.choiceA}<br>
									</c:if>
									<c:if test="${!empty me.choiceB}">${me.choiceB}<br>
									</c:if>
									<c:if test="${!empty me.choiceC}">${me.choiceC}<br>
									</c:if>
									<c:if test="${!empty me.choiceD}">${me.choiceD}<br>
									</c:if>
									<c:if test="${!empty me.choiceE}">${me.choiceE}<br>
									</c:if>
									<c:if test="${!empty me.choiceF}">${me.choiceF}<br>
									</c:if>
									<c:if test="${!empty me.choiceG}">${me.choiceG}<br>
									</c:if>
									<c:if test="${!empty me.choiceH}">${me.choiceH}<br>
									</c:if>
								</c:if>
							</div>
							<div class="weui-form-preview__ft">
								<button type="submit" onclick="delDraft(${me.id})"
									class="weui-form-preview__btn weui-form-preview__btn_primary"
									href="javascript:">从出题区中删除</button>
							</div>
						</div>
					</c:forEach>
					<br>
					<br>
				</c:if>

			</div>

		</div>

		<!-- 页面底部导航 -->
		<div class="weui-tabbar"
			style="width: 100%; position: fixed; left: 0; bottom: 0;">
			<a href="#tab1" class="weui-tabbar__item ${empty tag?'weui-bar__item--on':'' }">
				<div class="weui-tabbar__icon">
					<img
						src="${pageContext.request.contextPath}/img/icon_nav_article.png"
						alt="">
				</div>
				<p class="weui-tabbar__label">公共题库</p>
			</a>
			<%-- <a href="#tab2" class="weui-tabbar__item">
				<div class="weui-tabbar__icon">
					<img
						src="${pageContext.request.contextPath}/img/icon_nav_button.png"
						alt="">
				</div>
				<p class="weui-tabbar__label">我的题库</p>
			</a>  --%>
			<a href="#tab2" class="weui-tabbar__item ${tag eq 'draft'?'weui-bar__item--on':'' }">
				<div class="weui-tabbar__icon">
					<img src="${pageContext.request.contextPath}/img/icon_nav_cell.png"
						alt="">
				</div>
				<p class="weui-tabbar__label">待出题区</p>
			</a>
		</div>
	</div>


	<!-- end: JavaScript-->
	<script type="text/javascript">
		
		function addDraft(id) {
			$.ajax({
				url : './addDraft?id=' + id,
				type : 'POST',
//				data : $(document.form1).serialize(),
				success : function(data) {
					if (data != 'ng') {
						$("#tab2").html(data);
						$.toptip('操作成功', 'success');
					} else
						$.toptip('请勿重复添加', 'warning');

				},
				error : function() {
					$.toptip('服务器错误', 'error');
				}
			});
		}
		function delDraft(id) {
			$.ajax({
				url : './delDraft?id=' + id,
				type : 'POST',
//				data : $(document.form1).serialize(),
				success : function(data) {
					if (data == 'ng') {
						$.toptip('错误操作', 'warning');
					} else{
						if(data!=''){
							$("#tab2").html(data);
						}else{
							$("#draft_"+id).remove();
						}
						$.toptip('操作成功', 'success');
					}

				},
				error : function() {
					$.toptip('服务器错误', 'error');
				}
			});
		}
	</script>


	<!-- body 最后 -->
	<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
