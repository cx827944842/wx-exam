<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>课堂测验数据</title>
<!-- head 中 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
<script type="text/javascript">
	window.onload = function() {
		var chart = new CanvasJS.Chart("chartContainer", {
			title:{
				text: "学生正确率分布表"
			},
			legend: {
				maxWidth: 350,
				itemWidth: 120
			},
			data: [
			{
				type: "pie",
				showInLegend: true,
				legendText: "{indexLabel}",
				dataPoints: [
					{ y: ${result.range40}, indexLabel: "正确率低于40%人数" },
					{ y: ${result.range60}, indexLabel: "正确率处于40%~60%人数" },
					{ y: ${result.range80}, indexLabel: "正确率处于60%~80%人数" },
					{ y: ${result.range90}, indexLabel: "正确率高于80%人数"},
				]
			}
			]
		});
		chart.render();
		
		var chart2 = new CanvasJS.Chart("chartContainer2",
			    {
		      title:{
		        text: "各题正确率统计表"
		      },
		      data: [

		      {
		        dataPoints: [
	        	<c:forEach items="${examlist}" var="me" varStatus="vs">
			        { x: ${vs.count}, y: ${me.rate}, label: "第${vs.count}题"},
	            </c:forEach>
		        
		        ]
		      }
		      ]
		    });

		chart2.render();
	}
</script>
<script type="text/javascript"
	src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</head>
<body>
	<h1>课堂测验数据</h1>

	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<div id="chartContainer2" style="height: 300px; width: 100%;">
		<!-- body 最后 -->
		<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
		<script
			src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
