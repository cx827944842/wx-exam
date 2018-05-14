<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>卫哥生鲜</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Up.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/touch.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/srcolltop.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/timer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xlmenu.js"></script>
    <script>
        $(function () {
            $("figure:eq(0)").css({
                border:'none'
            });
            $("figure:eq(1)").css({
                border:'none'
            });
                var titleName=$(".ycmenu a");
                for(var i =0;i<titleName.length;i++){
                titleName[i].id=i;
                titleName[i].onmouseover=function(){
                for(var j =0;j<titleName.length;j++){
                titleName[j].className="";
            }
                this.className = "a";
            }}
        })
    </script>
</head>
<body>
    <div class="container" style="background-color:#FDFFFD";>
        <div class="allLogo">
            <div class="logo"><img src="${pageContext.request.contextPath }/img/pingpai.jpg" alt="logo" /></div>
            <div class="head">
                <a href="javascript:;"><img src="${pageContext.request.contextPath }/img/touxiang.jpg" alt="头像" /></a>
            </div>
            <div class="headInfo"><strong><a href="#" style="font-size:18px;">卫哥生鲜</a></div></strong>
            </div>
            <div class="SeckillOne" style="background-color:#F9F9F9;">
                <div>
                    <img src="${pageContext.request.contextPath }/img/zhaopai.png" alt="">
                </div>
                <div class="number">
                    <p>已抢 125 份 剩余 30 份</p>
                </div>
            </div>
            <div class="clear"></div>
            <div class="border">
            </div>
            <div class="allsp" style="background-color:#F9F9F9;">
            	<c:forEach items="${tagList }" var="me">
	                <div style="clear:both;padding-top:2%;padding-left:2%">
	                    <p style="margin-bottom:10px"><span style="color: rgb(227, 108, 9);"><strong><span style="font-size: 18px;">${me.name }</span></strong>
	                        </span>
	                    </p>
	                    <c:forEach items="${me.items }" var="m">
		                    <figure style="background-color:#FDFFFD;">
		                        <a href="${pageContext.request.contextPath }/s/shop/detail?itemId=${m.id}"><img src="${pageContext.request.contextPath }/${m.imgUrl }" style="height:170px;" alt="商品" class="xqtp" /></a>
		                        <p style="word-break:break-word;">${m.name }</p>
		                        <div class="info">
		                            <em class="sat">￥${m.price }</em>
		                        </div>
		                    </figure>
	                    </c:forEach>
	                   
	                </div>
            	</c:forEach>
      
                <div style="margin-top: 10px; background-color:#FDFFFD;height:40px;text-align:center;clear:both;">
                    <p style="line-height:40px"><a href="${pageContext.request.contextPath }/s/shop/all">查看更多商品>></a></p>
                </div>
                <div class="clear"></div>
                <br/>

            </div>
            <br/>
            <br/>
            <div class="wx_nav" id="wx_nav">
                <a href="${pageContext.request.contextPath }" class="nav_index" id="nav_index">首页</a>
                <a href="javascript:;" class="nav_shopcart" id="nav_shopcart">购物车</a>
                <a href="javascript:;" class="nav_me on" id="nav_me on">订单</a>
            </div>
        </div>
        <footer>
            <div class="footer">
            </div>
        </footer>
        <div class="actGotop">
            <a href="javascript:;" title="返回顶部"></a> <img src="${pageContext.request.contextPath }/img/fanhui.png" alt=""></div>
        <div class="theme-popover-mask"></div>
</body>

</html>