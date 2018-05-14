<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>商品详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/spdd.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/tcewm.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/touch.js"></script>
</head>
<body>
<div class="body" style="background-color:#F9F9F9">
    <div class="tour">
        <a href="javascript:history.go(-1)" class="tour1"><img src="${pageContext.request.contextPath }/img/back.png" alt="" style="height: 26px;width: 20px"></a>
        <p>商品详情</p>
    </div>

   
    <div class="hbt" style="width: 100%;height: 1rem;background-color:#F9F9F9; "></div>

    <div class="zfdd">
	${description }



   
        <div style="clear: both"></div>
    </div>


   
   <div class="zshlogo">
           
        </div>
    <div class="wx_nav" id="wx_nav">
        <a href="${pageContext.request.contextPath }" class="nav_index" id="nav_index">首页</a>
        <a href="javascript:;" class="nav_shopcart" id="nav_shopcart">购物车</a>
        <a href="javascript:;" class="nav_me" id="nav_me on">订单</a>
    </div>
</div>
<div class="dewm">
<div>
 <div style="margin: 0 auto;text-align: center;padding: 0.5rem 0 0.5rem 0;font-weight: bolder;font-size:1.3rem;width: 200px;background-color:#ffffff">æ¶è´¹ç :1234 4567 8901</div>
    <img src="img/erweima.jpg" alt="æ¶è´¹äºç»´ç " style="width: 200px;height: 200px;margin: 0 auto;background-color:red"/>
    <div style="margin: 0 auto;text-align: center;padding: 0.5rem 0 0.5rem 0;white-space: nowrap;font-size:1.3rem;width: 200px;background-color:#ffffff">è¯·åºç¤ºè®¢åäºç»´ç ï¼ç»åå®¶æ«æ</div>
</div>
   
</div>
<div class="theme-popover-mask"></div>
</body>
</html>