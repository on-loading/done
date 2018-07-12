<%--
  Created by IntelliJ IDEA.
  User: chenhansen
  Date: 2018/7/7
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/global.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/user_msg.css">

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
            <div class="dropdown" id="user-item" style="display: block">
                <a  class="dropdown-toggle user-item" data-toggle="dropdown"><%=request.getSession().getAttribute("userName")%></a>
                <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="#">个人中心</a>
                    </li>
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="quitLogin">退出登录</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<div class="site-header">
    <div class="container container-head">
        <div class="header-logo">
            <a class="logo ir" href="home" title="E购网">
                <img class="imgstyle" src="<%=request.getContextPath()%>/static/images/logo.png" alt="E购网">
            </a>
        </div>
        <div class="header-nav">
            <ul class="nav navbar-nav header-navbar-nav">
                <li class="nav-item">
                    <a href="#">
                        <span>华为</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="#">
                        <span>小米</span>
                    </a>

                </li>
                <li class="nav-item">
                    <a href="#">
                        <span>荣耀</span>
                    </a>

                </li>
                <li class="nav-item">
                    <a href="#">
                        <span>iphone</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#">
                        <span>vivo</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#">
                        <span>oppo</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#">
                        <span>魅族MEIZU</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="header-search">
            <form class="search-text" method="GET">
                <div class="input-group">
                    <input class="form-control phone" name="phone" id="login_phone" required placeholder="华为" maxlength="11" autocomplete="off"
                           type="text">
                    <div class="search-icon input-group-addon">
                        <span class="glyphicon glyphicon-zoom-out" aria-hidden="true"></span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="breadcrumbs"></div>
<div class="page-main user-main">
    <div class="container">
        <div class="span4">
            <dic class="uc-box">
                <div class="uc-nav-box">
                    <div class="box-hd">
                        <h3 class="title">订单管理</h3>
                    </div>
                    <div class="box-bd">
                        <ul class="uc-nav-list">
                            <li class="active">
                                <a href="#">
                                    我的订单
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    意外保
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    团购订单
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    评晒订单
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    话费充值订单
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="uc-nav-box">
                    <div class="box-hd">
                        <h3 class="title">个人中心</h3>
                    </div>
                    <div class="box-bd">
                        <ul class="uc-nav-list">
                            <li>
                                <a href="#">
                                    个人信息
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    修改密码
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    消息通知
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    现金账户
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    收货地址
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </dic>
        </div>
        <div class="span16">
            <div class="uc-box">
                <div class="uc-content-box">
                    <div class="box-hd">
                        <h1 class="title">
                            我的订单
                        </h1>
                        <div class="more clearfix">
                            <ul class="filter-list clearfix">
                                <li class="first active">全部有效订单</li>
                                <li>待支付</li>
                                <li>待收货</li>
                                <li>已关闭</li>
                            </ul>
                            <form method="get" action="#" class="search-form clearfix">
                                <div class="input-group">
                                    <input class="form-control phone" name="keyWords" id="J_keyWords" required placeholder="请输入商品名称、订单号"  autocomplete="off" type="text">
                                    <div class="search-icon input-group-addon">
                                        <span class="glyphicon glyphicon-zoom-out" aria-hidden="true"></span>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="box-bd">
                        <div id="J_orderList">
                            <p class="empty">当前没有交易订单</p>
                        </div>
                        <div id="J_orderListPages">
                            <div class="">
                                <table class="table detail table-bordered">
                                    <thead>
                                    <tr>
                                        <th class="col-pro">商品</th>
                                        <th class="col-price">单价</th>
                                        <th class="col-num">数量</th>
                                        <th class="col-total">总计</th>
                                        <th class="col-status">订单状态及操作</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                            <ul>
                                <li>
                                    <div>
                                        <span class="order-time">2018/7/6 08:30:32</span>
                                        订单号:<span class="orderNum">13535362343</span>
                                    </div>
                                    <table class="table table-bordered">
                                        <tbody>

                                        <tr>
                                            <td class="col-pro">小米6 4GB+32GB,流沙金</td>
                                            <td class="col-price">1200.00</td>
                                            <td class="col-num">2</td>
                                            <td class="col-total">2400.00</td>
                                            <td class="col-status">订单详情</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="<%=request.getContextPath()%>/static/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
</body>

</html>
