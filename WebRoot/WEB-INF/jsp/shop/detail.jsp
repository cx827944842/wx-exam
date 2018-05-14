<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,height=device-height, user-scalable=no,initial-scale=1, minimum-scale=1, maximum-scale=1">
<title>卫哥生鲜</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/spxq.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/swipe.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/touch.js"></script>

</head>
<body>
    <div class="body">
        <figure style="background-color:#FDFFFD;">
            <div class="addWrap">
                <div class="swipe" id="mySwipe">
                    <div class="swipe-wrap">
                        <div>
                            <a href="javascript:;"><img class="img-responsive" src="${pageContext.request.contextPath }/${item.imgUrl}" /></a>
                        </div>
                        <div>
                            <a href="javascript:;"><img class="img-responsive" src="${pageContext.request.contextPath }/${item.imgUrl}" /></a>
                        </div>
                        <div>
                            <a href="javascript:;"><img class="img-responsive" src="${pageContext.request.contextPath }/${item.imgUrl}" /></a>
                        </div>
                    </div>
                </div>
                <ul id="position">
                    <li class="cur"></li>
                    <li class=""></li>
                    <li class=""></li>
                </ul>
            </div>
            <!-- 轮播 -->
            <script src="${pageContext.request.contextPath }/js/swipe.js"></script>
            <script type="text/javascript">
            var bullets = document.getElementById('position').getElementsByTagName('li');
            var banner = Swipe(document.getElementById('mySwipe'), {
                auto: 3000,
                continuous: true,
                disableScroll: false,
                callback: function(pos) {
                    var i = bullets.length;
                    while (i--) {
                        bullets[i].className = ' ';
                    }
                    bullets[pos].className = 'cur';
                }
            });
            </script>
            <p style="padding-bottom:0.5rem">【热销精品】${item.name }</p>
            <div class="info" style="height:25px">
                <span class="sat" style="color:#FDFFFD;padding-left:10px;">￥${item.price }</span>
            </div>
        </figure>
        <div class="stock-detail" style="background-color:#FDFFFD;">
            <dl>
                <dt>运费:</dt>
                <dd class="js-postage-desc" data-postage="免运费">
                    免运费 </dd>
            </dl>
            <dl>
                <dt>剩余:</dt>
                <dd>55</dd>
            </dl>
        </div>
        <div class="js-store-info">
            <div style=" background-color:#F9F9F9;height:10px"></div>
            <div class="custom-store block-item " style="height:10px;margin-top:10px">
                <a class="custom-store-link clearfix" href="index.html">
                    <div class="custom-store-img"></div>
                    <div class="custom-store-name">
                        卫哥生鲜官方店 </div>
                    <span class="custom-store-enter">进入店铺 >> </span>
                </a>
            </div>
        </div>
        <div style="margin-top: 20px; background-color:#F9F9F9;height:10px"></div>
        <div class="" style="margin-top:10px;height:20px;" >
         <a href=" # ">
         <a href="${pageContext.request.contextPath }/s/shop/info?itemId=${item.id}">
         <span style = "float:left;margin-left:10px; ">查看商品详情</span> </a> 
         <span style = "float:right;margin-right:10px; ">>></span>
         </a>
         

               
                    </div>
                    
                     <div  style="margin-top: 10px; background-color:#F9F9F9;height:40px;text-align:center; "><p style="line-height:40px ">更多精选商品</p></div>
                     
                            
    <div class="sjxx " style="background-color:#F9F9F9; ">
    <div style="padding-left:2% ">
	    <c:forEach items="${items }" var="me" >
	    
	        <figure class="gengduo " style="border: none; background-color:#FDFFFD;">
	        <a href="${pageContext.request.contextPath }/s/shop/detail?itemId=${me.id}"><img src="${pageContext.request.contextPath }/${me.imgUrl}"style="height:170px; alt="商品 " class="xqtp "></a>
	        <p style="word-break:break-word; ">【热销精品】${me.name }</p>
	        <div class="info ">
	            <span class="sat ">￥${me.price }</span>
	        </div>
	    </figure>
	    </c:forEach>
    </div>
    <div style="margin-top:10px; background-color:#FDFFFD;height:40px;text-align:center;clear:both;"><p style="line-height:40px "><a href="${pageContext.request.contextPath }">进入店铺>></a></p></div>
    </div>
     
    <hr/>

    <div class="wx_nav " id="wx_nav ">
        <a href="${pageContext.request.contextPath }" class="nav_index " id="nav_index ">首页</a>
        <a href="javascript:; " class="nav_shopcart " id="nav_shopcart ">购物车</a>
        <a href="javascript:; " class="nav_me on " id="nav_me on ">订单</a>
    </div>
    </div>
</body>
</html>