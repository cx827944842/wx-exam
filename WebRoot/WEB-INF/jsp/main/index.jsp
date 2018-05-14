<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="" lang="zh-cmn-Hans">

<head>
    <meta charset="utf-8">
    <meta name="keywords" content="有赞,有赞商城,有赞微商城,移动零售,微信商城,大流量,更好玩" />
    <meta name="description" content="有赞定位为移动零售服务商！有赞微商城，面向线下实体商家和线上传统电商进行服务，有完整的客户管理和在线营销解决方案，以及客户管理+在线营销+硬件接入+开放数据等强大的功能。且有大流量定期专场活动，百万免费流量支持。
有赞平台还拥有超过百项特色功能，丰富有趣的营销应用，精准的数据分析等，是您加入移动互联网进行零售升级的新契机！" />
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="cleartype" content="on">
    <meta name="referrer" content="always">
    <link rel="shortcut icon" href="https://b.yzcdn.cn/v2/image/yz_fc.ico" />
    <title>獐子岛集团官方旗舰店- 獐子岛集团官方旗舰店</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script>
    ! function(e) {
        e.onReady = function(t, r) {
            if (r) {
                var o = function() {
                    e[t] ? r() : setTimeout(function() {
                        o(t, r)
                    }, 500)
                };
                o(t, r)
            }
        };
        var t = /complete|loaded/;
        e.afterLoad = function(r) {
            t.test(document.readyState) && document.body ? setTimeout(r) : e.addEventListener("load", r, !1)
        }
    }(window),
    function(e) {
        function t(e) {
            var t = e.match(/(https?:)?\/\/(.*?)\/.*/);
            return t ? t[2] : "ABCDEXWGFGHXWGIJKXWGLMNOPQRSTUHAHAHA"
        }

        function r(e) {
            var t = 0 === l.indexOf(e) ? 1 : 0;
            return l[t]
        }

        function o(e) {
            return -1 !== l.concat("static.koudaitong.com").indexOf(e)
        }

        function n(t, r) {
            if (e.TraceKit) try {
                throw new a(t, r)
            } catch (o) {
                e.TraceKit.report(o)
            } else e.StackTraceLogger ? e.StackTraceLogger.log({
                appName: "jserror-iron-front",
                logIndex: "www",
                level: "info",
                name: "CdnRequestError",
                message: " error url: " + t + ", isSecondTime: " + r
            }) : (new Image).src = "//tj.koudaitong.com/1.gif?net_error=1&fileurl=" + t
        }

        function a(e, t) {
            this.name = "CdnRequestError", this.message = "error url: " + e + ", isSecondTime: " + t, this.stack = (new Error).stack
        }
        var i, c = {
                script: "src",
                link: "href"
            },
            l = ["b.yzcdn.cn", "su.yzcdn.cn"];
        e._cdnFallback = function(a) {
            var l, d, f, s, u, g, m, p;
            if (l = a.nodeName.toLowerCase(), d = c[l], d && (f = s = a[d])) {
                var h = t(f);
                if (o(h)) {
                    f = f.replace(h, r(h)), u = a.getAttribute("data-fallbacked"), u || (g = document, m = g.head || g.getElementsByTagName("head")[0] || g.documentElement, p = g.createElement(l), "link" === l && (p.rel = "stylesheet"), p[d] = f, p.onerror = function() {
                        e._cdnFallback(p)
                    }, p.setAttribute("data-fallbacked", 1), m.appendChild(p));
                    var y = !i && u;
                    y && (e.motify && e.motify.error && e.motify.error("啊哦，有东西加载失败了，刷新下试试~"), i = !0), Math.random() <= .05 && n(s, u)
                }
            }
        }, a.prototype = new Error, a.prototype.constructor = a
    }(window),
    function(e) {
        "use strict";
        var t;
        e.localStorage;
        try {
            var r = new Date;
            try {
                localStorage.setItem(r, r)
            } catch (o) {
                if (22 === o.code) throw "localstorage define error"
            }
            var n = localStorage.getItem(r) == r;
            if (localStorage.removeItem(r), !n) throw "localstorage define error";
            if ("FUNCTION" != (typeof localStorage.clear).toUpperCase()) throw "localstorage define error";
            t = localStorage
        } catch (o) {
            var a = function() {
                return null
            };
            t = {
                getItem: a,
                setItem: a,
                removeItem: a,
                clear: a
            }
        }
        "function" == typeof define && define.amd && define(function() {
            return t
        }), e.YZLocalStorage = t
    }(window),
    function(e) {
        e.motify = e.motify || {
            error: function(e) {
                setTimeout(function() {
                    document.body.insertAdjacentHTML("afterbegin", '<div style="color:red;padding:5px;background:#fff;font-size:12px;border-bottom:1px solid #ddd;margin-bottom:5px;"><a style="border-radius:3px;line-height:18px;text-align:center;float:right;margin-left:5px;padding:4px 7px;color:#fff;background-color:#00BF05;" onclick="location.reload();">刷新</a> <p style="line-height:28px;padding-right:53px;word-break:break-all;margin:0;">' + e + "</p></div>")
                }, 500)
            }
        }, e.zenjs = e.zenjs || {}, e.__logs = [], e.Logger = {
            log: function(t) {
                e.__logs.push(t)
                }
        }
    }(window);
    </script>
    <link rel="stylesheet" href="https://b.yzcdn.cn/v2/build_css/stylesheets/wap/base_d3780650386f4829db01fc7236f7abe2.css" onerror="_cdnFallback(this)" media="screen">
    <link rel="stylesheet" href="https://b.yzcdn.cn/v2/build_css/stylesheets/wap/projects/showcase_with_components_84f59f3442e13dd4bb38db3fe7eecca8.css" onerror="_cdnFallback(this)" media="screen">
    <style>
    .content {
        background-color: #f9f9f9;
    }
    </style>
    <script>
    var _global = {
        "kdt_id": 1525577,
        "user_id": 0,
        "run_mode": "online",
        "debug": false,
        "project": "default",
        "online_debug": false,
        "js": {
            "js_compress": true,
            "css_compress": true,
            "use_js_cdn": true,
            "use_css_cdn": true,
            "message_report": true,
            "checkbrowser": true,
            "hide_wx_nav": true,
            "qn_public": "kdt_img",
            "qn_private": "kdt-private"
        },
        "query_path": "\/showcase\/homepage",
        "query_key": "common%2Furl%2Fcreate=&kdt_id=1525577&scan=3&from=singlemessage",
        "real_query_path": "get:\/showcase\/homepage\/index.html",
        "module": "showcase",
        "controller": "Showcase_Homepage_Controller",
        "action": "index",
        "full_action": "getIndexHtml",
        "method": "get",
        "format": "html",
        "offline_id": 0,
        "platform": "unknown",
        "is_mobile": false,
        "authorize": "unknown",
        "platform_version": "unknown",
        "mobile_system": "unknown",
        "youzan_app_login": false,
        "page_size": 320,
        "isShopDomain": false,
        "share": {
            "title": "\u53d1\u73b0\u4e00\u5bb6\u597d\u5e97\uff1a\u7350\u5b50\u5c9b\u96c6\u56e2\u5b98\u65b9\u65d7\u8230\u5e97",
            "desc": "\u7504\u9009\u5168\u7403\u9ad8\u54c1\u8d28\u6d77\u9c9c",
            "cover": "http:\/\/dn-kdt-img.qbox.me\/upload_files\/2015\/04\/24\/Fh3PysOvhUEkt79zuEka-CM_rsMY.jpg",
            "link": "https:\/\/shop1717745.koudaitong.com\/v2\/showcase\/homepage?common%2Furl%2Fcreate=&kdt_id=1525577&scan=3&from=singlemessage&oid=0"
        },
        "jsBradgeSupport": true,
        "wuxi1_0_0": false,
        "source": "kdt.qr.url.none",
        "track": "",
        "nobody": "n21uj24stsjs0o0b7ca947ajm5",
        "mp_changed": true,
        "team_certificate": true,
        "is_secured_transactions": 1,
        "hide_shopping_cart": 0,
        "hide_top_bar": 0,
        "mp_data": {
            "logo": "http:\/\/dn-kdt-img.qbox.me\/upload_files\/2015\/04\/24\/Fh3PysOvhUEkt79zuEka-CM_rsMY.jpg",
            "team_name": "\u7350\u5b50\u5c9b\u96c6\u56e2\u5b98\u65b9\u65d7\u8230\u5e97",
            "intro": "\u7504\u9009\u5168\u7403\u9ad8\u54c1\u8d28\u6d77\u9c9c",
            "is_display_footbar": "1",
            "is_display_suffix_name": "1",
            "suffix_name": "\u7350\u5b50\u5c9b\u96c6\u56e2\u5b98\u65b9\u65d7\u8230\u5e97",
            "shopping_cart_style": "2",
            "team_type": "youzan",
            "mobile": "",
            "team_physical": 0,
            "copyright_pic_url": "",
            "mp_id": "332845",
            "kdt_id": "1525577",
            "mp_weixin": "zhangzidao2014",
            "mp_nickname": "\u7350\u5b50\u5c9b",
            "tmp_token": "",
            "quick_subscribe": "1",
            "quick_subscribe_url": "http:\/\/mp.weixin.qq.com\/s?__biz=MzA4NTU5MTYwOA==&mid=401875000&idx=1&sn=861c5f5b45afe44a4a06d2e91b954080"
        },
        "wxpay_big": false,
        "alipay_env": true,
        "wxpay_env": false,
        "wxaddress_env": false,
        "is_owner_team": false,
        "weixin_jssdk_use": 1,
        "mp_id": 0,
        "isWishOpen": 0,
        "wishUrl": "https:\/\/trade.koudaitong.com\/wxpay\/wish?kdt_id=1525577",
        "directSeller": {
            "is_display_directseller_button": false
        },
        "fans_id": 0,
        "is_fans": 2,
        "fans_nickname": "",
        "fans_type": 0,
        "fans_token": "",
        "fans_picture": "",
        "youzan_fans_id": 0,
        "youzan_fans_nickname": "",
        "youzan_fans_picture": "",
        "youzan_user_id": 0,
        "no_user_login": true,
        "buyer_id": 0,
        "change_password_url": "",
        "buyer": {
            "id": 0,
            "phone": ""
        },
        "open_token": [],
        "showcase_type": "homepage",
        "have_goods": true,
        "homepage_template": "",
        "spm": {
            "logType": "f",
            "logId": 37119796
        },
        "alias": "1c4zi10er",
        "city_name": "\u6842\u6797",
        "ajaxURL": [],
        "no_sidebar": 0,
        "url": {
            "base": "\/\/koudaitong.com",
            "bbs": "http:\/\/bbs.youzan.com",
            "cdn": "\/\/b.yzcdn.cn",
            "cdn_static": "https:\/\/b.yzcdn.cn\/v2",
            "cp": "http:\/\/cp.koudaitong.com",
            "daxue": "http:\/\/xuetang.youzan.com",
            "fenxiao": "\/\/fx.youzan.com",
            "fuwu": "\/\/fuwu.youzan.com",
            "img": "\/\/img.koudaitong.com",
            "imgqn": "https:\/\/img.yzcdn.cn",
            "login": "\/\/login.youzan.com",
            "open": "\/\/open.koudaitong.com",
            "static": "https:\/\/static.koudaitong.com\/v2",
            "trade": "https:\/\/trade.koudaitong.com",
            "v1": "http:\/\/koudaitong.com\/v1",
            "v1_static": "\/\/static.koudaitong.com\/v1",
            "v2": "\/\/koudaitong.com\/v2",
            "wap": "https:\/\/h5.koudaitong.com\/v2",
            "ws": "ws:\/\/s.im.youzan.com:83",
            "www": "\/\/koudaitong.com\/v2",
            "youzan": "\/\/youzan.com",
            "cloud": "http:\/\/dl.koudaitong.com",
            "pf": "https:\/\/pf.koudaitong.com",
            "uic": "https:\/\/uic.koudaitong.com",
            "store": "\/\/store.youzan.com",
            "market": "https:\/\/pfmarket.koudaitong.com",
            "materials": "\/\/materials.koudaitong.com"
        }
    };
    </script>
