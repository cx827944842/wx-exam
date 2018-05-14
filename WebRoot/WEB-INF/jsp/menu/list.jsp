<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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

    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
		<%@ include file="/WEB-INF/jsp/public/menu.jspf" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        		<a href="${pageContext.request.contextPath }/s/menu/add">
	                        		<button type="button"  class="btn btn-primary">添加按钮</button>
	                        	</a>
	                        	<a href="${pageContext.request.contextPath }/s/menu/update">
	                        		<button type="button" onclick="create()" class="btn btn-default">同步到公众号</button>
	                        	</a>
								
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form id="form" method="post">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>键值</th>
                                        <th>名称</th>
                                        <th>url</th>
                                        <th>类型</th>
                                        <th>子按钮数</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                	
                                	<c:forEach items="${buttonList}" var="me">
                                	
	                                    <tr class="odd gradeX">
	                                        <td>
	                                        	<input type="checkbox" name="articleIds" value="${me.id }">
	                                        </td>
	                                        <td>${me.ekey}</td>
	                                        <td>${me.name}</td>
	                                        <td>${me.url}</td>
	                                        <td class="center">${me.type}</td>
	                                        <td class="center">${fn:length(me.subButtons)}</td>
	                                        <td>
	                                        	<a href="${pageContext.request.contextPath }/s/menu/subBut?id=${me.id}">
					                        		<button type="button"  class="btn btn-default">查看子按钮</button>
					                        	</a>
	                                        	<a href="${pageContext.request.contextPath }/s/menu/delete?id=${me.id}">
					                        		<button type="button" class="btn btn-danger">删除</button>
					                        	</a>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                           </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
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

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
