<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>公众号后台管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	 <script type="text/javascript">
		  window.onload = function()
		  {		
			      CKEDITOR.replace( 'content');
		  };
  	</script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
		<%@ include file="/WEB-INF/jsp/public/menu.jspf" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">文章编辑</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	按钮信息
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form:form   action="add" method="post" role="form" >
                                        <div class="form-group">
                                            <label>键值</label>
                                            <form:input path="key" class="form-control"/>
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>名称</label>
                                             <form:input path="name" class="form-control"/>
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>url</label>
                                             <form:input path="url" class="form-control"/>
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>mediaId</label>
                                             <form:input path="mediaId" class="form-control"/>
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>父按钮</label>
                                            <form:select path="parent" class="form-control" >
                                               	<option></option>
                                               	<c:forEach items="${buttonList }" var="me">
                                         			<option value="${me.id }">${me.name}</option>      		
                                               	</c:forEach>
                                            </form:select>
                                        </div>
                                        
                                       <%--  <div class="form-group">
                                            <label>Selects</label>
                                            <form:select path="mediaId" class="form-control" >
                                               	<c:forEach items="${newsList }" var="me">
                                               		<option value="${me.mediaId }">${me.name}</option>
                                               	</c:forEach>
                                            </form:select>
                                        </div> --%>
                                        
                                        <div class="form-group">
                                            <label>Selects</label>
                                            <form:select path="type" class="form-control">
                                                <option value="">请选择类型</option>
                                                <option value="click">点击按钮</option>
                                                <option value="view">视图按钮</option>
                                                <option value="scancode_push">扫码按钮</option>
                                                <option value="scancode_waitmsg">扫码弹出</option>
                                                <option value="pic_sysphoto">相机按钮</option>
                                                <option value="pic_photo_or_album">图片按钮</option>
                                                <option value="pic_weixin">微信相册</option>
                                                <option value="location_select">位置按钮</option>
                                                <option value="media_id">图文按钮</option>
                                                <option value="view_limited">跳转图文</option>
                                            </form:select>
                                        </div>
                                    
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form:form>
                                </div>
                               
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>
