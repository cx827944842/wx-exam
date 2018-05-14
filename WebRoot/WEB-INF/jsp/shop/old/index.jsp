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
    <div class="container">
        <div class="allLogo">
            <div class="logo"><img src="${pageContext.request.contextPath }/img/pingpai.jpg" alt="logo" /></div>
            <div class="head">
                <a href="javascript:;"><img src="${pageContext.request.contextPath }/img/touxiang.jpg" alt="头像" /></a>
            </div>
            <div class="headInfo"><strong><a href="#" style="font-size:18px;">卫哥生鲜</a></div></strong>
            </div>
            <div class="SeckillOne">
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
            <div class="allsp" style="background-color:#EEEEEE;">
            	<c:forEach items="${tagList }" var="me">
	                <div style="clear:both;padding-top:2%;padding-left:2%">
	                    <p style="margin-bottom:10px"><span style="color: rgb(227, 108, 9);"><strong><span style="font-size: 18px;">${me.name }</span></strong>
	                        </span>
	                    </p>
	                    <c:forEach items="${me.items }" var="m">
		                    <figure style="background-color:white;">
		                        <a href="${pageContext.request.contextPath }/s/shop/detail?itemId=${m.id}"><img src="${pageContext.request.contextPath }/${m.imgUrl }" style="height:170px;" alt="商品" class="xqtp" /></a>
		                        <p style="word-break:break-word;">${m.name }</p>
		                        <div class="info">
		                            <em class="sat">￥${m.price }</em>
		                        </div>
		                    </figure>
	                    </c:forEach>
	                   
	                </div>
            	</c:forEach>
      
                <div style="margin-top: 10px; background-color:white;height:40px;text-align:center;clear:both;">
                    <p style="line-height:40px"><a href="${pageContext.request.contextPath }/s/shop/all">查看更多商品>></a></p>
                </div>
                <div class="clear"></div>
                <br/>
                <div class="intro" style="background-color:white;">
                    <div style="padding:3%">
                        <p><span style="font-size: 18px;"><strong>公司介绍：</strong></span></p>
                        <br/>
                        <p><strong></strong>
                            <span style="font-family: 微软雅黑; font-size: 14px;">&nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size:20px">卫</strong>哥生鲜是一家成立于2016年的生鲜直销公司，由几个热爱生活，热爱美食的年轻人组成，他们中既有美食达人，又有美女厨娘，还有营养专家，做到把深海的美味引入川渝，让个个爱吃火锅人们吃上优质的海鲜。卫哥生鲜所有产品均采取远洋捕捞，现场冷鲜，快速发货，一站式社区服务，解决用户所有味蕾的需求，提倡快捷、新鲜、营养、美味。我们立足北部湾，面对南中国海。我们货源稳定，优势明显，与多家渔业上市公司有战略合作伙伴，我们还与当地渔民有合作，每天直接从渔民手中收货，保证新鲜，我们直接将海鲜送达用户，免去其他中间环节，让用户手上的海鲜质高价低，真正做到新鲜自供社区，鲜货日售罄，库存于大海。同时我们还经常进行线下活动，成为我们的会员，定期开展新品种试吃，厨艺大比拼，健康宝宝美食、组成海岛旅游等活动，让大家因为美食感受爱，因为爱相聚一堂。</span></p>
                        <p><span style="font-family: 微软雅黑;
    font-size: 14px;"><br/>&nbsp;&nbsp;&nbsp;&nbsp;我们优势产品：深海金鲳鱼（文莱王室贡品），野生大虾，北海鱿鱼、野生金丝鱼。。。。。</span></p>
                    </div>
                </div>
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