</head>

<body class=" ">
    <div class="container ">
        <div class="header">
        </div>
        <div class="content ">
            <div class="content-body js-page-content">
                <!-- 图片广告 -->
                <div class="custom-image-single clearfix">
                    <a href="javascript:void(0);">
                        <img class="js-res-load js-view-image-item" src="https://img.yzcdn.cn/upload_files/2016/02/25/FqqendSnnr3n-DLbH8c92NTUObu2.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                    </a>
                </div>
                <!-- 商品搜索 -->
                <div class="custom-search">
                    <form action="https://h5.koudaitong.com/v2/search" method="GET">
                        <input type="text" class="custom-search-input" name="q" placeholder="搜索商品" value="">
                        <input type="hidden" name="kdt_id" value="1525577">
                        <button type="submit" class="custom-search-button">搜索</button>
                    </form>
                </div>
                <!-- 图片广告 -->
                <div class="custom-image-swiper js-swp swp">
                    <div class="swiper-wrapper js-swp-wrap js-view-image-list" style="height: 150px;" data-height="150">
                        <a class="swp-page" href="https://wap.koudaitong.com/v2/showcase/goods?alias=5za17aah">
                            <img class="js-res-load " src="https://img.yzcdn.cn/upload_files/2016/03/04/Fiv9fGngWOAZfZkv81fjrXD9-tYE.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                        </a>
                        <a class="swp-page" href="https://wap.koudaitong.com/v2/showcase/goods?alias=cb2yz6yi">
                            <img class="js-res-load " data-src="https://img.yzcdn.cn/upload_files/2016/03/04/FtaOj0-vBGFeks_wxODy0CTktwP5.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                        </a>
                    </div>
                    <div class="swiper-pagination js-swiper-pagination"></div>
                </div>
                <script id="resize-img-script">
                ! function() {
                    for (var e = document.getElementById("resize-img-script"), i = e.previousSibling; 1 != i.nodeType;) i = i.previousSibling;
                    var t = i.clientWidth,
                        r = i.querySelector(".js-swp-wrap"),
                        n = Math.ceil(t / 320 * parseFloat(r.getAttribute("data-height"), 10));
                    t > 320 && (r.style.height = n + "px"), e.id = "resize-img-script-used", e.innerHTML = null
                }();
                </script>
                <div class="custom-white" style="height: 30px;"></div>
                <!-- 魔方 -->
                <div class="custom-cube2-table-wrapper js-lazy-container js-cube2-table-wrap">
                    <table class="custom-cube2-table js-custom-cube2-table" style="visibility: hidden;">
                        <tbody>
                            <tr>
                                <td class="not-empty cols-2 rows-1 " colspan="2" rowspan="1" data-index="0">
                                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=5zy2q55">
                                        <img class="js-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/12/22/Fsz_k3s0sebsqvJxpOydaZQywt1J.jpg!730x0.jpg">
                                    </a>
                                </td>
                                <td class="not-empty cols-2 rows-1 " colspan="2" rowspan="1" data-index="1">
                                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=xqu0ca87">
                                        <img class="js-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/12/22/FiyslbfYbrajQvDyzwZQPogr-B-Z.jpg!730x0.jpg">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="not-empty cols-2 rows-1 " colspan="2" rowspan="1" data-index="2">
                                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=ogyrrmpr">
                                        <img class="js-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/12/22/Frmhq1__x86gJ0DZkkAvmXBSDDqI.jpg!730x0.jpg">
                                    </a>
                                </td>
                                <td class="not-empty cols-2 rows-1 " colspan="2" rowspan="1" data-index="3">
                                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=cl2oidat">
                                        <img class="js-lazy" data-src="https://img.yzcdn.cn/upload_files/2016/03/04/Fg7TvMn7OC7HqABTQvEK8eMRd0AT.jpg!730x0.jpg">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="empty" data-x="0" data-y="2"></td>
                                <td class="empty" data-x="1" data-y="2"></td>
                                <td class="empty" data-x="2" data-y="2"></td>
                                <td class="empty" data-x="3" data-y="2"></td>
                            </tr>
                            <tr>
                                <td class="empty" data-x="0" data-y="3"></td>
                                <td class="empty" data-x="1" data-y="3"></td>
                                <td class="empty" data-x="2" data-y="3"></td>
                                <td class="empty" data-x="3" data-y="3"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="custom-white" style="height: 30px;"></div>
                <!-- 图片广告 -->
                <div class="custom-image-single clearfix">
                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=xqu0ca87">
                        <img class="js-res-load " src="https://img.yzcdn.cn/upload_files/2015/12/22/FpY0NcX-Gk1s-gX1xyQjmSwNCT7K.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                    </a>
                </div>
                <div class="js-goods-list-loading loading" style="min-height: 180px;"></div>
                <ul class="js-goods-list sc-goods-list pic clearfix size-1 " data-size="1" data-showtype="card" style="visibility: hidden;">
                    <!-- 商品区域 -->
                    <!-- 展现类型判断 -->
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/5za17aah" class="js-goods link clearfix" target="_blank" data-goods-id="59284560" title="【特惠】獐子岛野生淡干海参参藏48g 大连海参干货深海野生刺参">
                            <div class="photo-block" data-width="480" data-height="480">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/12/01/Fixih4eQR6sJJ_3D5eagA16nWD1M.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【特惠】獐子岛野生淡干海参参藏48g 大连海参干货深海野生刺参</p>
                                <p class="goods-sub-title c-black hide">淡干海参-参藏 规格：48g 9-15头 产地：中国大连獐子岛</p>
                                <p class="goods-price">
                                    <em>￥599.00</em>
                                </p>
                                <p class="goods-price-taobao ">889</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="5za17aah" data-postage="2200" data-buyway="1" data-id="59284560" data-title="【特惠】獐子岛野生淡干海参参藏48g 大连海参干货深海野生刺参" data-price="599.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/19w0enm0a" class="js-goods link clearfix" target="_blank" data-goods-id="27139956" title="【獐子岛】大连海鲜粉丝扇贝200g*5袋 冷冻半壳虾夷蒜蓉粉丝扇贝">
                            <div class="photo-block" data-width="0" data-height="0">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/04/27/143011175936945987.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【獐子岛】大连海鲜粉丝扇贝200g*5袋 冷冻半壳虾夷蒜蓉粉丝扇贝</p>
                                <p class="goods-sub-title c-black hide">【日销万袋】引爆你的味蕾，快来抢购！200g/袋</p>
                                <p class="goods-price">
                                    <em>￥119.00</em>
                                </p>
                                <p class="goods-price-taobao ">229</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="19w0enm0a" data-postage="2400" data-buyway="1" data-id="27139956" data-title="【獐子岛】大连海鲜粉丝扇贝200g*5袋 冷冻半壳虾夷蒜蓉粉丝扇贝" data-price="119.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/cb2yz6yi" class="js-goods link clearfix" target="_blank" data-goods-id="63618172" title="【热销精品】波士顿大龙虾500g只，鲜活送到家">
                            <div class="photo-block" data-width="800" data-height="800">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/04/28/143020803502261768.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【热销精品】波士顿大龙虾500g只，鲜活送到家</p>
                                <p class="goods-sub-title c-black hide">【进口鲜活精品】波士顿龙虾生活于美国和加拿大交界处寒冷海域，肉较嫩滑细致，味道鲜美，是餐桌上上食材。目前支持活鲜送到家业务。</p>
                                <p class="goods-price">
                                    <em>￥169.00</em>
                                </p>
                                <p class="goods-price-taobao ">289</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="cb2yz6yi" data-postage="0" data-buyway="1" data-id="63618172" data-title="【热销精品】波士顿大龙虾500g只，鲜活送到家" data-price="169.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                </ul>
                <!-- 图片广告 -->
                <div class="custom-image-single clearfix">
                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=xqu0ca87">
                        <img class="js-res-load " src="https://img.yzcdn.cn/upload_files/2015/12/22/FkCviaEraFiyn9aVEHlJ5toY1_Rf.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                    </a>
                </div>
                <div class="js-goods-list-loading loading" style="min-height: 180px;"></div>
                <ul class="js-goods-list sc-goods-list pic clearfix size-1 " data-size="1" data-showtype="card" style="visibility: hidden;">
                    <!-- 商品区域 -->
                    <!-- 展现类型判断 -->
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/10uzdwg8z" class="js-goods link clearfix" target="_blank" data-goods-id="125004948" title="【獐子岛】厄瓜多尔白虾1800g野生南美进口海鲜对虾新鲜冻虾大虾">
                            <div class="photo-block" data-width="500" data-height="500">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/08/19/FlVyXDc0sVVZNGmpOOhTOVb9c22O.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【獐子岛】厄瓜多尔白虾1800g野生南美进口海鲜对虾新鲜冻虾大虾</p>
                                <p class="goods-sub-title c-black hide"></p>
                                <p class="goods-price">
                                    <em>￥179.00</em>
                                </p>
                                <p class="goods-price-taobao ">319</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="10uzdwg8z" data-postage="0" data-buyway="1" data-id="125004948" data-title="【獐子岛】厄瓜多尔白虾1800g野生南美进口海鲜对虾新鲜冻虾大虾" data-price="179.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/1askdt66t" class="js-goods link clearfix" target="_blank" data-goods-id="63616340" title="【热销精品】波士顿大龙虾500g*2/只，鲜活送到家">
                            <div class="photo-block" data-width="800" data-height="800">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/04/28/143020803502261768.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【热销精品】波士顿大龙虾500g*2/只，鲜活送到家</p>
                                <p class="goods-sub-title c-black hide">【进口鲜活精品】波士顿龙虾生活于美国和加拿大交界处寒冷海域，肉较嫩滑细致，味道鲜美，是餐桌上上食材。目前支持活鲜送到家业务。</p>
                                <p class="goods-price">
                                    <em>￥269.00</em>
                                </p>
                                <p class="goods-price-taobao ">539</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="1askdt66t" data-postage="0" data-buyway="1" data-id="63616340" data-title="【热销精品】波士顿大龙虾500g*2/只，鲜活送到家" data-price="269.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/k621f9l4" class="js-goods link clearfix" target="_blank" data-goods-id="30093207" title="【獐子岛】加拿大鳕蟹蟹腿肉200g 进口海鲜蟹棒纯肉雪蟹脚肉10-14枚">
                            <div class="photo-block" data-width="0" data-height="0">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/05/06/143089620628038009.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【獐子岛】加拿大鳕蟹蟹腿肉200g 进口海鲜蟹棒纯肉雪蟹脚肉10-14枚</p>
                                <p class="goods-sub-title c-black hide">【獐子岛】加拿大鳕蟹蟹腿肉100g 进口海鲜蟹棒纯肉雪蟹脚肉5-7枚 【加拿大鳕蟹蟹腿，纯肉】非人工蟹足棒，品质与价格不同于红鳕蟹，目前市面上很多都是红鳕蟹，从原料、价格、产品鲜美度上远不如加拿大产地
                                </p>
                                <p class="goods-price">
                                    <em>￥119.00</em>
                                </p>
                                <p class="goods-price-taobao ">119</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="k621f9l4" data-postage="2400" data-buyway="1" data-id="30093207" data-title="【獐子岛】加拿大鳕蟹蟹腿肉200g 进口海鲜蟹棒纯肉雪蟹脚肉10-14枚" data-price="119.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                </ul>
                <!-- 图片广告 -->
                <div class="custom-image-single clearfix">
                    <a href="https://wap.koudaitong.com/v2/showcase/feature?alias=ogyrrmpr">
                        <img class="js-res-load " src="https://img.yzcdn.cn/upload_files/2015/12/22/Fj2v0TfE_P_O2W7LshFFl5ZHFY9p.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                    </a>
                </div>
                <div class="js-goods-list-loading loading" style="min-height: 180px;"></div>
                <ul class="js-goods-list sc-goods-list pic clearfix size-1 " data-size="1" data-showtype="card" style="visibility: hidden;">
                    <!-- 商品区域 -->
                    <!-- 展现类型判断 -->
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/97gq6ri8" class="js-goods link clearfix" target="_blank" data-goods-id="31695880" title="獐子岛元宝鲍罐头100g 即食鲍鱼罐头 大连海鲜零食皱纹盘鲍 约5只">
                            <div class="photo-block" data-width="0" data-height="0">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/05/11/143131204419113170.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">獐子岛元宝鲍罐头100g 即食鲍鱼罐头 大连海鲜零食皱纹盘鲍 约5只</p>
                                <p class="goods-sub-title c-black hide">獐子岛元宝鲍罐头100g 即食鲍鱼罐头 大连海鲜零食皱纹盘鲍 约5只 色泽鲜润 肉质柔韧 汤汁滑爽 鲜香诱人</p>
                                <p class="goods-price">
                                    <em>￥49.00</em>
                                </p>
                                <p class="goods-price-taobao ">89</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="97gq6ri8" data-postage="2000" data-buyway="1" data-id="31695880" data-title="獐子岛元宝鲍罐头100g 即食鲍鱼罐头 大连海鲜零食皱纹盘鲍 约5只" data-price="49.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/iwgkuiml" class="js-goods link clearfix" target="_blank" data-goods-id="31698954" title="獐子岛海鲜 开罐即食海胆 大连特产 紫海胆罐头100g">
                            <div class="photo-block" data-width="0" data-height="0">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/05/11/14313125962832771.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">獐子岛海鲜 开罐即食海胆 大连特产 紫海胆罐头100g</p>
                                <p class="goods-sub-title c-black hide">獐子岛海鲜 开罐即食海胆 大连特产 紫海胆罐头100g 【獐子岛特产 营养丰富 性价比高】
                                </p>
                                <p class="goods-price">
                                    <em>￥49.00</em>
                                </p>
                                <p class="goods-price-taobao ">89</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="iwgkuiml" data-postage="2000" data-buyway="1" data-id="31698954" data-title="獐子岛海鲜 开罐即食海胆 大连特产 紫海胆罐头100g" data-price="49.00" data-isvirtual="0"></div>
                        </a>
                    </li>
                    <li class="js-goods-card goods-card small-pic card ">
                        <a href="https://h5.koudaitong.com/v2/goods/dqjv2cbc" class="js-goods link clearfix" target="_blank" data-goods-id="31701605" title="【獐子岛】豆豉扇贝罐头100g 大连海鲜罐头 即食扇贝肉  虾夷扇贝">
                            <div class="photo-block" data-width="0" data-height="0">
                                <img class="goods-photo js-goods-lazy" data-src="https://img.yzcdn.cn/upload_files/2015/05/11/143131307616182227.jpg?imageView2/2/w/280/h/280/q/75/format/webp" />
                            </div>
                            <div class="info clearfix info-title info-price btn1">
                                <p class=" goods-title ">【獐子岛】豆豉扇贝罐头100g 大连海鲜罐头 即食扇贝肉 虾夷扇贝</p>
                                <p class="goods-sub-title c-black hide">獐子岛】豆豉扇贝罐头100g 大连海鲜罐头 即食扇贝肉 虾夷扇贝</p>
                                <p class="goods-price">
                                    <em>￥19.90</em>
                                </p>
                                <p class="goods-price-taobao ">49</p>
                            </div>
                            <div class="goods-buy btn1 info-title">
                            </div>
                            <div class="js-goods-buy buy-response" data-alias="dqjv2cbc" data-postage="2000" data-buyway="1" data-id="31701605" data-title="【獐子岛】豆豉扇贝罐头100g 大连海鲜罐头 即食扇贝肉  虾夷扇贝" data-price="19.90" data-isvirtual="0"></div>
                        </a>
                    </li>
                </ul>
                <!-- 图片广告 -->
                <div class="custom-image-single clearfix">
                    <a href="javascript:void(0);">
                        <img class="js-res-load js-view-image-item" src="https://img.yzcdn.cn/upload_files/2015/12/22/Fl9otd11lB6il_W66LXlWJ44_WKE.jpg?imageView2/2/w/730/h/0/q/75/format/webp" />
                    </a>
                </div>
            </div>
            <div class="content-sidebar">
                <a href="https://h5.koudaitong.com/v2/showcase/homepage?kdt_id=1525577" class="link">
                    <div class="sidebar-section shop-card">
                        <div class="table-cell">
                            <img src="https://img.yzcdn.cn/upload_files/2015/04/24/Fh3PysOvhUEkt79zuEka-CM_rsMY.jpg?imageView2/2/w/120/h/120/q/75/format/webp" width="60" height="60" class="shop-img" alt="公众号头像">
                        </div>
                        <div class="table-cell">
                            <p class="shop-name">
                                獐子岛 </p>
                        </div>
                    </div>
                </a>
                <div class="sidebar-section shop-info">
                    <div class="section-detail">
                        <p class="shop-detail">甄选全球高品质海鲜</p>
                        <p class="text-center weixin-title">微信“扫一扫”立即关注</p>
                        <div class="js-follow-qrcode text-center qr-code loading">
                        </div>
                        <p class="text-center weixin-no">微信号：zhangzidao2014</p>
                    </div>
                </div>
            </div>
            <script>
            var showQcode = function() {
                if (typeof $ !== 'undefined') {
                    var $qrcode = $('.js-follow-qrcode');
                    $qrcode.removeClass('js-follow-qrcode'); //兼容图文
                    if ($qrcode.length == 0) return;
                    if (!window._global.mp_data || $qrcode.length <= 0 || (window._global.is_mobile && !(/ipad/gi).test(navigator.userAgent.toLowerCase()))) {
                        return false;
                    }
                    var followQrcodeSrc = 'https://open.weixin.qq.com/qr/code/?username=' + window._global.mp_data.mp_weixin;
                    var img = new Image();
                    img.width = 158;
                    img.height = 158;
                    $(img).on('load', function(event) {
                        $qrcode.append(img).removeClass('loading');
                    });
                    img.src = followQrcodeSrc;
                } else {
                    setTimeout(showQcode, 500);
                }
            };
            showQcode();
            </script>
            <div id="shop-nav"></div>
        </div>
    </div>
    <div class="js-footer" style="min-height: 1px;">
        <div>
            <textarea class="js-lazy" style="display:none;">
                <div class="footer">
                    <div class="copyright">
                        <div class="ft-links">
                            <a href="https://h5.koudaitong.com/v2/showcase/homepage?kdt_id=1525577" target="_blank">店铺主页</a>
                            <a href="https://h5.koudaitong.com/v2/showcase/usercenter?kdt_id=1525577" target="_blank">会员中心</a>
                            <a href="javascript:;" class="js-open-follow">关注我们</a>
                            <!-- 第三方app隐藏topbar时，需要在底部显示购物记录入口 -->
                        </div>
                        <div class="ft-copyright">
                            <a href="https://youzan.com" target="_blank">有赞提供技术支持</a>
                        </div>
                    </div>
                </div>
            </textarea>
        </div>
    </div>
    <script>
    var showcase_js_map = {
        "0": {
            "url": "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/modules\/swp_goods_f44a36ffb5.js",
            "deps": []
        },
        "2": {
            "url": "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/modules\/cube2_e3e0832fef.js",
            "deps": []
        },
        "4": {
            "url": "https:\/\/b.yzcdn.cn\/v2\/vendor\/u_b.js",
            "deps": []
        },
        "5": {
            "url": "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/sku_bd8f517e94.js",
            "deps": ["u_b"]
        },
        "6": {
            "url": "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/modules\/goods_list_9be1661905.js",
            "deps": []
        }
    }
    </script>
    <script>
    "use strict";
    ! function(n, e) {
        "function" == typeof define && define.amd ? define("tiny-loader", [], e(n, n.document)) : n.Loader = e(n, n.document)
    }(this, function(n, e) {
        function t(n) {
            return "complete" === n.readyState || "loaded" === n.readyState
        }

        function o(n, t, o) {
            var i = e.createElement("link");
            i.rel = "stylesheet", a(i, o, "css"), i.async = !0, i.href = n, s.appendChild(i)
        }

        function i(n, t, o) {
            var i = e.createElement("script");
            i.charset = "utf-8", a(i, o, "js"), i.async = !t.sync, i.src = n, s.appendChild(i)
        }

        function c(n, e) {
            var t;
            n.sheet && (t = !0), setTimeout(function() {
                t ? e() : c(n, e)
            }, 20)
        }

        function a(e, o, i) {
            function a() {
                e.onload = e.onreadystatechange = null, e = null, o()
            }
            var r = "onload" in e,
                u = "css" === i;
            return !u || !l && r ? void(r ? (e.onload = a, e.onerror = function() {
                e.onerror = null, n._cdnFallback(e)
            }) : e.onreadystatechange = function() {
                t(e) && a()
            }) : void setTimeout(function() {
                c(e, o)
            }, 1)
        }

        function r(n, e, t, c) {
            function a() {
                var t = e.indexOf(n);
                t > -1 && e.splice(t, 1), 0 === e.length && c()
            }
            f.test(n) ? o(n, t, a) : i(n, t, a)
        }

        function u(n, e, t) {
            var o = function() {
                t && t()
            };
            if (n = Array.prototype.slice.call(n || []), 0 === n.length) return void o();
            for (var i = 0, c = n.length; c > i; i++) r(n[i], n, e, o)
        }

        function d(e, o) {
            if (t(e)) o();
            else {
                var i = 1500,
                    c = !1;
                n.addEventListener("load", function() {
                    c || (o(), c = !0)
                }), setTimeout(function() {
                    c || (o(), c = !0)
                }, i)
            }
        }
        var f = new RegExp("\\.css"),
            s = e.head || e.getElementsByTagName("head")[0],
            l = +navigator.userAgent.replace(/.*(?:AppleWebKit|AndroidWebKit)\/?(\d+).*/i, "$1") < 536,
            y = {
                async: function(n, t) {
                    d(e, function() {
                        u(n, {}, t)
                    })
                },
                sync: function(n, t) {
                    d(e, function() {
                        u(n, {
                            sync: !0
                        }, t)
                    })
                }
            };
        return n.Loader = y, y
    });
    </script>
    <script>
    window.Loader.sync(["https:\/\/b.yzcdn.cn\/v2\/build\/wap\/common_jquery_1f699bf0c2.js", "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/base_7f2eb17256.js", "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/base_6d78ce26fb.js", "https:\/\/b.yzcdn.cn\/v2\/build\/wap\/showcase\/global_icon_80b9b417cf.js"]);
    window.Loader.async(["\/\/hm.baidu.com\/hm.js?58fe4cc4b4af82caeb8bc08af32dd62c"]);
    </script>
</body>

</html>
