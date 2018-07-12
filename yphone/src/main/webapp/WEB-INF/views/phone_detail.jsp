<%@ page import="com.yphone.model.nochange.PhoneInfo" %><%--
  Created by IntelliJ IDEA.
  User: chenhansen
  Date: 2018/7/3
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page isELIgnored="false"%>--%>
<html>
<head>
    <title>E购网</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/global.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/phone-detail.css">
</head>
<body>
<div class="site-topbar">
    <div class="container">
        <div class="topbar-nav">
            <div class="nav-left">
                嗨，欢迎来到
                <span class="cr">E购网</span>
            </div>
            <a href="">网点代售</a>
            <a href="">帮助中心</a>
        </div>
        <div class="topbar-cart">
            <a href="order">我的订单</a>
            <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
            <a href="cart">购物车(<span id="header-cart-total">0</span>)</a>
        </div>
        <div class="topbar-info">
            <div class="" id="login-register">
                <a class="link" href="login" >登录</a>
                <a class="link" href="register">注册</a>
            </div>

            <div class="dropdown" id="user-item">
                <a  class="dropdown-toggle user-item" data-toggle="dropdown"><%=request.getSession().getAttribute("userName")%></a>
                <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="user_info">个人中心</a>
                    </li>
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="quitLogin">退出登录</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<div class="phone_main container clearfix">
    <div class="phone_view">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner myCarousel-inner">
                <div class="item active">
                    <img src="<%=request.getContextPath()%>${phone_info.url1}" alt="First slide">
                </div>
                <div class="item">
                    <img src="<%=request.getContextPath()%>${phone_info.url2}" alt="Second slide">
                </div>
                <div class="item">
                    <img class="inner-img" src="<%=request.getContextPath()%>${phone_info.url3}" alt="Third slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control chevron-left" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left " aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="phone_info ">
        <div class="phone_name"><span class="name">${phone_info.name}</span></div>
        <input type="hidden" id="pid" value="${pid}">
        <hr/>

        <div class="phone_item">
            <span class="name">价格：</span><span class="price">￥ ${phone_info.price}</span></div>
        <div class="phone_item"><span class="name">像素：</span><span class="pixcels">${phone_info.pixels}万</span></div>
        <div class="phone_item"><span class="name">内存：</span><span class="RAM">${phone_info.ram}GB</span></div>
        <div class="phone_item"><span class="name">容量：</span><span class="capacity">${phone_info.capacity}GB</span></div>
        <div class="phone_item"><span class="name">尺寸：</span><span class="size">${phone_info.size}英寸</span></div>
        <div class="phone_item"><span class="name">颜色：</span><span class="color">${phone_info.color}</span></div>

        <div class="phone_stock clearfix">

            <span class="name">数量</span>
            <div class="buy_num">
                <input type="text" class="product-stock-text" id="product-stock-text" value="1" placeholder="1" onKeyUp="value=value.replace(/[^\d]/g,'')">
                <p class="product-stock-btn">
                    <a id="pro-quantity-plus">+</a>
                    <a id="pro-quantity-minus">-</a>
                </p>

            </div>
            <div class="phone_num"><span class="">库存：</span><span class="num" id="phone_info_num">${phone_info.num}</span>件</div>
        </div>
        <div class="buy_phone clearfix">

            <a  class="product-button01">立即下单</a>
            <a href="#" class="product-button02">加入购物车</a>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/static/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/global.js"></script>
<script src="<%=request.getContextPath()%>/static/js/phone-detail.js"></script>

<script>
    $(document).ready(function () {
        var p = '<%=request.getSession().getAttribute("userName")%>';
        loginCheck(p);

    })

</script>
</body>
</html>
